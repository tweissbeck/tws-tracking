import axios from "axios";

const basePath= "/api/"

const AXIOS = axios.create({
    baseURL: basePath,
});

export default AXIOS


