// ignore_for_file: prefer_interpolation_to_compose_strings

import 'dart:convert';

import 'package:flutter_application_1/models/post.dart';
import 'package:flutter_application_1/models/projection_criteria.dart';
import 'package:flutter_application_1/models/rating.dart';
import 'package:flutter_application_1/models/ratingProjection.dart';
import 'package:http/http.dart' as http;

class RemoteService {
  Future <List<Posts>> getPosts(String search) async {
      List<Posts> ? posts;
      var uri = Uri.parse(ApiConstants.baseUrl + ApiConstants.regionsEndpoint);
      var response = await Future.delayed(
          const Duration(seconds: 1), () => http.get(uri)); // TODO del
      if (response.statusCode == 200) {
        posts = postsFromJson(utf8.decode(response.bodyBytes)).where((element) => element.name.toLowerCase().contains(search.toLowerCase())).toList();
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

  Future<Rating> getRating(regoinId) async {
    var uri = Uri.parse(ApiConstants.baseUrl + ApiConstants.regionsEndpoint + '/' + '${regoinId}');
    var response = await Future.delayed(
      const Duration(seconds: 1), () =>http.get(uri));
    if (response.statusCode == 200) {
      final data = json.decode(response.body);
      return ratingFromJson(utf8.decode(response.bodyBytes));
    }
    else {throw Exception('failed to load');}
  }

  Future<List<RatingProjection>> getRatingProjection(projectionId) async {
    var uri = Uri.parse(ApiConstants.baseUrl + ApiConstants.regionsEndpoint + '?projectionId=' + '${projectionId}');
    var response = await Future.delayed(const Duration(seconds: 1), () =>http.get(uri));
    if (response.statusCode == 200){
      final data = json.decode(response.body);
      return ratingProjectionFromJson(utf8.decode(response.bodyBytes));
    } else {
      throw Exception('failed to load');
    }
  }

  Future<List<Posts>> getRegionIds(answers) {
  return Future(() async {
    final uri = Uri.parse(ApiConstants.baseUrl + ApiConstants.rcm);
    final requestBody = json.encode({'answers': answers});
    final response = await http.post(uri, headers: { 'Content-Type': 'application/json',}, body: requestBody);
    if (response.statusCode == 200) {
      final data = json.decode(response.body);
      if (data is Map<String, dynamic> && data['regionIds'] is List) {
        final regions = await getPosts('');
        final ids = List<int>.from(data['regionIds']);
        final listRegions = regions.where((element) => ids.contains(element.id)).toList(); 
        return listRegions;
      } else {
        throw Exception('Unexpected response format');
      }
    } else {
      throw Exception('Failed to load regions: ${response.statusCode}');
    }
  });
}
}

class ApiConstants {
  static const String projectionsEndpoint = String.fromEnvironment('projectionsEndpoint', defaultValue: '/projections');
  static const String regionsEndpoint = String.fromEnvironment('regionsEndpoint', defaultValue: '/regions');
  static const String rcm = String.fromEnvironment('rcm', defaultValue: '/rcm');
  static const String host = String.fromEnvironment('host', defaultValue: '10.0.2.2');
  static const String port = String.fromEnvironment('port', defaultValue: '8081');
  static const String baseUrl = 'http://$host:$port/api';
}
