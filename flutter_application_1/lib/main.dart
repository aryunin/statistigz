import 'package:flutter/material.dart';

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
    final Color oddItemColor = colorScheme.primary.withOpacity(0.05);
    final Color evenItemColor = colorScheme.primary.withOpacity(0.15);
    const int tabsCount = 3;
    return DefaultTabController(
      length: tabsCount,
      child: Scaffold(
        appBar: AppBar(
        title: Text("МПРР"),
        backgroundColor: Color.fromARGB(255, 255, 204, 142),
        foregroundColor: Color.fromARGB(255, 31, 76, 106),
        scrolledUnderElevation: 4.0,
        shadowColor: Theme.of(context).shadowColor,
        bottom: TabBar(tabs: <Widget>[
          Tab(
            text: title[0],
          ),
          Tab(
            text: title[1],
          ),
          Tab(
            text: title[2],
          ),
        ],),

      ),
      drawer: Drawer(),
    )

    );
  }

}