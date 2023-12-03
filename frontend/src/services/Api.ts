import axios from "axios"
import { CadastroAtividade } from "models/DTOs";

export const GetAvailableProjects = async (token: string) => {
    return axios.get("https://projetointerdisciplinar-production.up.railway.app/api/v1/projetos", {
        headers: {
            "Authorization": `Bearer ${token}`,
        }
    });
}

export const CreateNewActivity = async (token: string, data: CadastroAtividade) => {
    return axios.post("https://projetointerdisciplinar-production.up.railway.app/api/v1/atividades", data, {
        headers: {
            Authorization: `Bearer ${token}`
        }
    })
}

export const GetAllActivities = async (token: string) => {
    return axios.get("https://projetointerdisciplinar-production.up.railway.app/api/v1/atividades", {
        headers: {
            Authorization: `Bearer ${token}`
        }
    })
}