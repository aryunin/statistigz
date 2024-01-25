import { React } from "react";
import "./App.css"
import axios from "axios";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import RegionPage from "./pages/RegionPage";
import RegionsPage from "./pages/RegionsPage";
import CriterionPage from "./pages/CriterionPage";



function App() {

  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<RegionsPage/>}/>
        <Route path="/region/:id" element={<RegionPage/>}/>
        <Route path="/criterion" element={<CriterionPage/>}/>
      </Routes>
    </Router>
  );
}

export default App;