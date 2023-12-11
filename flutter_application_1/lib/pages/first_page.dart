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

TextEditingController controller = TextEditingController();
 var place = new Map();
 String search = '';

@override
void initState() {
    super.initState();
    RemoteService().getPosts('').then((value) {
      for (var i = 0; i < value.length; i ++){
        place[value[i].id] = i + 1;
      }
    });
  }

  @override 
  Widget build(BuildContext context){
      double textSizeForTable = 13.8;
      Color colorForBackGround = Color.fromARGB(255, 255, 204, 142);
      Color colorForText = Color.fromARGB(255, 47, 126, 113);
      Color colorFromAppBarBack = Color.fromARGB(255, 146, 194, 186);

        return Container(
          color: const Color.fromARGB(255, 255, 204, 142),
          child: FutureBuilder<List<Posts>>(
            future: RemoteService().getPosts(search),
            builder: (BuildContext context, AsyncSnapshot<List<Posts>> snapshot){
              if (snapshot.connectionState == ConnectionState.waiting){
                return Center(child: CircularProgressIndicator());
              } else if (snapshot.hasError){
                return Text('Error: ${snapshot.error}');
              } else {
                final post = snapshot.data;
                final length = post!.length;
                return SingleChildScrollView(
                  child: ClipRRect(
                    borderRadius: BorderRadius.circular(40.5),
                    child: Container(
                      
                      color: Color.fromARGB(255, 255, 255, 255),
                      margin: EdgeInsets.all(10),
                      child: Column(
                        children:[ 

                          Container(
                            alignment: Alignment.centerLeft,
                            margin: EdgeInsets.only(left: 10, top: 15, bottom: 10),
                            child: Text(
                            'Рейтинг привелкательности регионов',
                            style: TextStyle(color: colorForText, fontSize: textSizeForTable, fontWeight: FontWeight.w500),
                            ),
                          ),

                          Container(
                            child: ListTile(
                              dense: true,
                              contentPadding: EdgeInsets.only(left: 10),
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
                                onSubmitted: (value) {
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
                          

                          DataTable(
                            showCheckboxColumn: false,
                            dataTextStyle: TextStyle(fontSize: textSizeForTable),
                            horizontalMargin: 10,
                            border: const TableBorder(
                              horizontalInside: BorderSide(color: Color.fromARGB(255, 255, 204, 142), width: 2.5),
                            ),
                            columns: [
                              DataColumn(label: Text('Место',
                              style: TextStyle(color: colorForText, fontSize: textSizeForTable),
                              )),
                              
                              DataColumn(label: Text('Регион',
                              style: TextStyle(color: colorForText, fontSize: textSizeForTable),
                              )),
                              
                              DataColumn(label: Text('Баллы',
                              style: TextStyle(color: colorForText, fontSize: textSizeForTable),
                              )),
                            ],
                            rows: List<DataRow>.generate(length, (index) => DataRow(
                             onSelectChanged: (x) => NavigationBetweenPage(context, post[index].id), 
                             cells: <DataCell>[
                                
                                DataCell(Text('${place[post[index].id]}',
                                style: TextStyle(color: colorForText),
                                ), ),
                                
                                
                                DataCell(Text('${post[index].name}',
                                style: TextStyle(color: colorForText),
                                ),),
                                
                                DataCell(Text('${post[index].score}',
                                style: TextStyle(color: colorForText),
                                ), )

                              ]
                              
                            )),
                          ),
                        ]
                        ),
                      )
                  )
                );
              }
            }
          )
        );
      
  }

 void NavigationBetweenPage(BuildContext context, int regionsId){
    Navigator.of(context).push(MaterialPageRoute(builder: (context) => new second_page(regionsId: regionsId,)));
  }

}
