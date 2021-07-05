import axios from "axios";
import { GET_ERRORS } from "./types";

export const createProject = ( project, history) => async dispatch => {
        
        const res = await axios.post("http://localhost:8080/api/project/",project)
        .then(response => dispatch({
            type: "",
            payload: response,
        })).then(()=>{
            history.push("/dashboard")
            }
        )
        .catch(errors => dispatch({
            type: GET_ERRORS,
            payload: errors.response.data
        }));
        
    
};