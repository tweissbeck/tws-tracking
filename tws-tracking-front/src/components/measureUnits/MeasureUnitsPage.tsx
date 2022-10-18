import React, {useEffect, useState} from 'react'
import MeasureUnitsTable from "./MeasureUnitsTable";
import {MeasureUnit} from "../../types/services/MeasureUnit";
import {getMeasureUnits} from "../../services/MeasureUnitService";
import {CircularProgress, IconButton} from "@mui/material";
import AddCircleOutlineOutlinedIcon from '@mui/icons-material/AddCircleOutlineOutlined';
import {useNavigate} from "react-router-dom";
import {UNIT_CREATE} from "../../natigate/Routes";
import Grid from "@mui/material/Unstable_Grid2";


/**
 * Measure unit components
 * @constructor
 */
function MeasureUnitsPage() {
    const [status, setStatus] = useState<"loading" | "ok" | "error">("loading")
    const [measureUnits, setMesureUnits] = useState<MeasureUnit[]>([])
    const navigate = useNavigate();

    const addHandler = function () {
        navigate(UNIT_CREATE)
    }

    useEffect(() => {
        getMeasureUnits().then(response => {
            setMesureUnits(response.data)
            setStatus("ok")
        }, reason => {
            setStatus("error")
        })
    }, [])


    return (
        <Grid container justifyContent="center"
              alignItems="center" direction={"column"}>
            <Grid xs={4}>
                <Grid container alignItems="center" direction={"row"}>
                    <Grid xs={10}>
                        <h2>Unit measure list</h2>
                    </Grid>
                    <Grid xs={2}>
                        <IconButton sx={{float:"right"}} aria-label="add" onClick={addHandler}
                                    title="Add new measure unit">
                            <AddCircleOutlineOutlinedIcon color={"secondary"}/>
                        </IconButton>
                    </Grid>
                </Grid>
                {status === "loading" && <CircularProgress/>}
                {status === "ok" && <MeasureUnitsTable data={measureUnits}></MeasureUnitsTable>}
            </Grid>
        </Grid>
    )
}

export default MeasureUnitsPage