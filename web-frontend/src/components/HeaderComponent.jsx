import { React } from "react";


function activePassiveLink(name, currentPageName) {
    if (name == currentPageName)
        return "active-link"
    else return "passive-link"
}


export default function HeaderComponent(props) {

    return (
        <header>
                <div class="container header-container d_f jc_sb ai_c header-home">
                    <div class="menu-section1">
                        <a class="menu-section1_MPRR" href="">МПРР</a>
                    </div>
                    <div class="menu-section2">
                        <nav>
                            <ul class="header-menu d_f jc_sb">
                                <li class="header-menu_listitem"><a class={activePassiveLink("/index", props.page)} href="index">Главная</a></li>
                                <li class="header-menu_listitem"><a class={activePassiveLink("/city", props.page)} href="city">Города</a></li>
                                <li class="header-menu_listitem"><a class={activePassiveLink("/criterion", props.page)} href="criterion">Критерии</a></li>
                                <li class="header-menu_listitem"><a class={activePassiveLink("/cluster", props.page)} href="ourcity">Класстер</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>
    );
}
  