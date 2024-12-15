import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:mprr/models/projection_criteria.dart';
import 'package:mprr/models/ratingProjection.dart';
import 'package:mprr/services/remote_serveices.dart';

class clicked_criteria extends StatefulWidget{
  final int criteriaId;
  final String criteriaName;
  final List<Criteria> criteria;

  const clicked_criteria({super.key, required this.criteriaId, required this.criteriaName, required this.criteria});
  
  @override
  _clicked_criteria createState() => _clicked_criteria();
}

class _clicked_criteria extends State<clicked_criteria> {

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    const String iconsPath = 'assets/images/criteria/';
    double textSizeForTable = 13.8;
    Color colorForBackGround = Color.fromARGB(255, 255, 204, 142);
    Color colorForText = Color.fromARGB(255, 47, 126, 113);
    Color colorFromAppBarBack = Color.fromARGB(255, 146, 194, 186);
    return Scaffold(
      appBar: AppBar(
        title: Text('МПРР'),
        backgroundColor: colorFromAppBarBack,
        foregroundColor: colorForText,
        scrolledUnderElevation: 4.0,
        shadowColor: Theme.of(context).shadowColor,
      ),
      body: Container(
        color: colorForBackGround,
        child: FutureBuilder<List<RatingProjection>>(
          future: RemoteService().getRatingProjection(widget.criteriaId),
          builder: (BuildContext context, AsyncSnapshot<List<RatingProjection>> snapshot){
            if (snapshot.connectionState == ConnectionState.waiting){
              return const Center(child: CircularProgressIndicator());
            } else if (snapshot.hasError) {
              return Text('Error: ${snapshot.error}');
            } else {
              final post = snapshot.data;
              final length = post!.length;
              final description = widget.criteria.map((element) => element.name).join(', ');
              return ListView(
                children: <Widget>[

                  Container(
                    color: Colors.white,
                    margin: const EdgeInsets.only(left: 10, right: 10, top: 15, bottom: 5),
                    child: Column(
                      children: <Widget>[
                        
                        Container(
                          margin: const EdgeInsets.only(bottom: 5, top: 10, left: 10, right: 10),
                          child: Text(
                            widget.criteriaName,
                            textAlign: TextAlign.center,
                            style: TextStyle(
                              color: colorForText,
                              fontSize: textSizeForTable,
                              fontWeight: FontWeight.w500,
                            ),
                          )
                        ),

                        Container(
                          margin: const EdgeInsets.only(bottom: 10, left: 5, right: 10),
                          child: Text(
                            textAlign: TextAlign.center,
                            description,
                            style: TextStyle(
                              color: colorForText,
                              fontSize: textSizeForTable
                            ),
                          )
                        )
                      ]
                    )
                  ),

                  ClipRRect(
                    borderRadius: BorderRadius.all(Radius.circular(20)),
                    child: Container(
                      margin: EdgeInsets.all(10),
                      color: Colors.white,
                      child: DataTable(
                        dataRowMinHeight: 50,
                        showCheckboxColumn: false,
                        dataRowMaxHeight: 75,
                        horizontalMargin: 15,
                        columnSpacing: MediaQuery.of(context).size.width * 0.05,
                        dataTextStyle: TextStyle(fontSize: textSizeForTable),
                        border: const TableBorder(horizontalInside: BorderSide(color: Color.fromARGB(255, 255, 204, 142), width: 2.5)),
                        columns: [
                          DataColumn(label: Text('Место', style: TextStyle(color: colorForText, fontSize: textSizeForTable),)),
                          DataColumn(label: Text('Регион', style: TextStyle(color: colorForText, fontSize: textSizeForTable))),
                          const DataColumn(label: Text('')),
                          DataColumn(label: Text('Баллы', style: TextStyle(color: colorForText, fontSize: textSizeForTable),)),
                        ],

                        rows: List<DataRow>.generate(length, (index) => DataRow(
                          cells: <DataCell> [
                            
                            DataCell(Text('${index + 1}', style: TextStyle(color: colorForText, fontSize: textSizeForTable, fontWeight: null),)),

                            DataCell(Text(post[index].name, style: TextStyle(color: colorForText, fontSize: textSizeForTable),)),

                            DataCell(Image(image: AssetImage('${iconsPath + widget.criteriaId.toString()}.png',), width: 30, height: 30, alignment: Alignment.centerRight)),

                            DataCell(Text('${post[index].score}', style: TextStyle(color: colorForText, fontSize: textSizeForTable))),
                          ]
                        ))
                      )
                    )
                  )
                ]  
              );
            }
          }  
        )
      )
    );
  }
}