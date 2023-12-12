// ignore_for_file: prefer_const_constructors, no_logic_in_create_state

import 'package:flutter/material.dart';
import 'package:flutter_application_1/models/post.dart';
import 'package:flutter_application_1/models/rating.dart';
import 'package:flutter_application_1/pages/first_page.dart';
import 'package:flutter_application_1/services/remote_serveices.dart';
import 'dart:convert';
import 'dart:io';


class second_page extends StatefulWidget{
  int regionId;

  second_page ({super.key, required this.regionId});
  @override
  State<second_page> createState() => _second_page(regionId: regionId);

  int getRegionsId(){
    return regionId;
  }
}

class _second_page extends State<second_page>{
  int regionId;
  double textSizeForTable = 13.8;
  Color colorForBackGround = Color.fromARGB(255, 255, 204, 142);
  Color colorForText = Color.fromARGB(255, 47, 126, 113);
  Color colorFromAppBarBack = Color.fromARGB(255, 146, 194, 186);
  final String iconsPath = 'assets/images/criteria/';

  _second_page({required this.regionId});


  @override
  Widget build(BuildContext context){
    return Container (
      child: Scaffold(
        appBar: AppBar(
          title: Text('МПРР'),
          backgroundColor: colorFromAppBarBack,
          foregroundColor: colorForText,
          scrolledUnderElevation: 4.0,
          shadowColor: Theme.of(context).shadowColor,
        ),
      body: Container(
        color: Color.fromARGB(255, 255, 204, 142),
        child: FutureBuilder<Rating>(
          future: RemoteService().getRating(regionId),
          builder: (BuildContext context, AsyncSnapshot<Rating> snapshot){
            if (snapshot.connectionState == ConnectionState.waiting){
                return Center(child: CircularProgressIndicator());
              } else if (snapshot.hasError){
                return Text('Error: ${snapshot.error}');
              } else {
                final post = snapshot.data;
                // final length = post!.length;
                return SingleChildScrollView(
                  child: ClipRRect(
                    child: Container(
                     margin: EdgeInsets.only(top: 5, bottom: 15, left: 10, right: 10),
                     color: colorForBackGround,
                     child: Column(
                       children: [
                        Container(
                          alignment: Alignment.topCenter,
                          margin: EdgeInsets.only(bottom: 15, top: 10),
                          color: Colors.white,
                          child: Column(
                            children:[
                              
                              Container(
                                margin: EdgeInsets.only(top: 10),
                              child: Text('${post?.name}', style: TextStyle(color: colorForText, fontSize: textSizeForTable + 1, fontWeight: FontWeight.w500)),
                              ),

                              Container(
                                margin: EdgeInsets.all(10),
                                alignment: Alignment.centerLeft,
                                child: Text('Москва - столица России и крупнейший город страны. Это огромный мегаполис, который является историческим, политическим и духовным сердцем Российской Федерации. Москва - крупнейшая столица Европы, наполненная достопримечательностями, памятниками истории и культуры, а также музеями мирового уровня. Это город невероятной динамики и размеров, который невозможно объять за одну поездку. Столица России существует уже около девяти веков. На её улочках можно встретить старинные сакральные памятники и дворцы, которые соседствуют с монументальными зданиями советской архитектуры и ультрасовременными сооружениями. Но не только этим славится Москва. ', style: TextStyle(color: colorForText, fontSize: textSizeForTable),)
                              ),
                            ],
                          )
                        ),
                        ClipRRect(
                          borderRadius: BorderRadius.all(Radius.circular(5)),
                          child: Container(
                            color: Colors.white,
                            child: DataTable(
                              // dataRowMinHeight: 49,
                              // dataRowMaxHeight: 60,
                              //horizontalMargin: 35,
                              columnSpacing: 32,
                              dataTextStyle: TextStyle(fontSize: textSizeForTable),
                              // horizontalMargin: 27,
                              border: const TableBorder(
                                horizontalInside: BorderSide(color: Color.fromARGB(255, 255, 204, 142), width: 2.5),
                              ),
                              columns: [
                                DataColumn(label: Text('Место', style: TextStyle(color: colorForText, fontSize: textSizeForTable),)),
                                DataColumn(label: Text('Критерий', style: TextStyle(color: colorForText, fontSize: textSizeForTable))),
                                DataColumn(label: Text('')),
                                DataColumn(label: Text('Баллы', style: TextStyle(color: colorForText, fontSize: textSizeForTable))),
                              ],
                              rows: List<DataRow>.generate(post!.projections.length, (index) => DataRow(
                                cells: <DataCell>[
                                  DataCell(Text('${post.projections[index].place}', style: TextStyle(color: colorForText, fontSize: textSizeForTable))),
                                  DataCell(Text('${post.projections[index].projection.name}', style: TextStyle(color: colorForText, fontSize: textSizeForTable),)),
                                  DataCell(Image(image: AssetImage('${iconsPath + post.projections[index].projection.id.toString()}.png',), width: 30, height: 30, alignment: Alignment.centerRight,)),
                                  DataCell(Text('${post.projections[index].score}', style: TextStyle(color: colorForText, fontSize: textSizeForTable))),
                                ]
                              ))
                          ),
                          )
                            
                        )
                      ],
                     ),
                     
                    )
                  ),
                );
              }
          }
        )
        ),
      ),
    );
  }
}