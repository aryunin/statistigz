import { React, useState, useEffect } from "react";
import RegionsTableComponent from "../components/RegionsTableComponent";
import HideComponent from "../components/HideComponent";
import HeaderComponent from "../components/HeaderComponent";
import './../ourcity.css';
import Radio from "../img/radio.png"
import RadioChecked from "../img/radiochecked.png"

function radioCircle(checked) {
    let radioStyle={marginTop: "0px",
        cursor: "pointer",
    verticalAlign: "middle", display:"inline"}

    if (checked){
        return (<img style={radioStyle} src={`${RadioChecked}`}/>)
    }
    else {
        return (<img style={radioStyle} src={`${Radio}`}/>)
    }
}


function createButton(state, setState, value, label) {
    let labelStyle={marginLeft: "5px",
        cursor: "pointer",
        verticalAlign: "middle", display:"inline"}
    let inputDivStyle={verticalAlign: "middle", alignItems: "center", marginTop: "10px",
        cursor: "pointer"}
    return (
        <div style={inputDivStyle} onClick={() => setState(value)}>{radioCircle(value==state)} <p style={labelStyle} for="">{label}</p><br/></div>
    )
}

function createButtons(state, setState, labels) {
    return labels.map((l, i) => createButton(state, setState, i, l))
}

function createQuestion(state, setState, labels, header) {
    let headerDivStyle={
        borderRadius: '15px', 
        backgroundColor: 'rgba(146, 194, 186, 1)', 
        margin: '0 auto', 
        // padding: "1px 0px 1px 0px",
        // display:"flex",
        alignItems: "center",
        justifyContent: "center"
        }
    let headerStyle={textAlign: "center", padding: "10px"}
    let inputsDivStyle={justifyContent: "center", display: "grid"}
    return (
        <div>
            <div style={headerDivStyle}>
                <h5 style={headerStyle}>{header}</h5>
            </div>
            <div style={inputsDivStyle}>
                {createButtons(state, setState, labels)}
            </div>
        </div>
    )
}


