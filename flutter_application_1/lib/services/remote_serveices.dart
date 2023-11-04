import 'dart:developer';

import 'package:flutter_application_1/models/post.dart';
import 'package:http/http.dart' as http;

class RemoteService {
  Future<List<Posts>?> getPosts() async {
    try {
      var uri = Uri.parse("http://10.0.2.2:8080/api/regions");
      var response =
          await Future.delayed(Duration(seconds: 5), () => http.get(uri));
      if (response.statusCode == 200) {
        var json = response.body;
        List<Posts> _model = postsFromJson(response.body);
        return _model;
      }
    } catch (e) {
      log(e.toString());
    }
  }
}

class ApiConstants {
  static String baseUrl = 'http://10.0.2.2:8080/api/regions';
  static String usersEndPoint = '/users';
}
