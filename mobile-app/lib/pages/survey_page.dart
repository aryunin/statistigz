import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter/services.dart' show rootBundle;


class SurveyPage extends StatefulWidget {
  @override
  _SurveyPageState createState() => _SurveyPageState();
}

class _SurveyPageState extends State<SurveyPage> {
  Map<String, Object> _selectedOptions = {};
  var answers = [];
  var survey;
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
      backgroundColor: Color.fromARGB(255, 255, 204, 142),
      appBar: AppBar(
        backgroundColor: Color.fromARGB(255, 255, 204, 142),
        title: Text('Опросник',
          style: TextStyle(color: Colors.black, fontSize: 16)),
      ),
      body: SingleChildScrollView(
        padding: EdgeInsets.all(20.0),
        child: survey != null ?
          Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              for (var i=0; i < survey['questions'].length; i++)
                _buildQuestion(survey['questions'][i]['question'], survey['questions'][i]['options'], i),
              SizedBox(height: 20.0),
              ElevatedButton(
                onPressed: () {
                  String message;
                  if (!(answers.where((element) => element == 0)).isEmpty) {
                    message = 'Not all questions';
                  } else {
                    message = 'Your answers were posted';
                  }
                  final snackBar = SnackBar(
                    content: Text(message),
                  );
                  ScaffoldMessenger.of(context).showSnackBar(snackBar);
                  print(answers);
                },
                child: Text('Отправить'),
              ),
            ],
          ) : CircularProgressIndicator(),
      ),
    );
  }

  Widget _buildQuestion(String question, List<dynamic> options, int index) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: <Widget>[
        Text(
          question,
          style: TextStyle(fontSize: 13.8, color: Colors.black),
        ),
        SizedBox(height: 10.0),
        Column(
          children: options.map((option) {
            return RadioListTile(
              title: Text(option,
                style: TextStyle(fontSize: 13.8, color: Colors.black), 
              ),
              value: options.indexOf(option) + 1,
              groupValue: _selectedOptions[question],
              onChanged: (value) {
                _selectOption(question, value!, index);
              },
            );
          }).toList(),
        ),
        SizedBox(height: 20.0),
      ],
    );
  }
}