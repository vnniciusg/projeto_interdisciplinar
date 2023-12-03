import { TipoAtividade } from "./Atividade";
import { TipoPessoa } from "./Pessoa";

export type Login = {
    pEmail: string;
    pSenha: string;
}

export type CadastroPessoa = {
    pRg: string;
    pCpf: string;
    pTipo: TipoPessoa;
    pEmail: string;
    pSenha: string;
    pNome: string;
    pNomeMae: string;
    pNomePai: string;
    pTelCelular: string;
    pTelResidencial?: string;
    pTelRecado?: string
}

export type CadastroProjeto = {
    prNome: string;
    prRecursos: string;
    prObjetivo: string;
}

export type CadastroAtividade = {
    aIdProjeto: string | number;
    aDescricao: string;
    aTipo: TipoAtividade;
}

export type RecuperaProjeto = {
    prId: number;
    prNome: string;
}