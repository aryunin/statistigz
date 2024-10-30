import { React, useState, useEffect } from "react";
import RegionsTableComponent from "../components/RegionsTableComponent";
import HideComponent from "../components/HideComponent";
import './../ourcity.css';

export default function OurCityPage() {

    const [allRegions, setAllRegions] = useState();
    const [regions, setRegions] = useState([]);
    const [tableIsShow, setTableIsShow] = useState(false);

    const [q1, setQ1] = useState(0)
    const [q2, setQ2] = useState(0)
    const [q3, setQ3] = useState(0)
    const [q4, setQ4] = useState(0)
    const [q5, setQ5] = useState(0)
    const [q6, setQ6] = useState(0)
    const [q7, setQ7] = useState(0)
    const [q8, setQ8] = useState(0)
    const [q9, setQ9] = useState(0)
    const [q10, setQ10] = useState(0)
    const [q11, setQ11] = useState(0)
    const [q12, setQ12] = useState(0)
    const [q13, setQ13] = useState(0)
    const [q14, setQ14] = useState(0)
    const [q15, setQ15] = useState(0)
    const [q16, setQ16] = useState(0)
    const [q17, setQ17] = useState(0)

    useEffect(() => {
        document.title = 'Регионы';
        fetch('http://localhost:8080/api/regions')
            .then((response) => response.json())
            .then((data) => {
                
                const map1 = new Map();
                data.forEach(v =>  map1.set(v.id, v))

                setAllRegions(map1);
            })
            .catch((err) => {
                alert(err.message);
            });
    }, []);

    function req() {
        let ids = [1,2,3];
        let arr = ids.map(v => allRegions.get(v));
        setRegions(arr);

        // const answ = [q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17]


        // const requestOptions = {
        //     method: 'POST',
        //     headers: { 'Content-Type': 'application/json' },
        //     body: JSON.stringify({ answers: answ })
        // };
        // // console.log(JSON.stringify({ answers: answ } ))
        // fetch('http://localhost:8080/', requestOptions)
        //     .then(response => response.json())
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
                                <li class="header-menu_listitem"><a class="passive-link" href="city.html">Города</a></li>
                                <li class="header-menu_listitem"><a class="passive-link" href="">Критерии</a></li>
                                <li class="header-menu_listitem"><a class="active-link" href="ourcity.html">Класстер</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </header>

            <div class="form_action">
                <form action="" name="form-city">
                    <h3>Заполните анкету</h3>
                    <div class="question1">
                        <h5>1. Укажите ваш возраст</h5>
                        <input type="radio" name="old" value="12-16" onClick={() => setQ1(0)}/> <label for="">12-16</label><br/>
                        <input type="radio" name="old" value="17-22" onClick={() => setQ1(1)}/> <label for="">17-22</label><br/>
                        <input type="radio" name="old" value="23-27" onClick={() => setQ1(2)}/> <label for="">23-27</label><br/>
                        <input type="radio" name="old" value="28-25" onClick={() => setQ1(3)}/> <label for="">27-45</label><br/>
                        <input type="radio" name="old" value="b45"   onClick={() => setQ1(4)}/> <label for="">более 45</label><br/>
                    </div>

                    <div class="question2">
                        <h5>2. Укажите ваш пол</h5>
                        <input type="radio" name="gender" value="M" onClick={() => setQ2(0)}/> <label for="">Мужской</label><br/>
                        <input type="radio" name="gender" value="W" onClick={() => setQ2(1)}/> <label for="">Женский</label><br/>
                    </div>

                    <div class="question3">
                        <h5>3. Представьте, что есть система персональной <br/>подборки лучших регионов, которые вам наиболее всего подходят, <br/>для чего вы бы рассматривали этот список?</h5>
                        <input type="radio" name="live" value="go1" onClick={() => setQ3(0)}/> <label for="">Для переезда и постоянного
                            проживания</label><br/>
                        <input type="radio" name="live" value="go2" onClick={() => setQ3(1)}/> <label for="">Для временного проживания (от
                            месяца до года)</label><br/>
                        <input type="radio" name="live" value="go3" onClick={() => setQ3(2)}/> <label for="">Для временного проживания (от года
                            до трёх лет)</label><br/>
                        <input type="radio" name="live" value="go4 onClick={() => setQ2(0)}"/> <label for="">Для отдыха (до месяца)</label><br/>
                    </div>

                    <div class="question4">
                        <h5>4. Семейное положение</h5>
                        <input type="radio" name="family" value="fam1" onClick={() => setQ4(0)}/> <label for="">Замужем/женат (нет детей)</label><br/>
                        <input type="radio" name="family" value="fam2" onClick={() => setQ4(1)}/> <label for="">Замужем/женат (есть дети)</label><br/>
                        <input type="radio" name="family" value="fam3" onClick={() => setQ4(2)}/> <label for="">Не женат/ не замужем (нет детей)</label><br/>
                        <input type="radio" name="family" value="fam4" onClick={() => setQ4(3)}/> <label for="">Не женат/ не замужем (есть дети)</label><br/>
                        <input type="radio" name="family" value="fam5" onClick={() => setQ4(4)}/> <label for="">Планирую семью</label><br/>
                    </div>

                    <div class="question5">
                        <h5>5. Насколько сильно вас интересует вопрос <br/>экологии в регионе будущего проживания?</h5>
                        <input type="radio" name="ecolog" value="eco1" onClick={() => setQ5(0)}/> <label for="">Не интересует совершенно</label><br/>
                        <input type="radio" name="ecolog" value="eco2" onClick={() => setQ5(1)}/> <label for="">Не интересует</label><br/>
                        <input type="radio" name="ecolog" value="eco3" onClick={() => setQ5(2)}/> <label for="">Безразлично</label><br/>
                        <input type="radio" name="ecolog" value="eco4" onClick={() => setQ5(3)}/> <label for="">Интересует</label><br/>
                        <input type="radio" name="ecolog" value="eco5" onClick={() => setQ5(4)}/> <label for="">Очень сильно интересует</label><br/>
                    </div>

                    <div class="question6">
                        <h5>6. Условия вашего проживания</h5>
                        <input type="radio" name="home" value="hm1" onClick={() => setQ6(0)}/> <label for="">Своё жильё</label><br/>
                        <input type="radio" name="home" value="hm2" onClick={() => setQ6(1)}/> <label for="">Живу с родителями</label><br/>
                        <input type="radio" name="home" value="hm3" onClick={() => setQ6(2)}/> <label for="">Съёмное</label><br/>
                        <input type="radio" name="home" value="hm4" onClick={() => setQ6(3)}/> <label for="">Общежитие</label><br/>
                    </div>

                    <div class="question7">
                        <h5>7. Интересует ли вас уровень заработной платы в регионе?</h5>
                        <input type="radio" name="money" value="mon1" onClick={() => setQ7(0)}/> <label for="">Не интересует совершенно</label><br/>
                        <input type="radio" name="money" value="mon2" onClick={() => setQ7(1)}/> <label for="">Не интересует</label><br/>
                        <input type="radio" name="money" value="mon3" onClick={() => setQ7(2)}/> <label for="">Безразлично</label><br/>
                        <input type="radio" name="money" value="mon4" onClick={() => setQ7(3)}/> <label for="">Интересует</label><br/>
                        <input type="radio" name="money" value="mon5" onClick={() => setQ7(4)}/> <label for="">Очень сильно интересует</label><br/>
                    </div>

                    <div class="question8">
                        <h5>8. Насколько для вас важна оснащенность региона <br/>местами культурного назначения (парки, театры, кинозалы)?</h5>
                        <input type="radio" name="arhit" value="arh1" onClick={() => setQ8(0)}/> <label for="">Не интересует совершенно</label><br/>
                        <input type="radio" name="arhit" value="arh2" onClick={() => setQ8(1)}/> <label for="">Не интересует</label><br/>
                        <input type="radio" name="arhit" value="arh3" onClick={() => setQ8(2)}/> <label for="">Безразлично</label><br/>
                        <input type="radio" name="arhit" value="arh4" onClick={() => setQ8(3)}/> <label for="">Интересует</label><br/>
                        <input type="radio" name="arhit" value="arh5" onClick={() => setQ8(4)}/> <label for="">Очень сильно интересует</label><br/>
                    </div>

                    <div class="question9">
                        <h5>9. Как часто вы пользуетесь общественным транспортом (личным авто)?</h5>
                        <input type="radio" name="auto" value="aut1" onClick={() => setQ9(0)}/> <label for="">Не пользуюсь совсем</label><br/>
                        <input type="radio" name="auto" value="aut2" onClick={() => setQ9(1)}/> <label for="">Редко пользуюсь</label><br/>
                        <input type="radio" name="auto" value="aut3" onClick={() => setQ9(2)}/> <label for="">Пользуюсь время от времени</label><br/>
                        <input type="radio" name="auto" value="aut4" onClick={() => setQ9(3)}/> <label for="">Использую часто</label><br/>
                        <input type="radio" name="auto" value="aut5" onClick={() => setQ9(4)}/> <label for="">Пользуюсь ежедневно</label><br/>
                    </div>

                    <div class="question10">
                        <h5>10. Насколько внимательно вы следите за новшествами в технической области?</h5>
                        <input type="radio" name="innovation" value="inn1" onClick={() => setQ10(0)}/> <label for="">Не слежу совершенно</label><br/>
                        <input type="radio" name="innovation" value="inn2" onClick={() => setQ10(1)}/> <label for="">Не слежу</label><br/>
                        <input type="radio" name="innovation" value="inn3" onClick={() => setQ10(2)}/> <label for="">Безразлично</label><br/>
                        <input type="radio" name="innovation" value="inn4" onClick={() => setQ10(3)}/> <label for="">Слежу</label><br/>
                        <input type="radio" name="innovation" value="inn5" onClick={() => setQ10(4)}/> <label for="">Очень часто слежу</label><br/>
                    </div>

                    <div class="question11">
                        <h5>11. Часто ли вы нуждаетесь в качественной медицинской помощи?</h5>
                        <input type="radio" name="medicine" value="med1" onClick={() => setQ11(0)}/> <label for="">Нет, совершенно</label><br/>
                        <input type="radio" name="medicine" value="med2" onClick={() => setQ11(1)}/> <label for="">Скорее нет</label><br/>
                        <input type="radio" name="medicine" value="med3" onClick={() => setQ11(2)}/> <label for="">Не часто, но нуждаюсь</label><br/>
                        <input type="radio" name="medicine" value="med4" onClick={() => setQ11(3)}/> <label for="">Нуждаюсь переоически</label><br/>
                        <input type="radio" name="medicine" value="med5" onClick={() => setQ11(4)}/> <label for="">Часто нуждаюсь</label><br/>
                    </div>

                    <div class="question12">
                        <h5>12. Часто ли пользуетесь различными услугами в регионе (например, доставкой)? </h5>
                        <input type="radio" name="services" value="ser1" onClick={() => setQ12(0)}/> <label for="">Нет, совершенно</label><br/>
                        <input type="radio" name="services" value="ser2" onClick={() => setQ12(1)}/> <label for="">Скорее нет</label><br/>
                        <input type="radio" name="services" value="ser3" onClick={() => setQ12(2)}/> <label for="">Не часто, но нуждаюсь</label><br/>
                        <input type="radio" name="services" value="ser4" onClick={() => setQ12(3)}/> <label for="">Нуждаюсь переоически</label><br/>
                        <input type="radio" name="services" value="ser5" onClick={() => setQ12(4)}/> <label for="">Часто нуждаюсь</label><br/>
                    </div>

                    <div class="question13">
                        <h5>13. Насколько для вас важен средний уровень жизни в регионе? </h5>
                        <input type="radio" name="average" value="aver1" onClick={() => setQ13(0)}/> <label for="">Не важен совершенно</label><br/>
                        <input type="radio" name="average" value="aver2" onClick={() => setQ13(1)}/> <label for="">Не важен</label><br/>
                        <input type="radio" name="average" value="aver3" onClick={() => setQ13(2)}/> <label for="">Безразлично</label><br/>
                        <input type="radio" name="average" value="aver4" onClick={() => setQ13(3)}/> <label for="">Важен</label><br/>
                        <input type="radio" name="average" value="aver5" onClick={() => setQ13(4)}/> <label for="">Очень важен</label><br/>
                    </div>

                    <div class="question14">
                        <h5>14. Важна ли для вас финансовая составляющая региона? <br/>(Насколько он богат за счет собственных средств и налоговых сборов)</h5>
                        <input type="radio" name="finance" value="fin1" onClick={() => setQ14(0)}/> <label for="">Не важна совершенно</label><br/>
                        <input type="radio" name="finance" value="fin2" onClick={() => setQ14(1)}/> <label for="">Не важна</label><br/>
                        <input type="radio" name="finance" value="fin3" onClick={() => setQ14(2)}/> <label for="">Безразлична</label><br/>
                        <input type="radio" name="finance" value="fin4" onClick={() => setQ14(3)}/> <label for="">Важна</label><br/>
                        <input type="radio" name="finance" value="fin5" onClick={() => setQ14(4)}/> <label for="">Очень важна</label><br/>
                    </div>

                    <div class="question15">
                        <h5>15. Важен ли для вас показатель уровня образования в регионе?  </h5>
                        <input type="radio" name="education" value="edu1" onClick={() => setQ15(0)}/> <label for="">Не важен совершенно</label><br/>
                        <input type="radio" name="education" value="edu2" onClick={() => setQ15(1)}/> <label for="">Не важен</label><br/>
                        <input type="radio" name="education" value="edu3" onClick={() => setQ15(2)}/> <label for="">Безразлично</label><br/>
                        <input type="radio" name="education" value="edu4" onClick={() => setQ15(3)}/> <label for="">Важен</label><br/>
                        <input type="radio" name="education" value="edu5" onClick={() => setQ15(4)}/> <label for="">Очень важен</label><br/>
                    </div>

                    <div class="question16">
                        <h5>16. Насколько важна удовлетворенность от экономической деятельности региона? (для предпринимателей)</h5>
                        <input type="radio" name="economy" value="ecnm1" onClick={() => setQ16(0)}/> <label for="">Не важна совершенно</label><br/>
                        <input type="radio" name="economy" value="ecnm2" onClick={() => setQ16(1)}/> <label for="">Не важна</label><br/>
                        <input type="radio" name="economy" value="ecnm3" onClick={() => setQ16(2)}/> <label for="">Безразлична</label><br/>
                        <input type="radio" name="economy" value="ecnm4" onClick={() => setQ16(3)}/> <label for="">Важна</label><br/>
                        <input type="radio" name="economy" value="ecnm5" onClick={() => setQ16(4)}/> <label for="">Очень важна</label><br/>
                    </div>

                    <div class="question17">
                        <h5>17. Планируете ли вы устраиваться на работу в новом регионе?</h5>
                        <input type="radio" name="work" value="wrk1" onClick={() => setQ17(0)}/> <label for="">Да</label><br/>
                        <input type="radio" name="work" value="wrk2" onClick={() => setQ17(1)}/> <label for="">Нет</label><br/>
                        <input type="radio" name="work" value="wrk3" onClick={() => setQ17(2)}/> <label for="">Затрудняюсь ответить</label><br/>
                    </div>

                </form>
                <button onClick={() => {req(); setTableIsShow(true) }}>Отправить</button>
            </div>
            <br/>
            <HideComponent hidden={!tableIsShow} component={<RegionsTableComponent regions={regions}/>}/>
        </div>
    );
}
