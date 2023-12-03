import { Atividade } from "./Atividade";
import { Pessoa } from "./Pessoa";
import { Projeto } from "./Projeto";

export type AdministradorCriaProjeto = {
    acprId: number;
    acprIdAdministrador?: Pessoa;
    acprIdProjeto?: Projeto;
}

export type AdministradorCriaAtividade = {    
    acaId: number;
    acaIdAdministrador?: Pessoa;
    acaIdAtividade?: Atividade[]
}   

export type AdministradorCriaPessoa = {
    acpId: number;
    acpIdAdministrador?: Pessoa;
    acpIdPessoa?: Pessoa;
}

export type CoordenadorCriaProjeto = {
    ccpId: number;
    ccpIdCoordenador?: Pessoa;
    ccpIdProjeto?: Projeto
}

export type CoordenadorCriaAtividade = {
    ccaId: number;
    ccaIdCoordenador?: Pessoa;
    ccaIdAtividade?: Atividade[]
}

export type PessoaTrabalhaAtividade = {
    ptaId: number;
    ptaPessoa?: Pessoa;
    ptaAtividade?: Atividade;
    ptpDataInicio: Date;
    ptpDataFim: Date;
}