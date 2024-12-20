import { React, useState, useEffect } from "react";
import RegionsTableComponent from "../components/RegionsTableComponent";
import HeaderComponent from "../components/HeaderComponent";
import Background from "../img/back_icons.png"


export default function RegionsPage() {

    const [regions, setRegions] = useState([]);
    const [filteredRegions, setFilteredRegions] = useState([])

    function ChangeSearchText(text) {
        setFilteredRegions(regions.filter((r) => r.name.toUpperCase().includes(text.toUpperCase())))
    }

    useEffect(() => {
        document.title = 'Регионы';
        
        fetch(`${process.env.REACT_APP_API_PROTOCOL}://${process.env.REACT_APP_API_HOST}:${process.env.REACT_APP_API_PORT}/${process.env.REACT_APP_API_PREFIX}/regions`)
            .then((response) => response.json())
            .then((data) => {
                setRegions(data);
                setFilteredRegions(data);
            })
            .catch((err) => {
                console.log(err.message);
            });
    }, []);

    const searchRegionStyle = {
        width: '700px',
        height: '42px',
        fontSize: '15px',
        display: 'block',
        marginBottom: '75px',
        borderRadius: '20px',
        border: '3px solid #1F4C6A'
    }

    return (
        <div>
            <HeaderComponent page=''/>
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
            <div style={{backgroundImage: `url(${Background})`, backgroundRepeat: 'no-repeat', backgroundSize: `${1097}px ${5538}px`, backgroundPosition: '50% 50px', minHeight: '5538px'}}>
                <h2 style={{marginTop: "30px"}} class="name_overall">ОБЩИЙ РЕЙТИНГ ПРИВЛЕКАТЕЛЬНОСТИ РЕГИОНОВ</h2>
                <div style={{display: 'flex',
                justifyContent: 'center',
                alignItems: 'center'}}>
                    
                    <input style={searchRegionStyle} placeholder="Поиск региона..." onChange={evt => ChangeSearchText(evt.target.value)}/>
                </div>
                <RegionsTableComponent regions={filteredRegions}/>
            </div>
        </div>
    );
}
