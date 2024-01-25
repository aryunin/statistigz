// To parse this JSON data, do
//
//     final rating = ratingFromJson(jsonString);

import 'dart:convert';

Rating ratingFromJson(String str) => Rating.fromJson(json.decode(str));

String ratingToJson(Rating data) => json.encode(data.toJson());

class Rating {
    int id;
    String name;
    String description;
    List<ProjectionElement> projections;
    List<Achievement> achievements;

    Rating({
        required this.id,
        required this.name,
        required this.description,
        required this.projections,
        required this.achievements,
    });

    factory Rating.fromJson(Map<String, dynamic> json) => Rating(
        id: json["id"],
        name: json["name"],
        description: json["description"],
        projections: List<ProjectionElement>.from(json["projections"].map((x) => ProjectionElement.fromJson(x))),
        achievements: List<Achievement>.from(json["achievements"].map((x) => Achievement.fromJson(x))),
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "name": name,
        "description": description,
        "projections": List<dynamic>.from(projections.map((x) => x.toJson())),
        "achievements": List<dynamic>.from(achievements.map((x) => x.toJson())),
    };
}

class Achievement {
    AchievementProjection projection;

    Achievement({
        required this.projection,
    });

    factory Achievement.fromJson(Map<String, dynamic> json) => Achievement(
        projection: AchievementProjection.fromJson(json["projection"]),
    );

    Map<String, dynamic> toJson() => {
        "projection": projection.toJson(),
    };
}

class AchievementProjection {
    int id;
    String name;

    AchievementProjection({
        required this.id,
        required this.name,
    });

    factory AchievementProjection.fromJson(Map<String, dynamic> json) => AchievementProjection(
        id: json["id"],
        name: json["name"],
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "name": name,
    };
}

class ProjectionElement {
    AchievementProjection projection;
    double score;
    int place;

    ProjectionElement({
        required this.projection,
        required this.score,
        required this.place,
    });

    factory ProjectionElement.fromJson(Map<String, dynamic> json) => ProjectionElement(
        projection: AchievementProjection.fromJson(json["projection"]),
        score: json["score"]?.toDouble(),
        place: json["place"],
    );

    Map<String, dynamic> toJson() => {
        "projection": projection.toJson(),
        "score": score,
        "place": place,
    };
}
