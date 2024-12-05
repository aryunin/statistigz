import 'dart:math';

import 'package:flutter/material.dart';
import 'package:flutter_application_1/models/projection_criteria.dart';
import 'package:flutter_application_1/models/ratingProjection.dart';
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
                  'something goes wrong'); // TODO сделать общее сообщение об ошибке
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
    double textSizeForTable = 13.8;
      Color colorForBackGround = Color.fromARGB(255, 255, 204, 142);
      Color colorForText = Color.fromARGB(255, 47, 126, 113);
      Color colorFromAppBarBack = Color.fromARGB(255, 146, 194, 186);
    return Container(
      color: colorForBackGround,
      child: FutureBuilder<List<RatingProjection>>(
        future: RemoteService().getRatingProjection(criteriaId),
        builder: (BuildContext context, AsyncSnapshot<List<RatingProjection>> snapshot){
          if (snapshot.connectionState == ConnectionState.waiting){
            return Center(child: CircularProgressIndicator());
          } else if (snapshot.hasError) {
            return Text('Error: ${snapshot.error}');
          } else {
            final post = snapshot.data;
            final length = post!.length;
            return SingleChildScrollView(
              child: ClipRRect(
                borderRadius: BorderRadius.all(Radius.circular(20)),
                child: Container(
                    margin: EdgeInsets.all(10),
                    color: Colors.white,
                    child: DataTable(
                      dataRowMinHeight: 50,
                      dataRowMaxHeight: 75,
                      horizontalMargin: 15,
                      columnSpacing: MediaQuery.of(context).size.width * 0.1,
                      dataTextStyle: TextStyle(fontSize: textSizeForTable),
                      border: const TableBorder(horizontalInside: BorderSide(color: Color.fromARGB(255, 255, 204, 142), width: 2.5)),
                      columns: [
                        DataColumn(label: Text('Место', style: TextStyle(color: colorForText, fontSize: textSizeForTable),)),
                        DataColumn(label: Text('Регион', style: TextStyle(color: colorForText, fontSize: textSizeForTable))),
                        DataColumn(label: Text('Баллы', style: TextStyle(color: colorForText, fontSize: textSizeForTable),)),
                      ],

                      rows: List<DataRow>.generate(length, (index) => DataRow(
                        cells: <DataCell> [
                          
                          DataCell(Text('${index + 1}', style: TextStyle(color: colorForText, fontSize: textSizeForTable),)),

                          DataCell(Text('${post[index].name}', style: TextStyle(color: colorForText, fontSize: textSizeForTable),)),

                          DataCell(Text('${post[index].score}', style: TextStyle(color: colorForText, fontSize: textSizeForTable))),
                        ]
                      ))
                    )
                  )
                ),
              );
          }
        }  
      )
    );
  }
}
