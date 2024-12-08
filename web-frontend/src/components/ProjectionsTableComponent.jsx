import { React } from "react";


function ProjectionRows(projections) {
    
    if (projections) {
        return projections.map((projection, index) =>

        {
            if (index % 2 == 1) {
                return (
                    <tr class="reg1"> 
                        <th class="column1 odd">{index + 1}</th>
                        <th class={`column2 projection${projection.projection.id}`}>{projection.projection.name}</th>
                        <th class="projectioncolumn3 odd bor">{projection.score}</th>
                        <th class="projectioncolumn4 odd">{projection.place}</th>
                    </tr>
            )}
            else {
                return (
                    <tr class="reg2"> 
                        <th class="column1 even">{index + 1}</th>
                        <th class={`column2 projection${projection.projection.id}`}>{projection.projection.name}</th>
                        <th class="projectioncolumn3 even bor">{projection.score}</th>
                        <th class="projectioncolumn4 even">{projection.place}</th>
                    </tr>
            )}
        })}
}

export default function ProjectionsTableComponent(props) {

    return (
        <table>
            <tr class="namecolum">
                <th class="namecolum1">Индекс</th>
                <th class="namecolum2">Критерий</th>
                <th class="projectionnamecolum3">Баллы</th>
                <th class="projectionnamecolum4">Место среди регионов</th>
            </tr>
            {ProjectionRows(props.projections)}
        </table>
    );
}
  