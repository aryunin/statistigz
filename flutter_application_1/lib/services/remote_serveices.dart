import 'package:flutter_application_1/models/post.dart';
import 'package:http/http.dart' as http;

class RemoteService {
  Future<List<Posts>?> getPosts () async{
    var client = http.Client();

    var uri = Uri.parse('http://localhost:8080/api/regions');
    var response = await client.get(uri);
    if (response.statusCode == 200){
      var json = response.body;
      return postsFromJson(json);
    } else {
      throw Exception('failed to load');
    }
  }
}