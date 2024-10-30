import { React } from "react";
import { useNavigate } from "react-router-dom";


export default function RegionsMapComponent(props) {

    const navigate = useNavigate();

    return (
        <div class="map_inter">
                    <div class="map_icon icon_SPB" style={{opacity: props.opac.get('SPB')}} onClick={() => navigate(`/region/${props.ids.get('SPB')}`)}>
                        <p class="icon_text">СПБ</p>
                    </div>
                    <div class="map_icon icon_SVS" style={{opacity: props.opac.get('SVS')}} onClick={() => navigate(`/region/${props.ids.get('SVS')}`)}>
                        <p class="icon_text">СВС</p>
                    </div>
                    <div class="map_icon icon_MSK" style={{opacity: props.opac.get('MSK')}} onClick={() => navigate(`/region/${props.ids.get('MSK')}`)}>
                        <p class="icon_text">МСК</p>
                    </div>
                    <div class="map_icon icon_MYR" style={{opacity: props.opac.get('MYR')}} onClick={() => navigate(`/region/${props.ids.get('MYR')}`)}>
                        <p class="icon_text">МУР</p>
                    </div>


                    <div class="map_icon icon_KAR" style={{opacity: props.opac.get('KAR')}} onClick={() => navigate(`/region/${props.ids.get('KAR')}`)}>
                        <p class="icon_text">КАР</p>
                    </div>
                    {/* <div class="map_icon icon_NEN" style={{opacity: props.opac.get('NEN')}} onClick={() => navigate(`/region/${props.ids.get('NEN')}`)}>
                        <p class="icon_text">НЕН</p>
                    </div> */}
                    <div class="map_icon icon_CHYK" style={{opacity: props.opac.get('CHYK')}} onClick={() => navigate(`/region/${props.ids.get('CHYK')}`)}>
                        <p class="icon_text">ЧУК</p>
                    </div>
                    <div class="map_icon icon_KAM" style={{opacity: props.opac.get('KAM')}} onClick={() => navigate(`/region/${props.ids.get('KAM')}`)}>
                        <p class="icon_text">КАМ</p>
                    </div>


                    <div class="map_icon icon_LEN" style={{opacity: props.opac.get('LEN')}} onClick={() => navigate(`/region/${props.ids.get('LEN')}`)}>
                        <p class="icon_text">ЛЕН</p>
                    </div>
                    <div class="map_icon icon_NOV" style={{opacity: props.opac.get('NOV')}} onClick={() => navigate(`/region/${props.ids.get('NOV')}`)}>
                        <p class="icon_text">НОВГ</p>
                    </div>
                    <div class="map_icon icon_VOL" style={{opacity: props.opac.get('VOL')}} onClick={() => navigate(`/region/${props.ids.get('VOL')}`)}>
                        <p class="icon_text">ВОЛ</p>
                    </div>
                    <div class="map_icon icon_ARH" style={{opacity: props.opac.get('ARH')}} onClick={() => navigate(`/region/${props.ids.get('ARH')}`)}>
                        <p class="icon_text">АРХ</p>
                    </div>
                    <div class="map_icon icon_KOMI" style={{opacity: props.opac.get('KOMI')}} onClick={() => navigate(`/region/${props.ids.get('KOMI')}`)}>
                        <p class="icon_text">КОМИ</p>
                    </div>
                    {/* <div class="map_icon icon_YMAL" style={{opacity: props.opac.get('YMAL')}} onClick={() => navigate(`/region/${props.ids.get('YMAL')}`)}>
                        <p class="icon_text">ЯМАЛ</p>
                    </div> */}
                    <div class="map_icon icon_KRAS" style={{opacity: props.opac.get('KRAS')}} onClick={() => navigate(`/region/${props.ids.get('KRAS')}`)}>
                        <p class="icon_text">КРАС</p>
                    </div>
                    <div class="map_icon icon_SAHA" style={{opacity: props.opac.get('SAHA')}} onClick={() => navigate(`/region/${props.ids.get('SAHA')}`)}>
                        <p class="icon_text">САХА</p>
                    </div>
                    <div class="map_icon icon_MAG" style={{opacity: props.opac.get('MAG')}} onClick={() => navigate(`/region/${props.ids.get('MAG')}`)}>
                        <p class="icon_text">МАГ</p>
                    </div>


                    <div class="map_icon icon_KNG" style={{opacity: props.opac.get('KNG')}} onClick={() => navigate(`/region/${props.ids.get('KNG')}`)}>
                        <p class="icon_text">КНГ</p>
                    </div>
                    <div class="map_icon icon_PSK" style={{opacity: props.opac.get('PSK')}} onClick={() => navigate(`/region/${props.ids.get('PSK')}`)}>
                        <p class="icon_text">ПСК</p>
                    </div>
                    <div class="map_icon icon_TVER" style={{opacity: props.opac.get('TVER')}} onClick={() => navigate(`/region/${props.ids.get('TVER')}`)}>
                        <p class="icon_text">ТВЕР</p>
                    </div>
                    <div class="map_icon icon_YRO" style={{opacity: props.opac.get('YRO')}} onClick={() => navigate(`/region/${props.ids.get('YRO')}`)}>
                        <p class="icon_text">ЯРО</p>
                    </div>
                    <div class="map_icon icon_IVA" style={{opacity: props.opac.get('IVA')}} onClick={() => navigate(`/region/${props.ids.get('IVA')}`)}>
                        <p class="icon_text">ИВА</p>
                    </div>
                    <div class="map_icon icon_KOS" style={{opacity: props.opac.get('KOS')}} onClick={() => navigate(`/region/${props.ids.get('KOS')}`)}>
                        <p class="icon_text">КОС</p>
                    </div>
                    <div class="map_icon icon_MARI" style={{opacity: props.opac.get('MARI')}} onClick={() => navigate(`/region/${props.ids.get('MARI')}`)}>
                        <p class="icon_text">МАРИ</p>
                    </div>
                    <div class="map_icon icon_KIR" style={{opacity: props.opac.get('KIR')}} onClick={() => navigate(`/region/${props.ids.get('KIR')}`)}>
                        <p class="icon_text">КИР</p>
                    </div>
                    <div class="map_icon icon_PER" style={{opacity: props.opac.get('PER')}} onClick={() => navigate(`/region/${props.ids.get('PER')}`)}>
                        <p class="icon_text">ПЕР</p>
                    </div>
                    {/* <div class="map_icon icon_HAN" style={{opacity: props.opac.get('HAN')}} onClick={() => navigate(`/region/${props.ids.get('HAN')}`)}>
                        <p class="icon_text">ХАН</p>
                    </div> */}
                    <div class="map_icon icon_TUM" style={{opacity: props.opac.get('TUM')}} onClick={() => navigate(`/region/${props.ids.get('TUM')}`)}>
                        <p class="icon_text">ТЮМ</p>
                    </div>
                    <div class="map_icon icon_TOM" style={{opacity: props.opac.get('TOM')}} onClick={() => navigate(`/region/${props.ids.get('TOM')}`)}>
                        <p class="icon_text">ТОМ</p>
                    </div>
                    <div class="map_icon icon_KEM" style={{opacity: props.opac.get('KEM')}} onClick={() => navigate(`/region/${props.ids.get('KEM')}`)}>
                        <p class="icon_text">КЕМ</p>
                    </div>
                    <div class="map_icon icon_IRK" style={{opacity: props.opac.get('IRK')}} onClick={() => navigate(`/region/${props.ids.get('IRK')}`)}>
                        <p class="icon_text">ИРК</p>
                    </div>
                    <div class="map_icon icon_AMUR" style={{opacity: props.opac.get('AMUR')}} onClick={() => navigate(`/region/${props.ids.get('AMUR')}`)}>
                        <p class="icon_text">АМУР</p>
                    </div>
                    <div class="map_icon icon_HAB" style={{opacity: props.opac.get('HAB')}} onClick={() => navigate(`/region/${props.ids.get('HAB')}`)}>
                        <p class="icon_text">ХАБ</p>
                    </div>
                    <div class="map_icon icon_SHLN" style={{opacity: props.opac.get('SHLN')}} onClick={() => navigate(`/region/${props.ids.get('SHLN')}`)}>
                        <p class="icon_text">СХЛН</p>
                    </div>



                    <div class="map_icon icon_SMOL" style={{opacity: props.opac.get('SMOL')}} onClick={() => navigate(`/region/${props.ids.get('SMOL')}`)}>
                        <p class="icon_text">СМОЛ</p>
                    </div>
                    <div class="map_icon icon_KALU" style={{opacity: props.opac.get('KALU')}} onClick={() => navigate(`/region/${props.ids.get('KALU')}`)}>
                        <p class="icon_text">КАЛУ</p>
                    </div>
                    <div class="map_icon icon_MOS" style={{opacity: props.opac.get('MOS')}} onClick={() => navigate(`/region/${props.ids.get('MOS')}`)}>
                        <p class="icon_text">МОС</p>
                    </div>
                    <div class="map_icon icon_VLA" style={{opacity: props.opac.get('VLA')}} onClick={() => navigate(`/region/${props.ids.get('VLA')}`)}>
                        <p class="icon_text">ВЛА</p>
                    </div>
                    <div class="map_icon icon_NN" style={{opacity: props.opac.get('NN')}} onClick={() => navigate(`/region/${props.ids.get('NN')}`)}>
                        <p class="icon_text">НИЖ</p>
                    </div>
                    <div class="map_icon icon_CHYV" style={{opacity: props.opac.get('CHYV')}} onClick={() => navigate(`/region/${props.ids.get('CHYV')}`)}>
                        <p class="icon_text">ЧУВ</p>
                    </div>
                    <div class="map_icon icon_TAT" style={{opacity: props.opac.get('TAT')}} onClick={() => navigate(`/region/${props.ids.get('TAT')}`)}>
                        <p class="icon_text">ТАТ</p>
                    </div>
                    <div class="map_icon icon_UDM" style={{opacity: props.opac.get('UDM')}} onClick={() => navigate(`/region/${props.ids.get('UDM')}`)}>
                        <p class="icon_text">УДМ</p>
                    </div>
                    <div class="map_icon icon_SVER" style={{opacity: props.opac.get('SVER')}} onClick={() => navigate(`/region/${props.ids.get('SVER')}`)}>
                        <p class="icon_text">СВЕР</p>
                    </div>
                    <div class="map_icon icon_KURG" style={{opacity: props.opac.get('KURG')}} onClick={() => navigate(`/region/${props.ids.get('KURG')}`)}>
                        <p class="icon_text">КУРГ</p>
                    </div>
                    <div class="map_icon icon_NOVO" style={{opacity: props.opac.get('NOVO')}} onClick={() => navigate(`/region/${props.ids.get('NOVO')}`)}>
                        <p class="icon_text">НОВО</p>
                    </div>
                    <div class="map_icon icon_HAK" style={{opacity: props.opac.get('HAK')}} onClick={() => navigate(`/region/${props.ids.get('HAK')}`)}>
                        <p class="icon_text">ХАК</p>
                    </div>
                    <div class="map_icon icon_BUR" style={{opacity: props.opac.get('BUR')}} onClick={() => navigate(`/region/${props.ids.get('BUR')}`)}>
                        <p class="icon_text">БУР</p>
                    </div>
                    <div class="map_icon icon_EVR" style={{opacity: props.opac.get('EVR')}} onClick={() => navigate(`/region/${props.ids.get('EVR')}`)}>
                        <p class="icon_text">ЕВР</p>
                    </div>


                    <div class="map_icon icon_BRY" style={{opacity: props.opac.get('BRY')}} onClick={() => navigate(`/region/${props.ids.get('BRY')}`)}>
                        <p class="icon_text">БРЯ</p>
                    </div>
                    <div class="map_icon icon_ORL" style={{opacity: props.opac.get('ORL')}} onClick={() => navigate(`/region/${props.ids.get('ORL')}`)}>
                        <p class="icon_text">ОРЛ</p>
                    </div>
                    <div class="map_icon icon_TUL" style={{opacity: props.opac.get('TUL')}} onClick={() => navigate(`/region/${props.ids.get('TUL')}`)}>
                        <p class="icon_text">ТУЛ</p>
                    </div>
                    <div class="map_icon icon_RYZ" style={{opacity: props.opac.get('RYZ')}} onClick={() => navigate(`/region/${props.ids.get('RYZ')}`)}>
                        <p class="icon_text">РЯЗ</p>
                    </div>
                    <div class="map_icon icon_MOR" style={{opacity: props.opac.get('MOR')}} onClick={() => navigate(`/region/${props.ids.get('MOR')}`)}>
                        <p class="icon_text">МОР</p>
                    </div>
                    <div class="map_icon icon_UL" style={{opacity: props.opac.get('UL')}} onClick={() => navigate(`/region/${props.ids.get('UL')}`)}>
                        <p class="icon_text">УЛЬ</p>
                    </div>
                    <div class="map_icon icon_SAM" style={{opacity: props.opac.get('SAM')}} onClick={() => navigate(`/region/${props.ids.get('SAM')}`)}>
                        <p class="icon_text">САМ</p>
                    </div>
                    <div class="map_icon icon_BSHK" style={{opacity: props.opac.get('BSHK')}} onClick={() => navigate(`/region/${props.ids.get('BSHK')}`)}>
                        <p class="icon_text">БШК</p>
                    </div>
                    <div class="map_icon icon_CHEL" style={{opacity: props.opac.get('CHEL')}} onClick={() => navigate(`/region/${props.ids.get('CHEL')}`)}>
                        <p class="icon_text">ЧЕЛ</p>
                    </div>
                    <div class="map_icon icon_OMSK" style={{opacity: props.opac.get('OMSK')}} onClick={() => navigate(`/region/${props.ids.get('OMSK')}`)}>
                        <p class="icon_text">ОМСК</p>
                    </div>
                    <div class="map_icon icon_TUVA" style={{opacity: props.opac.get('TUVA')}} onClick={() => navigate(`/region/${props.ids.get('TUVA')}`)}>
                        <p class="icon_text">ТУВА</p>
                    </div>
                    <div class="map_icon icon_ALTK" style={{opacity: props.opac.get('ALTK')}} onClick={() => navigate(`/region/${props.ids.get('ALTK')}`)}>
                        <p class="icon_text">АЛ.К</p>
                    </div>
                    <div class="map_icon icon_ZAB" style={{opacity: props.opac.get('ZAB')}} onClick={() => navigate(`/region/${props.ids.get('ZAB')}`)}>
                        <p class="icon_text">ЗАБ</p>
                    </div>
                    <div class="map_icon icon_PRI" style={{opacity: props.opac.get('PRI')}} onClick={() => navigate(`/region/${props.ids.get('PRI')}`)}>
                        <p class="icon_text">ПРИ</p>
                    </div>

                    
                    {/* <div class="map_icon icon_LNR" style={{opacity: props.opac.get('LNR')}} onClick={() => navigate(`/region/${props.ids.get('LNR')}`)}>
                        <p class="icon_text">ЛНР</p>
                    </div> */}
                    <div class="map_icon icon_KUR" style={{opacity: props.opac.get('KUR')}} onClick={() => navigate(`/region/${props.ids.get('KUR')}`)}>
                        <p class="icon_text">КУР</p>
                    </div>
                    <div class="map_icon icon_LIP" style={{opacity: props.opac.get('LIP')}} onClick={() => navigate(`/region/${props.ids.get('LIP')}`)}>
                        <p class="icon_text">ЛИП</p>
                    </div>
                    <div class="map_icon icon_TAM" style={{opacity: props.opac.get('TAM')}} onClick={() => navigate(`/region/${props.ids.get('TAM')}`)}>
                        <p class="icon_text">ТАМ</p>
                    </div>
                    <div class="map_icon icon_PEN" style={{opacity: props.opac.get('PEN')}} onClick={() => navigate(`/region/${props.ids.get('PEN')}`)}>
                        <p class="icon_text">ПЕН</p>
                    </div>
                    <div class="map_icon icon_SAR" style={{opacity: props.opac.get('SAR')}} onClick={() => navigate(`/region/${props.ids.get('SAR')}`)}>
                        <p class="icon_text">САР</p>
                    </div>
                    <div class="map_icon icon_ORNB" style={{opacity: props.opac.get('ORNB')}} onClick={() => navigate(`/region/${props.ids.get('ORNB')}`)}>
                        <p class="icon_text">ОРНБ</p>
                    </div>
                    <div class="map_icon icon_ALT" style={{opacity: props.opac.get('ALT')}} onClick={() => navigate(`/region/${props.ids.get('ALT')}`)}>
                        <p class="icon_text">АЛТ</p>
                    </div>


                    {/* <div class="map_icon icon_HRS" style={{opacity: props.opac.get('HRS')}} onClick={() => navigate(`/region/${props.ids.get('HRS')}`)}>
                        <p class="icon_text">ХРС</p>
                    </div>
                    <div class="map_icon icon_ZUP" style={{opacity: props.opac.get('ZUP')}} onClick={() => navigate(`/region/${props.ids.get('ZUP')}`)}>
                        <p class="icon_text">ЗАП</p>
                    </div>
                    <div class="map_icon icon_DNR" style={{opacity: props.opac.get('DNR')}} onClick={() => navigate(`/region/${props.ids.get('DNR')}`)}>
                        <p class="icon_text">ДНР</p>
                    </div> */}
                    <div class="map_icon icon_BEL" style={{opacity: props.opac.get('BEL')}} onClick={() => navigate(`/region/${props.ids.get('BEL')}`)}>
                        <p class="icon_text">БЕЛ</p>
                    </div>
                    <div class="map_icon icon_VOR" style={{opacity: props.opac.get('VOR')}} onClick={() => navigate(`/region/${props.ids.get('VOR')}`)}>
                        <p class="icon_text">ВОР</p>
                    </div>
                    <div class="map_icon icon_VOLG" style={{opacity: props.opac.get('VOLG')}} onClick={() => navigate(`/region/${props.ids.get('VOLG')}`)}>
                        <p class="icon_text">ВОЛГ</p>
                    </div>


                    <div class="map_icon icon_KRUM" style={{opacity: props.opac.get('KRUM')}} onClick={() => navigate(`/region/${props.ids.get('KRUM')}`)}>
                        <p class="icon_text">КРЫМ</p>
                    </div>
                    <div class="map_icon icon_ADUG" style={{opacity: props.opac.get('ADUG')}} onClick={() => navigate(`/region/${props.ids.get('ADUG')}`)}>
                        <p class="icon_text">АДЫГ</p>
                    </div>
                    <div class="map_icon icon_KRDR" style={{opacity: props.opac.get('KRDR')}} onClick={() => navigate(`/region/${props.ids.get('KRDR')}`)}>
                        <p class="icon_text">КРДР</p>
                    </div>
                    <div class="map_icon icon_ROS" style={{opacity: props.opac.get('ROS')}} onClick={() => navigate(`/region/${props.ids.get('ROS')}`)}>
                        <p class="icon_text">РОС</p>
                    </div>
                    <div class="map_icon icon_KULM" style={{opacity: props.opac.get('KULM')}} onClick={() => navigate(`/region/${props.ids.get('KULM')}`)}>
                        <p class="icon_text">КАЛМ</p>
                    </div>
                    <div class="map_icon icon_AST" style={{opacity: props.opac.get('AST')}} onClick={() => navigate(`/region/${props.ids.get('AST')}`)}>
                        <p class="icon_text">АСТ</p>
                    </div>



                    <div class="map_icon icon_KCHR" style={{opacity: props.opac.get('KCHR')}} onClick={() => navigate(`/region/${props.ids.get('KCHR')}`)}>
                        <p class="icon_text">КЧР</p>
                    </div>
                    <div class="map_icon icon_STUV" style={{opacity: props.opac.get('STUV')}} onClick={() => navigate(`/region/${props.ids.get('STUV')}`)}>
                        <p class="icon_text">СТАВ</p>
                    </div>
                    <div class="map_icon icon_CHECH" style={{opacity: props.opac.get('CHECH')}} onClick={() => navigate(`/region/${props.ids.get('CHECH')}`)}>
                        <p class="icon_text">ЧЕЧ</p>
                    </div>
                    <div class="map_icon icon_DUG" style={{opacity: props.opac.get('DUG')}} onClick={() => navigate(`/region/${props.ids.get('DUG')}`)}>
                        <p class="icon_text">ДАГ</p>
                    </div>


                    <div class="map_icon icon_KUB" style={{opacity: props.opac.get('KUB')}} onClick={() => navigate(`/region/${props.ids.get('KUB')}`)}>
                        <p class="icon_text">КАБ</p>
                    </div>
                    <div class="map_icon icon_SOS" style={{opacity: props.opac.get('SOS')}} onClick={() => navigate(`/region/${props.ids.get('SOS')}`)}>
                        <p class="icon_text">С.ОС</p>
                    </div>
                    <div class="map_icon icon_ING" style={{opacity: props.opac.get('ING')}} onClick={() => navigate(`/region/${props.ids.get('ING')}`)}>
                        <p class="icon_text">ИНГ</p>
                    </div>
        </div>
    );
}
  