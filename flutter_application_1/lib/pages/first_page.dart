import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter_application_1/models/post.dart';
import 'package:flutter_application_1/services/remote_serveices.dart';

class first_page extends StatefulWidget {
  first_page({super.key});

  @override
  State<first_page> createState() => _first_page();
}

class _first_page extends State<first_page> {
  List<Posts>? post = [];

  @override
  void initState() {
    super.initState();
    getData();
  }

  getData() async {
    RemoteService().getPosts().then((value) {
      post = value;
      super.setState(() {});
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text('Рейтинг привлекательности регионов')),
        body: post == null || post!.isEmpty
            ? const Center(child: CircularProgressIndicator())
            : ListView.builder(
                itemCount: post!.length,
                itemBuilder: (context, index) {
                  Text(post![index].name);
                }));
  }
}
