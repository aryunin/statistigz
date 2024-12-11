import { React, useState, useEffect } from "react";
import RegionsMapComponent from "../components/RegionsMapComponent";
import './../city.css';
import HeaderComponent from "../components/HeaderComponent";

function ZeroIfIncludeElseOne(str, substr)
{
    return str.toLowerCase().includes(substr.toLowerCase()) ? 1 : 0
}
const regNames =
    [
        ['SPB', 'Санкт-Петербург'],
        ['SVS', 'Севастополь'],
        ['MSK', 'Москва'],
        ['MYR', 'Мурманск'],
        
        ['KAR', 'Карелия'],
        ['NEN', 'Ненецкий автономный округ'],
        ['CHYK', 'Чукотка'],
        ['KAM', 'Камчатский край'],
        
        ['LEN', 'Ленинградская область'],
        ['NOV', 'Новгородская область'],
        ['VOL', 'Волгоградская область'],
        ['ARH', 'Архангельская область'],
        ['KOMI', 'Республика Коми'],
        ['YMAL', 'Ямало-Ненецкий автономный округ'],
        ['KRAS', 'Краснодарский край'],
        ['SAHA', 'Республика Саха (Якутия)'],
        ['MAG', 'Магаданская область'],
        
        ['KNG', 'Калининградская область'],
        ['PSK', 'Псковская область'],
        ['TVER', 'Тверская область'],
        ['YRO', 'Ярославская область'],
        ['IVA', 'Ивановская область'],
        ['KOS', 'Костромская область'],
        ['MARI', 'Республика Марий Эл'],
        ['KIR', 'Кировская область'],
        ['PER', 'Пермский край'],
        ['HAN', 'Ханты-Мансийский автономный округ - Югра'],
        ['TUM', 'Тюменская область'],
        ['TOM', 'Томская область'],
        ['KEM', 'Кемеровская область — Кузбасс'],
        ['IRK', 'Иркутская область'],
        ['AMUR', 'Амурская область'],
        ['HAB', 'Хабаровский край'],
        ['SHLN', 'Сахалинская область'],

        ['SMOL', 'Смоленская область'],
        ['KALU', 'Калужская область'],
        ['MOS', 'Московская область'],
        ['VLA', 'Владимирская область'],
        ['NN', 'Нижегородская область'],
        ['CHYV', 'Чувашская Республика - Чувашия'],
        ['TAT', 'Республика Татарстан'],
        ['UDM', 'Удмуртская Республика'],
        ['SVER', 'Свердловская область'],
        ['KURG', 'Курганская область'],
        ['NOVO', 'Новосибирская область'],
        ['HAK', 'Республика Хакасия'],
        ['BUR', 'Республика Бурятия'],
        ['EVR', 'Еврейская автономная область'],

        ['BRY', 'Брянская область'],
        ['ORL', 'Орловская область'],
        ['TUL', 'Тульская область'],
        ['RYZ', 'Рязанская область'],
        ['MOR', 'Республика Мордовия'],
        ['UL', 'Ульяновская область'],
        ['SAM', 'Самарская область'],
        ['BSHK', 'Республика Башкортостан'],
        ['CHEL', 'Челябинская область'],
        ['OMSK', 'Омская область'],
        ['TUVA', 'Республика Тыва'],
        ['ALTK', 'Алтайский край'],
        ['ZAB', 'Забайкальский край'],
        ['PRI', 'Приморский край'],
        
        ['LNR', 'Луганская Народная Республика'],
        ['KUR', 'Курская область'],
        ['LIP', 'Липецкая область'],
        ['TAM', 'Тамбовская область'],
        ['PEN', 'Пензенская область'],
        ['SAR', 'Саратовская область'],
        ['ORNB', 'Оренбургская область'],

        ['ALT', 'Республика Алтай'],
        ['HRS', 'Херсонская область'],
        ['ZUP', 'Запорожская область'],
        ['DNR', 'Донецкая Народная Республика'],
        ['BEL', 'Белгородская область'],
        ['VOR', 'Воронежская область'],
        ['VOLG', 'Волгоградская область'],

        ['KRUM', 'Республика Крым'],
        ['ADUG', 'Республика Адыгея'],
        ['KRDR', 'Красноярский край'],
        ['ROS', 'Ростовская область'],
        ['KULM', 'Республика Калмыкия'],
        ['AST', 'Астраханская область'],

        ['KCHR', 'Карачаево-Черкесская Республика'],
        ['STUV', 'Ставропольский край'],
        ['CHECH', 'Чеченская Республика'],
        ['DUG', 'Республика Дагестан'],

        ['KUB', 'Кабардино-Балкарская Республика'],
        ['SOS', 'Республика Северная Осетия - Алания'],
        ['ING', 'Республика Ингушетия'],
    ]


