import 'package:flutter/material.dart';
import 'package:mprr/models/projection_criteria.dart';

void _swapRows(List<DataRow> rows, int first, int second) {
  final temp = rows[first];
  rows[first] = rows[second];
  rows[second] = temp;
}

class CriteriaTable extends StatefulWidget {
  final List<ProjectionCriteria> data;
  final Function callback;

  const CriteriaTable({super.key, required this.data, required this.callback});

  @override
  State<StatefulWidget> createState() {
    return _CriteriaTableState();
  }
}

class _CriteriaTableState extends State<CriteriaTable> {
  final List<DataRow> _rows = List.empty(growable: true);
  final String iconsPath = 'assets/images/criteria/';

  @override
  void initState() {
    for (var el in widget.data) {
      _rows.add(DataRow(
          onSelectChanged: (x) => widget.callback(el.id, el.name, el.criteria),
          cells: <DataCell>[
            DataCell(SizedBox(
                height: 75,
                child: Image(
                    image: AssetImage('${iconsPath + el.id.toString()}.png')))),
            DataCell(Text(el.name))
          ]));
    }
    int commonCriteriaIdx = widget.data.indexWhere((e) => e.id == 17);
    _swapRows(_rows, commonCriteriaIdx, _rows.length - 1);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return DataTable(
        border: const TableBorder(
            horizontalInside: BorderSide(
                width: 3, color: Color.fromARGB(255, 146, 194, 186))),
        dividerThickness: 0,
        headingRowHeight: 0,
        dataRowMinHeight: 75,
        dataRowMaxHeight: 100,
        showCheckboxColumn: false,
        columns: [
          DataColumn(label: Container()),
          DataColumn(label: Container())
        ],
        rows: _rows);
  }
}
