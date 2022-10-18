import React from 'react'
import {MeasureUnit} from "../../types/services/MeasureUnit";
import {Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from "@mui/material";


interface MeasureUnitsTableProps {
    data: MeasureUnit[]
}

function MeasureUnitsTable(props: MeasureUnitsTableProps) {
    const {data} = props
    return (
        <TableContainer>
            <Table aria-label="Measure unit table">
                <TableHead>
                    <TableRow>
                        <TableCell>Name</TableCell>
                        <TableCell align="right">Symbol</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {data.map((row) => (
                        <TableRow key={row.id}>
                            <TableCell>{row.name}</TableCell>
                            <TableCell align="right">{row.symbol}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    )
}

export default MeasureUnitsTable