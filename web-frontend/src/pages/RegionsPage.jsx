import { React, useState, useEffect } from "react";
import RegionsTableComponent from "../components/RegionsTableComponent";

export default function RegionsPage() {

    const [regions, setRegions] = useState([]);
    const [filteredRegions, setFilteredRegions] = useState([])

    function ChangeSearchText(text) {
        setFilteredRegions(regions.filter((r) => r.name.includes(text)))
    }

    useEffect(() => {
        document.title = 'Регионы';
        fetch(`http://${process.env.REACT_APP_API_HOST}:${process.env.REACT_APP_API_PORT}/api/regions`)
            .then((response) => response.json())
            .then((data) => {
                setRegions(data);
                setFilteredRegions(data);
            })
            .catch((err) => {
                alert(err.message);
            });
    }, []);

    return (
        <div>
            <header>
                <div class="header-home">
                    <div class="container header-container d_f jc_sb ai_c">
                            <div class="menu-section1">
                                <a class="menu-section1_MPRR" href="">МПРР</a>
                            </div>
                            <div class="menu-section2">
                                <nav class="nav">
                                    <ul class="header-menu d_f jc_sb">
                                        <li class="header-menu_listitem"><a class="active-link" href="">Главная</a></li>

                                        <li class="header-menu_listitem"><a class="passive-link" href="city.html">Города</a></li>

                                        <li class="header-menu_listitem"><a class="passive-link" href="">Критерии</a></li>
                                    </ul>
                                </nav>
                            </div>
                    </div>
                </div>
            </header>
            <section>
                <div class="section-info-home">
                    <div class="container d_f jc_sb">
                        <div class="map"></div>
                        <div class="title">
                            <h1 class="title_MPRR">МПРР</h1>
                            <h5 class="title_description1">Мониторинг привлекательности</h5>
                            <h5 class="title_description2">регионов России</h5>
                        </div>
                    </div>
                </div>
            </section>
            <input onChange={evt => ChangeSearchText(evt.target.value)}/>
            <RegionsTableComponent regions={filteredRegions}></RegionsTableComponent>
        </div>
    );
}
