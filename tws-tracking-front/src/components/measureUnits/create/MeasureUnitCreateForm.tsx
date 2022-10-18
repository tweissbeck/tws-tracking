import {Button, TextField} from "@mui/material";
import Grid from '@mui/material/Unstable_Grid2'; // Grid version 2
import SaveAltIcon from '@mui/icons-material/SaveAlt';
import {MeasureUnit} from "../../../types/services/MeasureUnit";
import {ChangeEvent, useState} from "react";

interface MeasureUnitFormProps {
    mode: 'create' | 'update'
    data?: MeasureUnit

    /**
     * Handler for form validation
     * @param measureUnit
     */
    onClick(measureUnit: MeasureUnit): void
}

function MeasureUnitCreateForm(props: MeasureUnitFormProps) {
    const {mode, onClick, data} = props
    const [name, setName] = useState<string>(data === undefined ? "" : data.name)
    const [symbol, setSymbol] = useState<string>(data === undefined ? "" : data.symbol)
    const button = mode === 'create' ?
        <Button onClick={() => onClick({name: name, symbol: symbol})} variant="outlined" endIcon={<SaveAltIcon/>}>
            Save
        </Button> :
        <Button onClick={() => onClick({name: name, symbol: symbol})} variant="outlined" endIcon={<SaveAltIcon/>}>
            Update
        </Button>

    const handleNameChange = (event: ChangeEvent<HTMLInputElement>) => {
        setName(event.target.value)
    };

    const handleSymbolChange = (event: ChangeEvent<HTMLInputElement>) => {
        setSymbol(event.target.value)
    }


    return (
        <form>
            <Grid container spacing={2}>
                <Grid xs={12}>
                    <p>Add new measure unit</p>
                </Grid>
                <Grid xs={12}>
                    <TextField value={name} onChange={handleNameChange} fullWidth id="measure_unit_name" label="Name" maxRows={50}
                               variant="outlined"/>
                </Grid>
                <Grid xs={12}>
                    <TextField value={symbol} onChange={handleSymbolChange} fullWidth id="measure_unit_symbol" label="Symbol" maxRows={6}
                               variant="outlined"/>
                </Grid>
                <Grid xs={12}>
                    <Grid
                        xs={12}
                        container
                        justifyContent="flex-end"
                        alignItems="center"
                        flexDirection={{xs: 'row'}}>
                        <Grid>
                            {button}
                        </Grid>
                    </Grid>
                </Grid>
            </Grid>
        </form>
    )
}

export default MeasureUnitCreateForm