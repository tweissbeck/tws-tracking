import React from 'react'
import Grid from "@mui/material/Unstable_Grid2";
import CounterTable from "./CounterTable";

function CounterPage() {
    return (
        <Grid container justifyContent="center"
              alignItems="center" direction={"column"}>
            <Grid xs={4}>
                <CounterTable data={[]} loading={true} error={undefined}/>
            </Grid>
        </Grid>
    )
}

export default CounterPage