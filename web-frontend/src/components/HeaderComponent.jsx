import { React } from "react";
import Style from "../header.css"
import HeaderBurgerImage from "./../img/header_burger.svg"
import { useNavigate } from "react-router-dom";


function activePassiveLink(name, currentPageName, label) {
    if (name == currentPageName)
        return( <div><a class="active-link">{label}</a></div>)
    else return( <div><a class="passive-link" href={`http://${window.location.host}/${name}`}>{label}</a></div>)
}

function color(page) {
    if (page==""){
        return {backgroundColor: '#92C2BA'}
    }
    else if (page=="region") {
        return {backgroundColor: '#FFFFFF00'}
    }
    else {
        return {backgroundColor: '#FFCD8E'}
    }
}

export default function HeaderComponent(props) {

  const navigate = useNavigate();
    

    return (
          <header class="header">
            <div class="header-container" style={color(props.page)}>
              <div class="logo-wrapper">
                <img
                  loading="lazy"
                  src={`${HeaderBurgerImage}`}
                  class="logo-icon"
                  alt="МПРР Logo"
                />
                <div style={{cursor: "pointer"}} onClick={() => navigate(`/`)}>МПРР</div>
              </div>
              <nav class="nav-menu">
               {activePassiveLink("ourcity", props.page, "Регион для вас")}
               {activePassiveLink("", props.page, "Главная")}
               {activePassiveLink("city", props.page, "Регионы")}
               {activePassiveLink("criterion", props.page, "Критерии")}
              </nav>
            </div>
          </header>
    );
}
  