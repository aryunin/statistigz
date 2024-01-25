import { React } from "react";


function ProjectionRows(projections) {
    if (projections) {
        return projections.map((projection, index) =>
            <div class="divTableRow">
                <div class="divTableCell">{index + 1}</div>
                <div class="divTableCell">{projection.projection.name}</div>
                <div class="divTableCell">{projection.score}</div>
                <div class="divTableCell">1</div>
            </div>);
    }
}

export default function ProjectionsTableComponent(props) {

    return (
        <div class="divTable">
            <div class="divTableBody">
                {ProjectionRows(props.projections)}
            </div>
        </div>
    );
}
  