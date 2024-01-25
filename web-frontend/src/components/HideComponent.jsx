import { React } from "react";
import { useNavigate } from "react-router-dom";


export default function HideComponent(props) {

    const navigate = useNavigate();

    if (props.hidden)
        return <div/>
    else
        return props.component
    // if (props.hidden) {
    //     return (
    //         <div>props.component</div>
    //     );
    // }
    // else {
    //     return (
    //         <div></div>
    //     );
    // }
}
  