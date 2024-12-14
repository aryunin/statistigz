import { React, useState, useEffect } from "react";
import RegionsTableComponent from "../components/RegionsTableComponent";
import HideComponent from "../components/HideComponent";
import { useParams } from "react-router-dom";
import './../style_page_criterion.css';
// import Background from './../img/criterion_back.png';
import Background from './../img/criterion_back.jpg';
import { useRef } from 'react';

import axios from "axios";
import HeaderComponent from "../components/HeaderComponent";


export default function CriterionPage() {

    const resultRef = useRef(null);
    const [regions, setRegions] = useState([]);
    const [projectionId, setProjectionId] = useState(0);
    const [tableIsShow, setTableIsShow] = useState(false);

    const idToName = {
        1: "Экономика",
        2: "Образование",
        3: "Труд и занятость",
        4: "Семья",
        5: "Уровень жизни",
        6: "Демография",
        7: "Экология",
        8: "Внешняя торговля",
        9: "Инвестиции",
        10: "Здравоохранение",
        11: "Транспорт",
        12: "Культура и досуг",
        13: "Финансы",
        14: "Инновации",
        15: "Торговля и услуги",
        16: "Жильё",
        17: "Обобщённый критерий"
    };


    function selectedButtonStyle(id)
    {
        if (id == projectionId)
        {
            return { border: "5px solid white", cursor: "default"}
        }
        else
        {
            return { cursor: "pointer"}
        }
    }


    function selectedButtonClass(id)
    {
        if (id == projectionId)
        {
            return "circle-item"
        }
        else
        {
            return "circle-item non-active"
        }
    }

    function showTable(_projectionId) {
        if (_projectionId != projectionId) {
            fetch(`${process.env.REACT_APP_API_PROTOCOL}://${process.env.REACT_APP_API_HOST}:${process.env.REACT_APP_API_PORT}/${process.env.REACT_APP_API_PREFIX}/regions?projectionId=${_projectionId}`)
                .then((response) => response.json())
                .then((data) => {
                    setRegions(data);
                    setTableIsShow(true)
                    if (projectionId == 0)
                    {
                        setTimeout(() => {
                            resultRef.current?.scrollIntoView({
                                behavior: 'smooth'
                              })
                          }, 250)
                    }
                    else{
                        resultRef.current?.scrollIntoView({
                            behavior: 'smooth'
                          })
                    }
                    setProjectionId(_projectionId)
                })
                .catch((err) => {
                    console.log(err.message);
                });
        }
    }

    useEffect(() => {
        document.title = 'Критерии';
    }, []);

    return (
        <div>
            <HeaderComponent page='criterion'/>

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

            <section class='interactive_globe' style={{padding: '0px 0px 0px 0px'}}>
                <div style={{backgroundImage: `url(${Background})`, backgroundSize: 'cover', backgroundAttachment: 'fixed', paddingTop: "30px", paddingBottom: "30px"}}>
                {/* <div style={{backgroundImage: `url(${Background})`, backgroundSize: 'cover', padding: '0px 0px 50px 0px'}}> */}
                    <h2 style={{ color: "#FFCD8E",
    borderBottom: "2px solid #FFCD8E"}}>Интерактивный глобус</h2>
                    <div class="globe d_f ai_c jc_c">
                        <div class="globe-item__left">
                            <div class="globe-item">
                                <h3>1</h3>
                                <img src="img/globe.svg" alt=""/>
                                <p style={{color: "white"}}>Прочтите справочную <br/>
                                    часть о критериях -<br/>
                                    ниже</p>
                            </div>
                            <div class="globe-item globe-item__third pad-80">
                                <h3>3</h3>
                                <img src="img/globe.svg" alt=""/>
                                <p style={{color: "white"}}>Кликните по <br/>
                                    интересующему вас <br/>
                                    критерию</p>

                            </div>
                        </div>

                        <div class="criterion-circle">

                            <button title={idToName['1']} style={selectedButtonStyle(1)} class={selectedButtonClass(1)} onClick={() => showTable(1)}>
                                <img src="img/crit-economy.svg" alt=""/>
                            </button>

                            <button title={idToName['2']} style={selectedButtonStyle(2)} class={selectedButtonClass(2)} onClick={() => showTable(2)}>
                                <img src="img/crit-study.svg" alt=""/>
                            </button>

                            <button title={idToName['3']} style={selectedButtonStyle(3)} class={selectedButtonClass(3)} onClick={() => showTable(3)}>
                                <img src="img/crit-working-conditions.svg" alt=""/>
                            </button>

                            <button title={idToName['4']} style={selectedButtonStyle(4)} class={selectedButtonClass(4)} onClick={() => showTable(4)}>
                                <img src="img/crit-fosterfamily.svg" alt=""/>
                            </button>

                            <button title={idToName['5']} style={selectedButtonStyle(5)} class={selectedButtonClass(5)} onClick={() => showTable(5)}>
                                <img src="img/crit-life-insurance.svg" alt=""/>
                            </button>

                            <button title={idToName['6']} style={selectedButtonStyle(6)} class={selectedButtonClass(6)} onClick={() => showTable(6)}>
                                <img src="img/crit-social.svg" alt=""/>
                            </button>

                            <button title={idToName['7']} style={selectedButtonStyle(7)} class={selectedButtonClass(7)} onClick={() => showTable(7)}>
                                <img src="img/crit-ecology.svg" alt=""/>
                            </button>

                            <button title={idToName['8']} style={selectedButtonStyle(8)} class={selectedButtonClass(8)} onClick={() => showTable(8)}>
                                <img src="img/crit-ecommerce.svg" alt=""/>
                            </button>

                            <button title={idToName['9']} style={selectedButtonStyle(9)} class={selectedButtonClass(9)} onClick={() => showTable(9)}>
                                <img src="img/crit-investment.svg" alt=""/>
                            </button>

                            <button title={idToName['10']} style={selectedButtonStyle(10)} class={selectedButtonClass(10)} onClick={() => showTable(10)}>
                                <img src="img/crit-doctor.svg" alt=""/>
                            </button>

                            <button title={idToName['11']} style={selectedButtonStyle(11)} class={selectedButtonClass(11)} onClick={() => showTable(11)}>
                                <img src="img/crit-public-transport.svg" alt=""/>
                            </button>

                            <button title={idToName['12']} style={selectedButtonStyle(12)} class={selectedButtonClass(12)} onClick={() => showTable(12)}>
                                <img src="img/crit-cinema.svg" alt=""/>
                            </button>

                            <button title={idToName['13']} style={selectedButtonStyle(13)} class={selectedButtonClass(13)} onClick={() => showTable(13)}>
                                <img src="img/crit-calculator.svg" alt=""/>
                            </button>

                            <button title={idToName['14']} style={selectedButtonStyle(14)} class={selectedButtonClass(14)} onClick={() => showTable(14)}>
                                <img src="img/crit-innovation.svg" alt=""/>
                            </button>

                            <button title={idToName['15']} style={selectedButtonStyle(15)} class={selectedButtonClass(15)} onClick={() => showTable(15)}>
                                <img src="img/crit-ecommerce2.svg" alt=""/>
                            </button>

                            <button title={idToName['16']} style={selectedButtonStyle(16)} class={selectedButtonClass(16)} onClick={() => showTable(16)}>
                                <img src="img/crit-house.svg" alt=""/>
                            </button>


                            <button title={idToName['17']} style={selectedButtonStyle(17)} class={selectedButtonClass(17)} onClick={() => showTable(17)}>
                                <img src="img/crit_generic.svg" alt=""/>
                            </button>
                        </div>

                        <div class="globe-item__right">
                            <div class="globe-item globe-item__second">
                                <h3>2</h3>
                                <img src="img/globe.svg" alt=""/>
                                <p style={{color: "white"}}>Наведите курсор <br/>
                                    на один из <br/>
                                    элементов глобуса</p>
                            </div>
                            <div class="globe-item globe-item__fourth pad-80">
                                <h3>4</h3>
                                <img src="img/globe.svg" alt=""/>
                                <p style={{color: "white"}}>Ниже отобразилась <br/>
                                    информация по <br/>
                                    интересующему <br/>
                                    вас критерию</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

            <section ref={resultRef}>
                <HideComponent hidden={!tableIsShow} component={
                    <div><h2 style={{  marginTop: "30px"}}>{idToName[projectionId]}</h2>
                        <RegionsTableComponent regions={regions}/>
                    </div>
                    }/>
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
                            <div class="list-item__text"><p>Отношение среднедушевых доходов к прожиточному минимуму <br/>
                            Доля населения с доходами ниже величины прожиточного минимума <br/>
                            Коэффициент фондов (отношение доходов 10% населения с самыми высокими и 10% – с самыми низкими доходами)</p></div>
                            
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-social.svg" alt=""/>
                            <div class="list-item__text"><p>Коэффициент естественного прироста населения <br/>
                            Ожидаемая продолжительность жизни при рождении <br/>
                            Коэффициент миграционного прироста населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-ecology.svg" alt=""/>
                            <div class="list-item__text"><p>Лесовосстановление <br/>
                            Сброс загрязненных сточных водя <br/>
                            Выбросы загрязняющих веществ от стационарных источников</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-ecommerce.svg" alt=""/>
                            <div class="list-item__text"><p>Экспорт <br/>
                            Импорт <br/>
                            Экспорт технологий и услуг технологического характера</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-investment.svg" alt=""/>
                            <div class="list-item__text"><p>Степень износа основных фондов <br/>
                            Инвестиции в основной в % от ВРП <br/>
                            Поступление прямых иностранных инвестиций</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-doc.svg" alt=""/>
                            <div class="list-item__text"><p>Численность врачей на 1000 человек <br/>
                            Число больничных коек на 10000 чел.   населения <br/>
                            Заболеваемость на 1000 чел.   населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-transport.svg" alt=""/>
                            <div class="list-item__text"><p>Плотность автомобильных дорог общего пользования с твердым покрытием на 1000 км2 территории <br/>
                            Число собственных легковых автомобилей на 1000 чел. населения <br/>
                            Число дорожно-транспортных происшествий на 100000 населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-cinema.svg" alt=""/>
                            <div class="list-item__text"><p>Посещения театров и музеев на 1000   чел. <br/>
                            Общее количество плавательных   бассейнов на 1000 чел. <br/>
                            Число туров по России на 1000 чел.</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-calc.svg" alt=""/>
                            <div class="list-item__text"><p>Налоговые поступления в % к ВРП <br/>
                            Объем жилищных кредитов на душу населения <br/>
                            Вклады юридических и физических лиц на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-innovation.svg" alt=""/>
                            <div class="list-item__text"><p>Инновационная активность  <br/>
                            Интенсивность затрат на инновационную деятельность   <br/>
                            Доля инновационной продукции в общем объеме отгруженной продукции</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-eccommerce2.svg" alt=""/>
                            <div class="list-item__text"><p>Оборот розничной торговли на душу населения <br/>
                            Оборот общественного питания на душу населения <br/>
                            Объем платных услуг на душу населения</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-home.svg" alt=""/>
                            <div class="list-item__text"><p>Ввод в действие жилых домов на душу населения <br/>
                            Площадь жилья на одного жителя <br/>
                            Удельный вес расходов на ЖКХ в общей сумме потребительских расходов</p></div>
                        </div>
                        <div class="reference-list__item">
                            <img src="img/reference-generic.svg" alt=""/>
                            <div class="list-item__text"><p>Суммарно общий рейтинг</p></div>
                        </div>
                    </div>

                </div>
            </section>

            <footer>

            </footer>
        </div>
    );
}
