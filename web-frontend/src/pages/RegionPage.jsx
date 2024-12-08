import { React, useState, useEffect } from "react";
import ProjectionsTableComponent from "../components/ProjectionsTableComponent";
import { useParams } from "react-router-dom";
import HeadImg from "./../img/moscow_head.png"
import RegionBackImg from "./../img/regionback.png"

import axios from "axios";
import HeaderComponent from "../components/HeaderComponent";
import '../region.css'
import HeaderBurger from './../img/header_burger_city.svg'
import SocImg1 from './../img/soc1.png'
import SocImg2 from './../img/soc2.png'
import SocImg3 from './../img/soc3.png'
import SocImg4 from './../img/soc4.png'
import SocImg5 from './../img/soc5.png'
import SocImg6 from './../img/soc6.png'
import SocImg7 from './../img/soc7.png'
import SocImg8 from './../img/soc8.png'
import SocImg9 from './../img/soc9.png'
import SocImg10 from './../img/soc10.png'
import SocImg11 from './../img/soc11.png'
import SocImg12 from './../img/soc12.png'
import SocImg13 from './../img/soc13.png'
import SocImg14 from './../img/soc14.png'
import SocImg15 from './../img/soc15.png'
import SocImg16 from './../img/soc16.png'
import SocImg17 from './../img/soc17.png'


