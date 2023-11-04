import 'dart:convert';

List<ProjectionCriteria> projectionCriteriaFromJson(String str) =>
    List<ProjectionCriteria>.from(
        json.decode(str).map((x) => ProjectionCriteria.fromJson(x)));

String projectionCriteriaToJson(List<ProjectionCriteria> data) =>
    json.encode(List<dynamic>.from(data.map((x) => x.toJson())));

class ProjectionCriteria {
  int id;
  String name;
  List<Criteria> criteria;

  ProjectionCriteria({
    required this.id,
    required this.name,
    required this.criteria,
  });

  factory ProjectionCriteria.fromJson(Map<String, dynamic> json) =>
      ProjectionCriteria(
        id: json["id"],
        name: json["name"],
        criteria: List<Criteria>.from(
            json["criteria"].map((x) => Criteria.fromJson(x))),
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "name": name,
        "criteria": List<dynamic>.from(criteria.map((x) => x.toJson())),
      };
}

class Criteria {
  int id;
  String name;

  Criteria({
    required this.id,
    required this.name,
  });

  factory Criteria.fromJson(Map<String, dynamic> json) => Criteria(
        id: json["id"],
        name: json["name"],
      );

  Map<String, dynamic> toJson() => {
        "id": id,
        "name": name,
      };
}
