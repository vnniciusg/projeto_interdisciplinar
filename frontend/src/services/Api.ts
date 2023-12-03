import axios from "axios"
import { CadastroAtividade, Login , CadastraAtividadePessoa} from "models/DTOs";
import { CadastroProjeto } from "models/DTOs";


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
    })  ;
}

export const CreateNewProject = async (token: string, data: CadastroProjeto) => {
    return axios.post("https://projetointerdisciplinar-production.up.railway.app/api/v1/projetos", data, {
        headers: {
            Authorization: `Bearer ${token}`
        }
    });
}

export const GetAllActivities = async (token: string) => {
    return axios.get("https://projetointerdisciplinar-production.up.railway.app/api/v1/atividades", {
        headers: {
            Authorization: `Bearer ${token}`
        }
    });
}

export const PerformLogin = async (data: Login) => {
    return axios.post("https://projetointerdisciplinar-production.up.railway.app/api/v1/pessoas/login", data);
}

export const GetUserPayloadByToken = async (token: string) => {
    return axios.get("https://projetointerdisciplinar-production.up.railway.app/api/v1/pessoas/me/pessoa", {
        headers: {
            Authorization: `Bearer ${token}`
        }
    });
}

export const PerformActivityToPerson = async (data: CadastraAtividadePessoa, token: string) => {
    return axios.post("https://projetointerdisciplinar-production.up.railway.app/api/v1/pessoaAtividades", data, {
        headers: {
            Authorization: `Bearer ${token}`
        }
    })
}

export const GetSelfRegisteredActivities = async (token: string) => {
    return axios.get("https://projetointerdisciplinar-production.up.railway.app/api/v1/atividades/me/atividades", {
        headers: {
            Authorization: `Bearer ${token}`
        }
    })
}

export const GetDoingActivities = async (token: string) => {
    return axios.get("https://projetointerdisciplinar-production.up.railway.app/api/v1/pessoaAtividades", {
        headers:{ 
            Authorization: `Bearer ${token}`
        }
    })
}

export const GetEveryone = async (token: string) => {
    return axios.get("https://projetointerdisciplinar-production.up.railway.app/api/v1/pessoas", {
        headers: {
            Authorization: `Bearer ${token}`
        }
    })
}