import { React, useState, useEffect } from "react";
import RegionsTableComponent from "../components/RegionsTableComponent";
import HideComponent from "../components/HideComponent";
import { useParams } from "react-router-dom";
import './../style_page_criterion.css';
import icon_cheklist from './../img/icon-cheklist.svg';

import axios from "axios";

export default function CriterionPage() {

    const [regions, setRegions] = useState([]);
    const [projectionId, setProjectionId] = useState(0);
    const [tableIsShow, setTableIsShow] = useState(false);

    function showTable(_projectionId) {
        if (_projectionId == projectionId) {
            setTableIsShow(false)
        }
        else {
            fetch(`http://localhost:8080/api/regions?projectionId=${_projectionId}`)
                .then((response) => response.json())
                .then((data) => {
                    setRegions(data);
                    setProjectionId(_projectionId)
                    setTableIsShow(true)
                })
                .catch((err) => {
                    alert(err.message);
                });
        }
    }

    return (
        <div>
            <header>
                <div class="container header-container d_f jc_sb ai_c header-home">
                    <div class="menu-section1">
                        <a class="menu-section1_MPRR" href="">МПРР</a>
                    </div>
                    <div class="menu-section2">
                        <nav>
                            <ul class="header-menu d_f jc_sb">
                                <li class="header-menu_listitem"><a class="passive-link" href="index.html">Главная</a></li>
                                <li class="header-menu_listitem"><a class="passive-link" href="">Города</a></li>
                                <li class="header-menu_listitem"><a class="active-link" href="">Критерии</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>

            <section class='container section_header d_f ai_c jc_sb'>
                <p class="text_info">
                    <span>В данном разделе</span> - представлен
                    интерактивный глобус с данными
                    по критериям оценивания
                    каждого региона России. Наша задача -
                    наиболее структурированно и точно
                    предоставить вам информацию
                    об интересующем вас критерии
                </p>
                <div class="info_name">
                    <h1>МПРР</h1>
                    <p>Критерии оценивания регионов </p>
                </div>
            </section>

            <section class='section_info d_f'>
                <div class="container d_f jc_sa">
                    <div class="atributs d_g ji_c">
                        <img src="img/interactive-globe.svg" alt=""/>
                        <strong>Интерактивный глобус</strong>
                        <p>Это удобный инструмент
                            для представления подробной информации
                            о рейтингах городов по различным
                            критериям оценивания </p>
                    </div>
                    <div class="atributs d_g ji_c">
                        <img src='img/icon-cheklist.svg' alt=""/>
                        <strong>Критерии</strong>
                        <p>Всего представлено
                            16 различных критериев и один общий.
                            Кликнув на один из элемент глобуса,
                            вы узнаете полную статистику
                            по выбранному критерию </p>
                    </div>
                        <div class="atributs d_g ji_c">
                            <img class="icon-info" src="img/icon-info.svg" alt=""/>
                            <strong>Информация</strong>
                            <p>Справочная часть по каждому
                                    критерию находится в нижней части
                                    данного раздела. Там вы можете
                                    узнать, что означает каждый
                                    элемент интерактивного глобуса
                                    и как производятся расчеты
                                    по каждому критерию
                            </p>
                    </div>
                </div>
            </section>

            <section class='interactive_globe'>
                <div class="container">
                    <h2>Интерактивный глобус</h2>
                    <div class="globe d_f ai_c jc_c">
                        <div class="globe-item__left">
                            <div class="globe-item">
                                <h3>1</h3>
                                <img src="img/globe.svg" alt=""/>
                                <p>Прочтите справочную <br/>
                                    часть о критериях -<br/>
                                    ниже</p>
                            </div>
                            <div class="globe-item globe-item__third pad-80">
                                <h3>3</h3>
                                <img src="img/globe.svg" alt=""/>
                                <p>Кликните по <br/>
                                    интересующему вас <br/>
                                    критерию</p>

                            </div>
                        </div>

                        <div class="criterion-circle">

                            <button href="#" class="circle-item" onClick={() => showTable(1)}>
                                <img src="img/crit-economy.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(2)}>
                                <img src="img/crit-study.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(3)}>
                                <img src="img/crit-working-conditions.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(4)}>
                                <img src="img/crit-fosterfamily.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(5)}>
                                <img src="img/crit-life-insurance.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(6)}>
                                <img src="img/crit-social.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(7)}>
                                <img src="img/crit-ecology.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(8)}>
                                <img src="img/crit-ecommerce.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(9)}>
                                <img src="img/crit-investment.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(10)}>
                                <img src="img/crit-doctor.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(11)}>
                                <img src="img/crit-public-transport.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(12)}>
                                <img src="img/crit-cinema.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(13)}>
                                <img src="img/crit-calculator.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(14)}>
                                <img src="img/crit-innovation.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(15)}>
                                <img src="img/crit-ecommerce2.svg" alt=""/>
                            </button>

                            <button href="#" class="circle-item" onClick={() => showTable(16)}>
                                <img src="img/crit-house.svg" alt=""/>
                            </button>


                            <button href="#" class="circle-item" onClick={() => showTable(17)}>
                                <img src="img/crit_generic.svg" alt=""/>
                            </button>
                        </div>

                        <div class="globe-item__right">
                            <div class="globe-item globe-item__second">
                                <h3>2</h3>
                                <img src="img/globe.svg" alt=""/>
                                <p>Наведите курсор <br/>
                                    на один из <br/>
                                    элементов глобуса</p>
                            </div>
                            <div class="globe-item globe-item__fourth pad-80">
                                <h3>4</h3>
                                <img src="img/globe.svg" alt=""/>
                                <p>Ниже отобразилась <br/>
                                    информация по <br/>
                                    интересующему <br/>
                                    вас критерию</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <section class='reference_part'>
                <div class="container">
                    <h2>Справочная часть</h2>
                    <div class="reference-list">
                        <div class="reference-list__item">
                            <img src="img/reference-economy.svg" alt=""/>
                            <div class="list-item__text"> <p>Объем продукции сельского хозяйства на душу населения<br/>
                                Объем строительства на душу населения<br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-study.svg" alt=""/>
                            <div class="list-item__text"><p>Охват дошкольным образованием<br/>
                                Число студентов организаций среднего специального образования на 10000 населения<br/>
                                Число студентов организаций высшего образования на 10000 населения</p></div>
                            
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-work.svg" alt=""/>
                            <div class="list-item__text"><p>Уровень безработицы<br/>
                                Среднемесячная номинальная заработная плата<br/>
                                Численность занятых на одного пенсионера</p></div>
                            
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-family.svg" alt=""/>
                            <div class="list-item__text"> <p>Число разводов на 1000 браков<br/>
                                Суммарный коэффициент рождаемости (отношение числа родившихся <br/>
                                на год на число женщин в возрасте от 15 до 50 лет)<br/>
                                Ввод в действие дошкольных организаций на душу населения</p></div>
                        
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-lifeinsur.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                            
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-social.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-ecology.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-ecommerce.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-investment.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-doc.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-transport.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-cinema.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-calc.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-innovation.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-eccommerce2.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-home.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-generic.svg" alt=""/>
                            <div class="list-item__text"><p>Объем продукции сельского хозяйства на душу населения <br/>
                                Объем строительства на душу населения <br/>
                                Объем продукции обрабатывающего производства на душу населения</p></div>
                        </div>
                    </div>

                </div>
            </section>

            <HideComponent hidden={!tableIsShow} component={<RegionsTableComponent regions={regions}/>}/>

            <footer>

            </footer>
        </div>
    );
}
