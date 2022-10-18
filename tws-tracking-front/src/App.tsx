import React from 'react';
import {Route, Routes} from "react-router-dom";
import './App.css';
import TAppBar, {Page} from "./components/nav/appBar";
import CounterPage from "./components/counter/CounterPage";
import Measure from "./components/measure/Measure";
import MeasureUnitsPage from "./components/measureUnits/MeasureUnitsPage";
import MeasureUnitCreatePage from "./components/measureUnits/create/MeasureUnitCreatePage";
import {MEASURE, UNIT_CREATE, UNITS} from "./natigate/Routes";

const pages: Page[] = [
    {label: "Measure", key: "measure", navTo:"/"},
    {label: "Unit measure", key: "unitMeasure", navTo:"/units"}
]

function App() {
    return (
        <div>
            <TAppBar pages={pages}></TAppBar>
            <Routes>
                <Route path="/" element={<CounterPage/>}/>
                <Route path={MEASURE} element={<Measure/>}/>
                <Route path={UNITS} element={<MeasureUnitsPage/>}/>
                <Route path={UNIT_CREATE} element={<MeasureUnitCreatePage/>}/>
            </Routes>
        </div>
    );
}

export default App;
