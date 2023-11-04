import 'package:flutter/material.dart';
import 'package:flutter_application_1/models/post.dart';
import 'package:flutter_application_1/services/remote_serveices.dart';


class first_page extends StatefulWidget{
  first_page ({super.key});
  @override
  State<first_page> createState() => _first_page();

}

class _first_page extends State<first_page>{

  List<Posts>? post;
  var isLoaded = false;
  @override
  void initState(){
    super.initState();
    getData();
  }

  getData() async {
    post = await await RemoteService().getPosts();
    if (post != null){
      setState(() {
        isLoaded = true;
      });
    }
  }

    @override 
    Widget build(BuildContext context){
      return Container(
        color: Color.fromARGB(255, 255, 204, 142),
        //alignment: Alignment.topCenter,
        child: const Padding( 
          //настройки отступов для дочерних виджетов
          padding: EdgeInsets.only(top: 20),
          // child: Text(
            
          // ),
        ),
        
      );
     
    }
}