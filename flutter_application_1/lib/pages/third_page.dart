import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter_application_1/models/projection_criteria.dart';
import 'package:flutter_application_1/services/remote_serveices.dart';
import 'package:flutter_application_1/widget/criteria_table.dart';

class third_page extends StatefulWidget {
  third_page({super.key});
  @override
  State<third_page> createState() => _third_page();
}

class _third_page extends State<third_page> {
  final Future<List<ProjectionCriteria>> _data =
      RemoteService().getProjections();

  @override
  Widget build(BuildContext context) {
    return Container(
        color: const Color.fromARGB(255, 255, 204, 142),
        child: SingleChildScrollView(
            child: FutureBuilder<List<ProjectionCriteria>>(
          future: _data,
          builder: (BuildContext context,
              AsyncSnapshot<List<ProjectionCriteria>> snapshot) {
            Widget child;
            if (snapshot.hasData) {
              child = CriteriaTable(data: snapshot.requireData);
            } else if (snapshot.hasError) {
              child = const Text('pizdec');
            } else {
              child = const SizedBox(
                width: 60,
                height: 60,
                child: CircularProgressIndicator(),
              );
            }
            return child;
          },
        )));
  }
}