export default function RegionPage() {

    const [region, setRegion] = useState([]);
    const [images, setImages] = useState([]);
    const [imageHeader, setImageHeader] = useState([]);
    const [image1, setImage1] = useState([]);
    const [image2, setImage2] = useState([]);
    const [image3, setImage3] = useState([]);
    const [image4, setImage4] = useState([]);
    const [imageHeaderStyle, setImageHeaderStyle] = useState();
    const params = useParams();

    useEffect(() => {
        fetch(`http://${process.env.REACT_APP_API_HOST}:${process.env.REACT_APP_API_PORT}/${process.env.REACT_APP_API_PREFIX}/regions/${params.id}`)
            .then((response) => response.json())
            .then((data) => {
                document.title = data.name;
                setRegion(data);
            })
            .catch((err) => {
                console.log(err.message);
            });
            
        fetch(`http://${process.env.REACT_APP_API_HOST}:${process.env.REACT_APP_API_PORT}/${process.env.REACT_APP_API_PREFIX}/regions/${params.id}/photo`)
        .then((response) => response.json())
        .then((data) => {
            // console.log(data[0].data)
            // setImages(data);
            setImageHeaderStyle({backgroundImage: `url("data:image/jpg;base64,${data[0].data})`, backgroundRepeat: "space", backgroundSize: "100% auto"})
            setImageHeader(data[0].data)
            setImage1(data[1].data)
            setImage2(data[2].data)
            setImage3(data[3].data)
            setImage4(data[4].data)
            // console.log(imageHeaderStyle.stringify())
            console.log(imageHeaderStyle)
        })
        .catch((err) => {
            console.log(err.message);
        });
    }, []);

    let cityHeadStyle={}
    let headerNav={
        width: "100%",
        display: "flex",
        flexDirection: "column",
        color: "#000",
        whiteSpace: "nowrap",
        font: "400 15px Arimo, sans-serif"
    }
    let navContainer={
            backgroundColor: "#90B7D1",
            borderBottom: "1px solid #000",
            display: "flex",
            width: "100%",
            flexDirection: "column",
            alignItems: "center",
            justifyContent: "center",
            padding: "19px 70px"
    }
    let navLinks={
        display: "flex",
        width: "624px",
        maxWidth: "100%",
        gap: "33p"
    }
    let cityName={
        color: "#1F4C6A"
    }
    let attractions={
        flexGrow: "1",
        width: "164px"
    }

    let socialIconsCcontainer={
        display: "flex",
        flexDirection: "column"
    }
      
    let socialIconsWrapper={
        backgroundColor: "rgba(144, 183, 209, 1)",
        boxShadow: "0px 6px 7px rgba(0, 0, 0, 0.25)",
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center",
        padding: "10px 70px"
    }
      
    let socialIconsGrid={
        display: "flex",
        alignItems: "center",
        gap: "16px",
        justifyContent: "center",
        flexWrap: "wrap"
    }
      
    let socialIcon={
        aspectRatio: "1",
        objectFit: "contain",
        objectPosition: "center",
        width: "35px",
        alignSelf: "stretch",
        margin: "auto 0"
    }
      
    let socialIconAlt={
        aspectRatio: "0.97",
        objectFit: "contain",
        objectPosition: "center",
        width: "34px",
        alignSelf: "stretch",
        margin: "auto 0"
    }
    let linkStyle={
        color: "#FFFFFF",
        fontFamily: "Arimo",
        fontSize: "14px",
        fontStyle: "normal",
        fontWeight: "400",
        lineHeight: "normal"
    }
    let mprrStyle={
        color: "#FFFFFF"
    }
    let imgStyle={
        aspectRatio: "1",
        objectFit: "contain",
        objectPosition: "center",
        alignSelf: "stretch",
        margin: "auto 0"
    }
    let headerDivStyle={backgroundImage: `url(${HeadImg})`, backgroundRepeat: "space ", backgroundSize: "100% auto"}
    let headerContainerStyle={borderBottom: "1px solid #fff", backgroundColor: "#FFFFFF00", height: "30px"}
    let cityTitleStyle={border: "0"}
    let cityDescriptionStyle={marginLeft : "5%", marginRight: "5%"}
    let heroTitleStyle={color: "#FFFFFF"}
    let galleryOutContainer={
        display: "flex",
        flexDirection: "column",
        alignItems: "center",
        justifyContent: "center"
    }
    let galleryContainer={
        display: "flex",
        alignItems: "center",
        gap: "16px",
        justifyContent: "center",
        flexWrap: "wrap",
        marginTop: "50px"
    }

    return (
        <div>
            {/* <div style={{backgroundImage: `data:image/jpeg;base64,${imageHeader}`, backgroundRepeat: "space", backgroundSize: "100% auto"}}> */}
            <div style={{backgroundImage: `url("data:image/jpeg;base64,${imageHeader}")`, backgroundRepeat: "space", backgroundSize: "100% auto"}}>
                <header class="header">
                    <div class="header-container" style={headerContainerStyle}>
                        <div class="logo-wrapper">
                            <img
                            loading="lazy"
                            src={`${HeaderBurger}`}
                            class="logo-icon"
                            alt="МПРР Logo"
                            />
                            <div style={mprrStyle}>МПРР</div>
                        </div>
                        <nav class="nav-menu">
                            <div><a style={linkStyle} class={"passive-link-region"} href={`http://${window.location.host}/ourcity`}>Регион для вас</a></div>
                            <div><a style={linkStyle} class={"passive-link-region"} href={`http://${window.location.host}`}>Главная</a></div>
                            <div><a style={linkStyle} class={"passive-link-region"} href={`http://${window.location.host}/city`}>Города</a></div>
                            <div><a style={linkStyle} class={"passive-link-region"} href={`http://${window.location.host}/criterion`}>Критерии</a></div>
                        </nav>
                    </div>
                    <h1 style={heroTitleStyle} class="hero-title">{region.name}</h1>
                </header>
            </div>
                <div style={socialIconsWrapper} class="social-icons-wrapper">
                    <div style={socialIconsGrid} class="social-icons-grid">
                        <img style={socialIcon} loading="lazy" src={`${SocImg1}`} class="social-icon" alt="Social media icon 1" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg2}`} class="social-icon-alt" alt="Social media icon 2" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg3}`} class="social-icon" alt="Social media icon 3" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg4}`} class="social-icon" alt="Social media icon 4" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg5}`} class="social-icon" alt="Social media icon 5" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg6}`} class="social-icon" alt="Social media icon 6" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg7}`} class="social-icon-alt" alt="Social media icon 7" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg8}`} class="social-icon" alt="Social media icon 8" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg9}`} class="social-icon" alt="Social media icon 9" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg10}`} class="social-icon-alt" alt="Social media icon 10" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg11}`} class="social-icon" alt="Social media icon 11" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg12}`} class="social-icon" alt="Social media icon 12" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg13}`} class="social-icon" alt="Social media icon 13" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg14}`} class="social-icon-alt" alt="Social media icon 14" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg15}`} class="social-icon" alt="Social media icon 15" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg16}`} class="social-icon" alt="Social media icon 16" />
                        <img style={socialIcon} loading="lazy" src={`${SocImg17}`} class="social-icon-alt" alt="Social media icon 17" />
                    </div>
                </div>

            <div style={galleryOutContainer}>
                <div style={galleryContainer}>
                    <div style={imgStyle}>
                        <img src={`data:image/jpeg;base64,${image1}`} alt="Moscow cityscape 1" class="gallery-image" />
                    </div>
                    <div style={imgStyle}>
                        <img src={`data:image/jpeg;base64,${image2}`} alt="Moscow cityscape 2" class="gallery-image" />
                    </div>
                    <div style={imgStyle}>
                        <img src={`data:image/jpeg;base64,${image3}`} alt="Moscow cityscape 3" class="gallery-image" />
                    </div>
                    <div style={imgStyle}>
                        <img src={`data:image/jpeg;base64,${image4}`} alt="Moscow cityscape 4" class="gallery-image" />
                    </div>
                </div>
            </div>

            <h2 style={cityTitleStyle} class="city-title">{region.name}</h2>
                
            <p style={cityDescriptionStyle} class="city-description">
                {/* <strong>Москва</strong> - столица России и крупнейший город страны. Это огромный мегаполис, который является историческим, политическим и духовным сердцем Российской Федерации. Москва - крупнейшая столица Европы, наполненная достопримечательностями, памятниками истории и культуры, а также музеями мирового уровня. Это город невероятной динамики и размеров, который невозможно объять за одну поездку. Столица России существует уже около девяти веков. На её улочках можно встретить старинные сакральные памятники и дворцы, которые соседствуют с монументальными зданиями советской архитектуры и ультрасовременными сооружениями. Но не только этим славится Москва. */}
                {region.description}
            </p>
            <br/>
            
            <p>Статистика</p>
            <div style={{backgroundImage: `url(${RegionBackImg})`, backgroundRepeat: 'no-repeat', backgroundSize: '90% 95%', backgroundPosition: '50px 30px', minHeight: '1091px'}}>
                <ProjectionsTableComponent projections={region.projections}></ProjectionsTableComponent>
            </div>
            <br/>
        </div>
    );
}
