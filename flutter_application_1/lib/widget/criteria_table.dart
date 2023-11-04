import 'package:flutter/material.dart';
import 'package:flutter_application_1/models/projection_criteria.dart';

class CriteriaTable extends StatefulWidget {
  final List<ProjectionCriteria> data;

  const CriteriaTable({super.key, required this.data});

  @override
  State<StatefulWidget> createState() {
    return _CriteriaTableState();
  }
}

class _CriteriaTableState extends State<CriteriaTable> {
  List<TableRow> _rows = List.empty(growable: true);

  @override
  void initState() {
    widget.data.forEach((el) {
      _rows.add(TableRow(children: <Widget>[
        Container(
          child: Text(el.name),
        ),
        Container(
          child: Text(el.criteria
              .map((e) => e.name)
              .reduce((prev, cur) => '$prev\n$cur')),
        )
      ]));
    });
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Table(
        border: TableBorder.all(),
        columnWidths: const <int, TableColumnWidth>{
          0: FlexColumnWidth(),
          1: FlexColumnWidth(),
        },
        defaultVerticalAlignment: TableCellVerticalAlignment.middle,
        children: _rows);
  }
}