export default function OurCityPage() {
    
    const [filteredRegions, setFilteredRegions] = useState([]);
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
        document.title = 'Регион для вас';
        
        fetch(`http://${process.env.REACT_APP_API_HOST}:${process.env.REACT_APP_API_PORT}/${process.env.REACT_APP_API_PREFIX}/regions`)
            .then((response) => response.json())
            .then((data) => {
                console.log(data)
                const map1 = new Map();
                data.forEach(v =>  map1.set(v.id, v))
                setRegions(map1);
            })
            .catch((err) => {
                alert(err.message);
            });
    }, []);

    function req() {
        

        const answ = [q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,q17]


        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ answers: answ })
        };

        
        fetch(`http://${process.env.REACT_APP_API_HOST}:${process.env.REACT_APP_API_PORT}/${process.env.REACT_APP_API_PREFIX}/rcm`, requestOptions)
            .then((response) => response.json())
            .then((data) => {
                console.log(data)
                let ids = data.regionIds;  
                let arr = ids.map(v => regions.get(v));
                setFilteredRegions(arr);
                setTableIsShow(true);
            })
            .catch((err) => {
                alert(err.message);
            });
    }

    let labelStyle={marginLeft: "5px"}
    let radioStyle={marginTop: "15px"}
    // let inputsDivStyle={marginLeft: '45%', marginBottom: "10px"}
    let inputsDivStyle={justifyContent: "center", display: "grid"}
    let headerDivStyle={
        borderRadius: '15px', 
        backgroundColor: 'rgba(146, 194, 186, 1)', 
        margin: '0 auto', 
        // padding: "1px 0px 1px 0px",
        // display:"flex",
        alignItems: "center",
        justifyContent: "center"
        }
    let headerStyle={textAlign: "center", padding: "10px"}
    let inputDivStyle={verticalAlign: "middle", alignItems: "center"}
    let buttonDivStyle={
        borderRadius: "15px",
        width: "295px",
        borderRadius: '15px', 
        backgroundColor: 'rgba(146, 194, 186, 1)', 
        margin: '0 auto', 
        // padding: "1px 0px 1px 0px",
        // display:"flex",
        alignItems: "center",
        justifyContent: "center",
        cursor: "pointer"
        }

    return (    
        <div>
            <HeaderComponent page='ourcity'/>
            <section class='container section_header d_f ai_c jc_sb'>
                <p class="text_info">
                    <span>В данном разделе</span> - представлена 
                    анкета. Заполните её и вы получите список
                    топ-регионов, которые подходят именно вам
                    для ваших индивидуальных целей

                </p>
                <div class="info_name">
                    <h1>МПРР</h1>
                    <p>Регион для вас</p>
                </div>
            </section>
                <div style={{backgroundColor: '#FFFFFF'}}>
                    <div style={{inputDivStyle}}>
                        <h3 style={{border: 0, textAlign: "center", width: "100%", paddingTop: "30px", paddingBottom: "30px"}}>Заполните анкету</h3>
                    </div>
                    <div style={{borderRadius: '14px', 
                    backgroundColor: 'rgba(255, 205, 142, 1)', 
                    boxShadow: '8px 4px 4px rgba(0, 0, 0, 0.25)', 
                    border: '3px solid rgba(0, 0, 0, 1)',
                    width: '50%',
                    padding: '30px 60px 30px 60px', 
                    margin: '0 auto'}}>
                        <div class="form_action">
                            <form action="" name="form-city">

                                {createQuestion(q1, setQ1, ["12-16", "17-22", "23-27", "27-45", "более 45"], "1. Укажите ваш возраст")}
                                {createQuestion(q2, setQ2, ["Мужской", "Женский"], "2. Укажите ваш пол")}
                                {createQuestion(q3, setQ3, ["Для переезда и постоянного проживания", 
                                    "Для временного проживания (от месяца до года)", 
                                    "Для временного проживания (от года до трёх лет)", 
                                    "Для отдыха (до месяца)"],
                                     "3. Представьте, что есть система персональной подборки лучших регионов, которые вам наиболее всего подходят, для чего вы бы рассматривали этот список?")}
                                {createQuestion(q4, setQ4, ["Замужем/женат (нет детей)", 
                                    "Замужем/женат (есть дети)", 
                                    "Не женат/ не замужем (нет детей)",
                                    "Не женат/ не замужем (есть дети)",
                                    "Планирую семью"],
                                     "4. Семейное положение")}
                                {createQuestion(q5, setQ5, [
                                    "Не интересует совершенно",
                                    "Не интересует",
                                    "Безразлично",
                                    "Интересует",
                                    "Очень сильно интересует"],
                                     "5. Насколько сильно вас интересует вопрос экологии в регионе будущего проживания?")}
                                     {createQuestion(q6, setQ6, [
                                         "Своё жильё",
                                         "Живу с родителями",
                                         "Съёмное",
                                         "Общежитие"],
                                          "6. Условия вашего проживания")}
                                {createQuestion(q7, setQ7, [
                                    "Не интересует совершенно",
                                    "Не интересует",
                                    "Безразлично",
                                    "Интересует",
                                    "Очень сильно интересует"],
                                     "7. Интересует ли вас уровень заработной платы в регионе?")}
                                {createQuestion(q8, setQ8, [
                                    "Не интересует совершенно",
                                    "Не интересует",
                                    "Безразлично",
                                    "Интересует",
                                    "Очень сильно интересует"],
                                     "8. Насколько для вас важна оснащенность региона местами культурного назначения (парки, театры, кинозалы)?")}
                                {createQuestion(q9, setQ9, [
                                    "Не пользуюсь совсем",
                                    "Редко пользуюсь",
                                    "Пользуюсь время от времени",
                                    "Использую часто",
                                    "Пользуюсь ежедневно"],
                                     "9. Как часто вы пользуетесь общественным транспортом (личным авто)?")}
                                {createQuestion(q10, setQ10, [
                                    "Не слежу совершенно",
                                    "Не слежу",
                                    "Безразлично",
                                    "Слежу",
                                    "Очень часто слежу"],
                                     "10. Насколько внимательно вы следите за новшествами в технической области?")}
                                {createQuestion(q11, setQ11, [
                                    "Нет, совершенно",
                                    "Скорее нет",
                                    "Не часто, но нуждаюсь",
                                    "Нуждаюсь переоически",
                                    "Часто нуждаюсь"],
                                     "11. Часто ли вы нуждаетесь в качественной медицинской помощи?")}
                                {createQuestion(q12, setQ12, [
                                    "Нет, совершенно",
                                    "Скорее нет",
                                    "Не часто, но нуждаюсь",
                                    "Нуждаюсь переоически",
                                    "Часто нуждаюсь"],
                                     "12. Часто ли пользуетесь различными услугами в регионе (например, доставкой)?")}
                                {createQuestion(q13, setQ13, [
                                    "Не важен совершенно",
                                    "Не важен",
                                    "Безразлично",
                                    "Важен",
                                    "Очень важен"],
                                     "13. Насколько для вас важен средний уровень жизни в регионе?")}
                                {createQuestion(q14, setQ14, [
                                    "Не важна совершенно",
                                    "Не важна",
                                    "Безразлична",
                                    "Важна",
                                    "Очень важна"],
                                     "14. Важна ли для вас финансовая составляющая региона? (Насколько он богат за счет собственных средств и налоговых сборов)")}
                                {createQuestion(q15, setQ15, [
                                    "Не важен совершенно",
                                    "Не важен",
                                    "Безразлично",
                                    "Важен",
                                    "Очень важен"],
                                     "15. Важен ли для вас показатель уровня образования в регионе?")}
                                {createQuestion(q16, setQ16, [
                                    "Не важна совершенно",
                                    "Не важна",
                                    "Безразлична",
                                    "Важна",
                                    "Очень важна"],
                                     "16. Насколько важна удовлетворенность от экономической деятельности региона? (для предпринимателей)")}
                                {createQuestion(q17, setQ17, [
                                    "Нет",
                                    "Затрудняюсь ответить",
                                    "Да"],
                                     "17. Планируете ли вы устраиваться на работу в новом регионе?")}
                            </form>
                            <div style={buttonDivStyle} onClick={() => {req(); setTableIsShow(true) }}>
                                <h5 style={headerStyle}>Отправить</h5>
                            </div>
                        </div>
                    </div>
                </div>
            <br/>
            <HideComponent hidden={!tableIsShow} component={<RegionsTableComponent regions={filteredRegions}/>}/>
        </div>
    );
}
