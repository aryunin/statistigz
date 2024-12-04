import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter_application_1/services/remote_serveices.dart';
import 'package:awesome_snackbar_content/awesome_snackbar_content.dart';


class SurveyPage extends StatefulWidget {
  @override
  _SurveyPageState createState() => _SurveyPageState();
}

class _SurveyPageState extends State<SurveyPage> {
  final Map<String, Object> _selectedOptions = {};
  var answers = [];
  var survey;
  Color colorForText = const Color.fromARGB(255, 47, 126, 113);
  void _selectOption(String question, Object option, int index) {
    setState(() {
      _selectedOptions[question] = option;
      answers[index] = option;
    });
  }

  Future<void> loadJsonSurvey() async {
      final String survey_string = await rootBundle.loadString('assets/survey.json');
      var data_survey = jsonDecode(survey_string);
      setState(() {
        survey = data_survey;
        answers = List<int>.filled(survey['questions'].length, 0);
      });
    }

  @override initState() {
    super.initState();
    loadJsonSurvey();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color.fromARGB(255, 255, 204, 142),
      appBar: AppBar(
        backgroundColor: const Color.fromARGB(255, 255, 204, 142),
        centerTitle: true,
        title: const Text('Опросник',
          style: TextStyle(color: Colors.black, fontSize: 16)),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.only(bottom: 20, top: 5, left: 20, right: 20),
        child: survey != null ?
          Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              for (var i=0; i < survey['questions'].length; i++)
                _buildQuestion(survey['questions'][i]['question'], survey['questions'][i]['options'], i),
              const SizedBox(height: 20.0),
              ElevatedButton(
                onPressed: () async {
                  if ((answers.where((element) => element == 0)).isNotEmpty) {
                    final snackBar = SnackBar(
                      elevation: 0,
                      behavior: SnackBarBehavior.floating,
                      backgroundColor: Colors.transparent,
                      content: AwesomeSnackbarContent(
                        title: 'On Snap!',
                        message: 'Не на все вопросы даны ответы',
                        contentType: ContentType.failure,
                      ),
                    );
                    ScaffoldMessenger.of(context)..hideCurrentSnackBar()..showSnackBar(snackBar);
                  } else {
                      try {
                        final regions = await RemoteService().getRegionIds(answers);
                        final nameRegions = regions.map((element) => element.name).join(', ');
                        final snackBar = SnackBar(
                          elevation: 0,
                          behavior: SnackBarBehavior.floating,
                          backgroundColor: Colors.transparent,
                          content: SizedBox(
                            height: 200,
                            width: 100,
                            child: AwesomeSnackbarContent(
                              title: 'Рекомендованные Вам регионы',
                              message: nameRegions.isNotEmpty? nameRegions : 'Что то пошло не так',
                              contentType: ContentType.success,
                            )
                          )
                        );
                        ScaffoldMessenger.of(context)..hideCurrentSnackBar()..showSnackBar(snackBar);
                      } catch (e) {
                        final snackBar = SnackBar(
                          elevation: 0,
                          behavior: SnackBarBehavior.floating,
                          backgroundColor: Colors.transparent,
                          content: AwesomeSnackbarContent(
                            title: 'Рекомендованные Вам регионы',
                            message: 'Что то пошло не так',
                            contentType: ContentType.failure,
                          ),
                        );
                        ScaffoldMessenger.of(context)..hideCurrentSnackBar()..showSnackBar(snackBar);
                      }
                    }
                },
                child: const Text('Отправить'),
              ),
            ],
          ) : const CircularProgressIndicator(),
      ),
    );
  }

  Widget _buildQuestion(String question, List<dynamic> options, int index) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        ClipRRect(
          borderRadius: const BorderRadius.only(topLeft: Radius.circular(5), topRight: Radius.circular(5)),
          child: Container(
            color: const Color.fromARGB(255, 255, 255, 255),
            padding: const EdgeInsets.all(10),
            width: MediaQuery.of(context).size.width,
            child: Text(
              question,
              style: TextStyle(fontSize: 13.8, color: colorForText),
            ),
          )
        ),
        const SizedBox(height: 3.0),
        ClipRRect(
          borderRadius: const BorderRadius.only(bottomRight: Radius.circular(5), bottomLeft: Radius.circular(5)),
          child: Container(
            color: const Color.fromARGB(255, 255, 255, 255),
            child: Column(
              children: options.map((option) {
                return RadioListTile(
                  title: Text(option,
                    style: TextStyle(fontSize: 13.8, color: colorForText), 
                  ),
                  value: options.indexOf(option) + 1,
                  groupValue: _selectedOptions[question],
                  onChanged: (value) {
                    _selectOption(question, value!, index);
                  },
                );
              }).toList(),
            )
          )
        ),
        const SizedBox(height: 50.0),
      ]
    );
  }
}