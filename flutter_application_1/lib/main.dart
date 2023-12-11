import 'package:flutter/material.dart';
import 'package:flutter_application_1/pages/first_page.dart' ;
import 'package:flutter_application_1/pages/second_page.dart';
import 'package:flutter_application_1/pages/third_page.dart';
void main(){
  runApp(const HomePage());
}
List<String> title = <String>[
  'Главная',
  'Города',
  'Криетрии'
];
class HomePage extends StatelessWidget{
  const HomePage({super.key});
  @override
  Widget build(BuildContext context){
    return MaterialApp(
      home: AppBarLine(),
      theme: ThemeData(
        colorSchemeSeed: const Color.fromARGB(255, 31, 76, 106), useMaterial3: true
    ),
    );
  }
}

class AppBarLine extends StatelessWidget{
  const AppBarLine({super.key});

  @override
  Widget build(BuildContext context) {
  
    final ColorScheme colorScheme = Theme.of(context).colorScheme;
    //final Color oddItemColor = colorScheme.primary.withOpacity(0.05);
    //final Color evenItemColor = colorScheme.primary.withOpacity(0.15);
    const int tabsCount = 2;
    return DefaultTabController(
      length: tabsCount,
      child: Scaffold(
        appBar: AppBar(
        title: Text("МПРР"),
        backgroundColor: Color.fromARGB(255, 146, 194, 186),
        foregroundColor: Color.fromARGB(255, 47, 126, 113),
        scrolledUnderElevation: 4.0,
        shadowColor: Theme.of(context).shadowColor,
        bottom: TabBar(tabs: <Widget>[
          Tab(
            child: Text(title[0], style: TextStyle(color: Color.fromARGB(255, 47, 126, 113)),), 
          ),
          // Tab(
          //   text: title[1],
          // ),
          Tab(
            child: Text(title[2], style: TextStyle(color: Color.fromARGB(255, 47, 126, 113)),),
          ),
        ],),

      ),
      body: TabBarView(       
        children: [
          first_page(),
          //second_page(),
          third_page(),
        ]
      ),
      //drawer: Drawer(),
      )
    );
  }
}