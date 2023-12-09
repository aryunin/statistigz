// ignore_for_file: prefer_const_constructors, no_logic_in_create_state

import 'package:flutter/material.dart';
import 'package:flutter_application_1/models/post.dart';
import 'package:flutter_application_1/services/remote_serveices.dart';
import 'dart:convert';
import 'dart:io';


class second_page extends StatefulWidget{
  final int regionsId;

  second_page ({super.key, required this.regionsId});
  @override
  State<second_page> createState() => _second_page(regionsId: regionsId);

  int getRegionsId(){
    return regionsId;
  }
}

class _second_page extends State<second_page>{
  final int regionsId;
  

  _second_page({required this.regionsId});

  @override
  Widget build(BuildContext context){
    return Container (
      child: Scaffold(
        appBar: AppBar(
          title: Text('МПРР'),
          backgroundColor: Color.fromARGB(255, 146, 194, 186),
          foregroundColor: Color.fromARGB(255, 47, 126, 113),
          scrolledUnderElevation: 4.0,
          shadowColor: Theme.of(context).shadowColor,
        ),
      body: Container(
        color: Color.fromARGB(255, 255, 204, 142),
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
                    borderRadius: BorderRadius.all(Radius.circular(38)),
                    child: Container(
                      margin: EdgeInsets.all(10),
                      color: Color.fromARGB(255, 255, 255, 255),
                     
                    ),
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