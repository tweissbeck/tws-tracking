import React from 'react'
import {Counter} from "../../types/services/Counter";
import {Box, CircularProgress} from "@mui/material";

export interface CounterTableProps {
    data: Counter[]
    loading: boolean
    error?: string
}

function createTable(data: Counter[]){
    return <>

    </>

}

function CounterTable(props: CounterTableProps) {
    const {data, loading, error} = props;
    const table = createTable(data)
    return (<>
        {loading && <CircularProgress />}
        {!loading && table}
    </>)
}

export default CounterTable