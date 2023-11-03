import 'package:flutter/material.dart';

class first_page extends StatefulWidget{
  first_page ({super.key});
  @override
  State<first_page> createState() => _first_page();

}

class _first_page extends State<first_page>{
    @override 
    Widget build(BuildContext context){
      return Container(
        color: Color.fromARGB(255, 255, 204, 142),
        //alignment: Alignment.topCenter,
        child: Padding( 
          //настройки отступов для дочерних виджетов
          padding: EdgeInsets.only(top: 20),
          child: Text(
          'Общий рейтинг привлекательности регионов',
          textAlign: TextAlign.center,
          textDirection: TextDirection.ltr,
          textScaleFactor: 1.2, 
          style: TextStyle(color: Color.fromARGB(255, 31, 76, 106)),   
        ),
      ),
      );
    }
}