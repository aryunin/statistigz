import 'dart:convert';
import 'dart:developer';

import 'package:flutter_application_1/models/post.dart';
import 'package:flutter_application_1/models/projection_criteria.dart';
import 'package:http/http.dart' as http;

class RemoteService {
  Future <List<Posts>> getPosts(search) async {
      List<Posts> ? posts;
      var uri = Uri.parse(ApiConstants.baseUrl + ApiConstants.regionsEndpoint);
      var response = await Future.delayed(
          const Duration(seconds: 1), () => http.get(uri)); // TODO del
      if (response.statusCode == 200) {
        //var json = response.body;
        final data = json.decode(response.body) as List<dynamic>;
        // utf8.decode('asda');
        posts = postsFromJson(utf8.decode(response.bodyBytes)).where((element) => element.name.contains(search)).toList();
        return posts;
      }
      else {throw Exception('failed to load');}
   
  }

  Future<List<ProjectionCriteria>> getProjections() async {
    var uri =
        Uri.parse(ApiConstants.baseUrl + ApiConstants.projectionsEndpoint);
    var response =
        await Future.delayed(const Duration(seconds: 1), () => http.get(uri));
    if (response.statusCode == 200) {
      return projectionCriteriaFromJson(utf8.decode(response.bodyBytes));
    }
    throw Error();
  }


}

class ApiConstants {
  static String projectionsEndpoint = '/projections';
  static String regionsEndpoint = '/regions';
  static String host = '10.0.2.2';
  static String port = '8080';
  static String baseUrl = 'http://$host:$port/api';
}
