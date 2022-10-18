import {AxiosResponse} from "axios";
import {MeasureUnit} from "../types/services/MeasureUnit";
import AXIOS from "../types/services/config";

const basePath = "/unit"

export function getMeasureUnits(): Promise<AxiosResponse<MeasureUnit[]>> {
    return AXIOS.get(basePath)
}

export function save(measureUnit: MeasureUnit): Promise<AxiosResponse<MeasureUnit>>{
    return AXIOS.post(basePath, measureUnit)
}