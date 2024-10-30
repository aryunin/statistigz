import { React, useState, useEffect } from "react";
import ProjectionsTableComponent from "../components/ProjectionsTableComponent";
import { useParams } from "react-router-dom";

import axios from "axios";
import HeaderComponent from "../components/HeaderComponent";


export default function RegionPage() {

    const [region, setRegion] = useState([]);
    const params = useParams();

    useEffect(() => {
        fetch(`http://${process.env.REACT_APP_API_HOST}:${process.env.REACT_APP_API_PORT}/${process.env.REACT_APP_API_PREFIX}/regions/${params.id}`)
            .then((response) => response.json())
            .then((data) => {
                document.title = data.name;
                setRegion(data);
            })
            .catch((err) => {
                alert(err.message);
            });
    }, []);

    return (
        <div>
            <HeaderComponent page=''/>
            <br/>
            <h2>{region.name}</h2>
            <ProjectionsTableComponent projections={region.projections}></ProjectionsTableComponent>
            <br/>
        </div>
    );
}
