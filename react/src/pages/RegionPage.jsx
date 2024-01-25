import { React, useState, useEffect } from "react";
import ProjectionsTableComponent from "../components/ProjectionsTableComponent";
import { useParams } from "react-router-dom";

import axios from "axios";


export default function RegionPage() {

    const [region, setRegion] = useState([]);
    const params = useParams();

    useEffect(() => {
        fetch(`http://localhost:8080/api/regions/${params.id}`)
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
            <p>{region.name}</p>
            <ProjectionsTableComponent projections={region.projections}></ProjectionsTableComponent>
        </div>
    );
}
