import { React } from "react";
import { useNavigate } from "react-router-dom";

export default function RegionsTableComponent(props) {


    

    function Achievements(region) {
        return region.achievements.map((ach) => <p>{ach.projection.name}</p>);
    }

    function TableRow(region, index) {
        if (index % 2 == 1) {
            return (
                <tr class="reg1"> 
                    <th class="column1 odd ">{index}</th>
                    <th onClick={() => navigate(`/region/${region.id}`)} class={`column2 region${region.id}`}>{region.name}</th>
                    <th class="column3 odd bor"></th>
                    <th class="column4 odd">{region.score}</th>
                </tr>
        )}
        else {
            return (
                <tr class="reg2"> 
                    <th class="column1 even">{index}</th>
                    <th onClick={() => navigate(`/region/${region.id}`)} class={`column2 region${region.id}`}>{region.name}</th>
                    <th class="column3 even bor"></th>
                    <th class="column4 even">{region.score}</th>
                </tr>
        )}
    }




    const navigate = useNavigate();

    return (
        <section>
            <div class="section-table-home">
                <div class="container">
                    
                    <table>
                        <tr class="namecolum">
                            <th class="namecolum1">Место <br/> в рейтинге</th>
                            <th class="namecolum2">Регион</th>
                            <th class="namecolum3">Достижения региона</th>
                            <th class="namecolum4">Баллы</th>
                        </tr>
                        {props.regions.map((region, index) =>
                            TableRow(region, index+1))}
                    </table>
                </div>
            </div>
        </section>
    );
}
  