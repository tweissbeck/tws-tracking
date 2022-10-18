import Grid from "@mui/material/Unstable_Grid2";
import MeasureUnitCreateForm from "./MeasureUnitCreateForm";
import {MeasureUnit} from "../../../types/services/MeasureUnit";
import {save} from "../../../services/MeasureUnitService";
import {useNavigate} from "react-router-dom";
import {UNITS} from "../../../natigate/Routes";

function MeasureUnitCreatePage() {

    const navigate = useNavigate();

    const handleCreate = function (measureUnit: MeasureUnit) {
        save(measureUnit).then(response => {
            navigate(UNITS)
        }, reason => {

        })
    }

    return (
        <Grid container justifyContent="center"
              alignItems="center" direction={"column"}>
            <Grid xs={2}>
                <MeasureUnitCreateForm mode={"create"} onClick={handleCreate}/>
            </Grid>
        </Grid>
    )
}

export default MeasureUnitCreatePage