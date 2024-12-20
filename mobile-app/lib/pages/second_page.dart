// ignore_for_file: prefer_const_constructors, no_logic_in_create_state

import 'package:flutter/material.dart';
import 'package:mprr/models/rating.dart';
import 'package:mprr/services/remote_serveices.dart';


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
              } 
              else if (snapshot.hasError){
                return Text('Error: ${snapshot.error}');
              }
              else {
                final post = snapshot.data;
                return Container(
                  color: colorForBackGround,
                  child: ListView(
                    children: <Widget>[
                      Container(
                        margin: EdgeInsets.only(left: 10, right: 10, top: 5, bottom: 5),
                        child: Container(
                          alignment: Alignment.topCenter,
                          margin: EdgeInsets.only(bottom: 15, top: 10),
                          color: Colors.white,
                          child: Column(
                            children:[
                              
                              Container(
                                margin: EdgeInsets.only(top: 10),
                                child: Text('${post?.name}',
                                  style: TextStyle(
                                    color: colorForText, 
                                    fontSize: textSizeForTable + 1, 
                                    fontWeight: FontWeight.w500
                                  )
                                ),
                              ),

                              Container(
                                margin: EdgeInsets.all(10),
                                alignment: Alignment.centerLeft,
                                child: Text(post!.description, 
                                  style: TextStyle(
                                    color: colorForText,
                                    fontSize: textSizeForTable + 1
                                  )
                                )
                              ),
                            ],
                          )
                        )
                      ),
                      Container(
                        padding: EdgeInsets.only(left: 5, right: 5),
                        margin: EdgeInsets.only(left: 10, right: 10, bottom: 15),
                        color: Colors.white,
                        child: DataTable(   //TODO Сделать сортировку таблицы
                          horizontalMargin: 10,
                          columnSpacing: MediaQuery.of(context).size.width * 0.05,
                          dataTextStyle: TextStyle(fontSize: textSizeForTable),
                          border: const TableBorder(
                            horizontalInside: BorderSide(color: Color.fromARGB(255, 255, 204, 142), width: 2.5),
                          ),
                          columns: [
                            DataColumn(label: Text('Место', style: TextStyle(color: colorForText, fontSize: textSizeForTable),)),
                            DataColumn(label: Text('Критерий', style: TextStyle(color: colorForText, fontSize: textSizeForTable))),
                            DataColumn(label: Text('')),
                            DataColumn(label: Text('Баллы', style: TextStyle(color: colorForText, fontSize: textSizeForTable))),
                          ],
                          rows: List<DataRow>.generate(post.projections.length, (index) => DataRow(
                            cells: <DataCell>[
                              DataCell(Text('${post.projections[index].place}', style: TextStyle(color: colorForText, fontSize: textSizeForTable))),
                              DataCell(Text(post.projections[index].projection.name, style: TextStyle(color: colorForText, fontSize: textSizeForTable),)),
                              DataCell(Image(image: AssetImage('${iconsPath + post.projections[index].projection.id.toString()}.png',), width: 30, height: 30, alignment: Alignment.centerRight,)),
                              DataCell(Text('${post.projections[index].score}', style: TextStyle(color: colorForText, fontSize: textSizeForTable))),
                            ]
                          ))  
                        )
                      )
                    ]
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