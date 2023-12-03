// ignore_for_file: prefer_const_constructors, prefer_const_literals_to_create_immutables

import 'dart:convert';
import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter_application_1/models/post.dart';
import 'package:flutter_application_1/services/remote_serveices.dart';

class first_page extends StatefulWidget {
  const first_page({super.key});

  @override
  State<first_page> createState() => _first_page();
}



class _first_page extends State<first_page> {
 
  @override 
  Widget build(BuildContext context){
      double textSizeForTable = 13.8;
     
        return Container(
          color: const Color.fromARGB(255, 255, 204, 142),
          child: FutureBuilder<List<Posts>>(
            future: RemoteService().getPosts(),
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
                      //alignment: Alignment.topLeft,
                      //padding: EdgeInsets.all(40),
                      //color: Color.fromARGB(255, 255, 255, 255),
                      child: Container(
                        //margin: EdgeInsets.all(20),
                        child: DataTable(
                          dataTextStyle: TextStyle(fontSize: textSizeForTable),
                          
                          // dataRowMinHeight: 48,
                          // dataRowMaxHeight: 60,
                          horizontalMargin: 10,
                          border: const TableBorder(
                            horizontalInside: BorderSide(color: Color.fromARGB(255, 255, 204, 142), width: 2.5),
                            //bottom: BorderSide(color: Color.fromARGB(255, 255, 255, 255), width: 0.5)
                          ),
                          //padding: EdgeInsets.all(20),
                          columns: [
                            DataColumn(label: Text('Место',
                            style: TextStyle(color: Color.fromARGB(255, 47, 126, 113), fontSize: textSizeForTable),
                            )),
                            
                            DataColumn(label: Text('Регион',
                            style: TextStyle(color: Color.fromARGB(255, 47, 126, 113), fontSize: textSizeForTable),
                            )),
                            
                            DataColumn(label: Text('Баллы',
                            style: TextStyle(color: Color.fromARGB(255, 47, 126, 113), fontSize: textSizeForTable),
                            )),
                          ],
                          rows: List<DataRow>.generate(length, (index) => DataRow(
                            cells: <DataCell>[
                              
                              DataCell(Text('${index + 1}',
                              style: TextStyle(color: Color.fromARGB(255, 47, 126, 113)),
                              )),
                              
                              DataCell(Text('${post[index].name}',
                              style: TextStyle(color: Color.fromARGB(255, 47, 126, 113)),
                              )),
                              
                              DataCell(Text('${post[index].score}',
                              style: TextStyle(color: Color.fromARGB(255, 47, 126, 113)),
                              ))

                              ]
                            
                          )),
                        ),
                        ),
                      )
                  )
                );
              }
            }
          )
        );
      
  }


}