const regNamesMap = new Map();
regNames.forEach((v, i, a) => { 
        const [key, val] = v;
        regNamesMap.set(key, val); })

function regionsOpacities(str)
{
    const map1 = new Map();
    regNames.forEach((v, i, a) => { 
            const [key, val] = v;
            map1.set(key, ZeroIfIncludeElseOne(val, str)); })
            
    return map1;
}
function regionsId()
{
    const map1 = new Map();
    const arr =
        [
            ['SPB', '28'],
            ['SVS', '36'],
            ['MSK', '18'],
            ['MYR', '25'],
            
            ['KAR', '19'],
            // ['NEN', 'Ненецкий автономный округ'],
            ['CHYK', '82'],
            ['KAM', '75'],
            
            ['LEN', '24'],
            ['NOV', '26'],
            ['VOL', '34'],
            ['ARH', '21'],
            ['KOMI', '20'],
            // ['YMAL', 'Ямало-Ненецкий автономный округ'],
            ['KRAS', '32'],
            ['SAHA', '74'],
            ['MAG', '79'],
            
            ['KNG', '23'],
            ['PSK', '27'],
            ['TVER', '15'],
            ['YRO', '17'],
            ['IVA', '5'],
            ['KOS', '7'],
            ['MARI', '45'],
            ['KIR', '51'],
            ['PER', '50'],
            // ['HAN', 'Ханты-Мансийский автономный округ - Югра'],
            ['TUM', '60'],
            ['TOM', '73'],
            ['KEM', '70'],
            ['IRK', '69'],
            ['AMUR', '78'],
            ['HAB', '77'],
            ['SHLN', '80'],

            ['SMOL', '13'],
            ['KALU', '6'],
            ['MOS', '10'],
            ['VLA', '3'],
            ['NN', '52'],
            ['CHYV', '49'],
            ['TAT', '47'],
            ['UDM', '48'],
            ['SVER', '59'],
            ['KURG', '58'],
            ['NOVO', '71'],
            ['HAK', '65'],
            ['BUR', '63'],
            ['EVR', '81'],

            ['BRY', '2'],
            ['ORL', '11'],
            ['TUL', '16'],
            ['RYZ', '12'],
            ['MOR', '46'],
            ['UL', '57'],
            ['SAM', '55'],
            ['BSHK', '44'],
            ['CHEL', '61'],
            ['OMSK', '72'],
            ['TUVA', '64'],
            ['ALTK', '66'],
            ['ZAB', '67'],
            ['PRI', '76'],
            
            // ['LNR', 'Луганская Народная Республика'],
            ['KUR', '8'],
            ['LIP', '9'],
            ['TAM', '14'],
            ['PEN', '54'],
            ['SAR', '56'],
            ['ORNB', '53'],

            ['ALT', '62'],
            // ['HRS', 'Херсонская область'],
            // ['ZUP', 'Запорожская область'],
            // ['DNR', 'Донецкая Народная Республика'],
            ['BEL', '1'],
            ['VOR', '4'],
            ['VOLG', '34'],

            ['KRUM', '31'],
            ['ADUG', '29'],
            ['KRDR', '32'],
            ['ROS', '35'],
            ['KULM', '30'],
            ['AST', '33'],

            ['KCHR', '40'],
            ['STUV', '43'],
            ['CHECH', '42'],
            ['DUG', '37'],

            ['KUB', '39'],
            ['SOS', '41'],
            ['ING', '38'],
        ]
    arr.forEach((v, i, a) => { 
            const [key, val] = v;
            map1.set(key, val); })
            
    return map1;
}

export default function CityPage() {
    const [opac, setOpac] = useState(regionsOpacities(''))
    const [ids, setIds] = useState(regionsId())

    function update(str)
    {
        setOpac(regionsOpacities(str))
    }

    useEffect(() => {
        document.title = 'Города';
    }, []);


    return (
        <div>

            <HeaderComponent page='city'/>

            <section class='container section_header d_f ai_c jc_sb'>
                <p class="text_info">
                    <span>В данном разделе</span> - представлена
                    интерактивная карта с данными
                    по регионам России. Наша задача -
                    наиболее структурированно и точно
                    предоставить вам информацию
                    об интересующем вас субъекте нашей
                    необъятной страны
                </p>
                <div class="info_name">
                    <h1>МПРР</h1>
                    <p>Интерактивная карта России</p>
                </div>
            </section>



            <section>
                <div class="container">
                    <h2 class="name_overall">Регионы</h2>
                    <form class="form_search" action="" method="get">
                        <input class="search_region" placeholder="Поиск региона..." type="search" onChange={(event) => update(event.target.value)}/>
                    </form>
                    <RegionsMapComponent names={regNamesMap} opac={opac} ids={ids}/>
                </div>
            </section>
        </div>
    );
}
