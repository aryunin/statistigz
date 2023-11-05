import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter_application_1/models/projection_criteria.dart';
import 'package:flutter_application_1/services/remote_serveices.dart';
import 'package:flutter_application_1/widget/criteria_table.dart';

class third_page extends StatefulWidget {
  third_page({super.key});
  @override
  State<third_page> createState() => _root_state();
}

class _root_state extends State<third_page> {
  late list_criteria mainPage;
  late Widget currentPage;

  void callback(Widget newPage) {
    setState(() {
      currentPage = newPage;
    });
  }

  @override
  void initState() {
    super.initState();
    mainPage = list_criteria(callback: callback);
    currentPage = mainPage;
  }

  @override
  Widget build(BuildContext context) {
    return currentPage;
  }
}

class list_criteria extends StatelessWidget {
  final Future<List<ProjectionCriteria>> _data =
      RemoteService().getProjections();
  final Function callback;

  list_criteria({super.key, required this.callback});

  @override
  Widget build(BuildContext context) {
    return Container(
        padding: const EdgeInsets.fromLTRB(
            25, 0, 25, 0), // TODO разобраться с паддингами
        color: const Color.fromARGB(255, 255, 204, 142),
        child: FutureBuilder<List<ProjectionCriteria>>(
          future: _data,
          builder: (BuildContext context,
              AsyncSnapshot<List<ProjectionCriteria>> snapshot) {
            Widget child;
            if (snapshot.hasData) {
              child = SingleChildScrollView(
                  // TODO requreData нехорошо, наверное
                  child: CriteriaTable(
                      data: snapshot.requireData,
                      callback: (int criteriaId) => callback(clicked_criteria(
                          criteriaId: criteriaId, callback: callback))));
            } else if (snapshot.hasError) {
              child = const Text(
                  'pizdec'); // TODO сделать общее сообщение об ошибке
            } else {
              child = const Center(
                  child: SizedBox(
                width: 60,
                height: 60,
                child: CircularProgressIndicator(
                    color: Color.fromARGB(255, 31, 76, 106)),
              ));
            }
            return child;
          },
        ));
  }
}

class clicked_criteria extends StatelessWidget {
  final int criteriaId;
  final Function callback;

  const clicked_criteria(
      {super.key, required this.criteriaId, required this.callback});

  @override
  Widget build(BuildContext context) {
    // TODO вот тут надо показывать табличку как на главной страничке
    // Т.е. тут нужен тоже FutureBuilder, который подтянет данные по
    // /regions?projectionId=criteriaId
    // И эти данные нужно затолкать в виджет таблички.
    // TODO вынести цвета в схему
    return Container(
        color: const Color.fromARGB(255, 255, 204, 142),
        child: Center(
            child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
              Text('Clicked id $criteriaId'),
              TextButton(
                style: ButtonStyle(
                  foregroundColor:
                      MaterialStateProperty.all<Color>(Colors.blue),
                ),
                child: const Text('Back'),
                onPressed: () => callback(list_criteria(callback: callback)),
              ),
            ])));
  }
}
