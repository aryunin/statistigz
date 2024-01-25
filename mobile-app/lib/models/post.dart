// To parse this JSON data, do
//
//     final posts = postsFromJson(jsonString);

import 'dart:convert';

List<Posts> postsFromJson(String str) => List<Posts>.from(json.decode(str).map((x) => Posts.fromJson(x)));

String postsToJson(List<Posts> data) => json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

class Posts {
    int id;
    String name;
    double score;
    List<Achievement> achievements;

    Posts({
        required this.id,
        required this.name,
        required this.score,
        required this.achievements,
    });

    factory Posts.fromJson(Map<String, dynamic> json) => Posts(
        id: json["id"],
        name: json["name"],
        score: json["score"]?.toDouble(),
        achievements: List<Achievement>.from(json["achievements"].map((x) => Achievement.fromJson(x))),
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "name": name,
        "score": score,
        "achievements": List<dynamic>.from(achievements.map((x) => x.toJson())),
    };
}

class Achievement {
    Projection projection;

    Achievement({
        required this.projection,
    });

    factory Achievement.fromJson(Map<String, dynamic> json) => Achievement(
        projection: Projection.fromJson(json["projection"]),
    );

    Map<String, dynamic> toJson() => {
        "projection": projection.toJson(),
    };
}

class Projection {
    int id;
    String name;

    Projection({
        required this.id,
        required this.name,
    });

    factory Projection.fromJson(Map<String, dynamic> json) => Projection(
        id: json["id"],
        name: json["name"],
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "name": name,
    };
}
