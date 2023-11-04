import 'dart:developer';

import 'package:flutter_application_1/models/post.dart';
import 'package:http/http.dart' as http;

class RemoteService {
  Future<List<Posts>?> getPosts () async{
    
    try{
    var uri = Uri.parse("http://localhost:8080/api/regions/users");
    var response = await http.get(uri);
    if (response.statusCode == 200){
      var json = response.body;
      List<Posts> _model = postsFromJson(response.body);
      return _model;
    } 
    } catch (e){
      log(e.toString());
    }
  }
}

class ApiConstants{
   static String baseUrl = 'http://localhost:8080/api/regions';
   static String usersEndPoint = '/users'; 
}