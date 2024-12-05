// ignore_for_file: prefer_const_constructors, prefer_const_literals_to_create_immutables

import 'dart:convert';
import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter_application_1/models/post.dart';
import 'package:flutter_application_1/models/projection_criteria.dart';
import 'package:flutter_application_1/pages/second_page.dart';
import 'package:flutter_application_1/services/remote_serveices.dart';
import 'package:http/http.dart';

class first_page extends StatefulWidget {
  const first_page({super.key});

  @override
  State<first_page> createState() => _first_page();
}



class _first_page extends State<first_page> {

  double textSizeForTable = 13.8;
  Color colorForBackGround = Color.fromARGB(255, 255, 204, 142);
  Color colorForText = Color.fromARGB(255, 47, 126, 113);
  Color colorFromAppBarBack = Color.fromARGB(255, 146, 194, 186);

  TextEditingController controller = TextEditingController();
  var place = new Map();
  String search = '';

  @override
  void initState() {
    super.initState();
  }

  @override 
  Widget build(BuildContext context){
      double textSizeForTable = 13.8;
      Color colorForBackGround = Color.fromARGB(255, 255, 204, 142);
      Color colorForText = Color.fromARGB(255, 47, 126, 113);
      Color colorFromAppBarBack = Color.fromARGB(255, 146, 194, 186);

      return new Scaffold( 
        body: Container(
          color: const Color.fromARGB(255, 255, 204, 142),
          child: Container(
                  margin: EdgeInsets.symmetric(horizontal: 10, vertical: 15),
                  child: ClipRRect(
                    borderRadius: BorderRadius.all(Radius.circular(10)),
                    child: Container(
                      color: Color.fromARGB(255, 255, 255, 255),
                      padding: EdgeInsets.all(10),
                      child: Column(
                        children: <Widget>[ 
                          Padding(
                            padding: EdgeInsets.symmetric(vertical: 10),
                            child: ListTile(
                              dense: true,
                              contentPadding: EdgeInsets.only(left: 5),
                              title: TextField(
                                controller: controller,
                                style: TextStyle(color: Colors.white, fontSize: textSizeForTable),
                                decoration: InputDecoration(
                                  filled: true,
                                  fillColor: colorFromAppBarBack,
                                  hintText: 'Поиск региона...', 
                                  hintStyle: TextStyle(color: Colors.white),
                                  border: InputBorder.none,
                                ),
                                onChanged: (value) {
                                  setState(() {
                                    search = value;
                                  });
                                }
                              ),
                              trailing: IconButton(
                                onPressed: () {
                                  setState(() {
                                    controller.clear();
                                    search = '';
                                  });
                                },
                                focusColor: colorFromAppBarBack,
                                icon: Icon(Icons.cancel, color: colorFromAppBarBack),
                              ),
                            ),
                          ),
                          Expanded(
                            child: FutureBuilder<List<List<Posts>>>(
                              future: Future.wait([RemoteService().getPosts(search), RemoteService().getPosts('')]),
                              builder: (BuildContext context, AsyncSnapshot<List<List<Posts>>> snapshot){
                                if (snapshot.connectionState == ConnectionState.waiting){
                                  return Center(child: CircularProgressIndicator());
                                } 
                                else if (snapshot.hasError){
                                  return Text('Error: ${snapshot.error}');
                                } 
                                else {
                                  final post = snapshot.data![0];
                                  final itemsCount = post.length;
                                  for (var i = 0; i < snapshot.data![1].length; i++) {
                                    place[snapshot.data![1][i].id] = i + 1;
                                  }
                                  return ListView.builder(
                                    itemCount: 1,
                                    shrinkWrap: true,
                                    itemBuilder: (context, index) {
                                      return DataTable(
                                        dataRowMinHeight: 50,
                                        dataRowMaxHeight: 75,
                                        showCheckboxColumn: false,
                                        columnSpacing: MediaQuery.of(context).size.width * 0.1,
                                        dataTextStyle: TextStyle(fontSize: textSizeForTable),
                                        horizontalMargin: 10,
                                        border: const TableBorder(
                                          horizontalInside: BorderSide(color: Color.fromARGB(255, 255, 204, 142), width: 2.5),
                                        ),
                                        columns: [
                                          DataColumn(label: Expanded(child: Text('Место',
                                          style: TextStyle(color: colorForText, fontSize: textSizeForTable),
                                          ))),
                                          
                                          DataColumn(label: Expanded(child: Text('Регион',
                                          style: TextStyle(color: colorForText, fontSize: textSizeForTable),
                                          ))),
                                          
                                          DataColumn(label: Expanded(child: Text('Баллы',
                                          style: TextStyle(color: colorForText, fontSize: textSizeForTable),
                                          ))),
                                        ],
                                        rows: List<DataRow>.generate(itemsCount, (index) => DataRow(
                                        onSelectChanged: (x) => NavigationBetweenPage(context, post[index].id), 
                                        cells: <DataCell>[
                                            DataCell(Text('${place[post[index].id]}',
                                            style: TextStyle(color: colorForText),),),
                                            
                                            DataCell(Text('${post[index].name}',
                                            style: TextStyle(color: colorForText),),),
                                            
                                            DataCell(Text('${post[index].score}',
                                            style: TextStyle(color: colorForText),),)
                                          ]
                                        )),
                                      );
                                    }
                                  );
                                }
                              },
                            )
                          )
                        ]
                      ),
                    )
                  )
                )
        )
      );
    }

 void NavigationBetweenPage(BuildContext context, int regionId){
    Navigator.of(context).push(MaterialPageRoute(builder: (context) => new second_page(regionId: regionId,)));
  }
}
