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
    prIdPessoaCoordena: number,
}

export type CadastraAtividadePessoa = {
    ptaIdAtividade: number,
    ptaIdPessoa: number,
    ptpDataInicio: string,
    ptpDataFim: string,
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

export type RecuperaAtividade = {
    aId: number;
    prId: number;
    prNome: string
    aDescricao: string
    aTipo: TipoAtividade
    pNome: string
}

export type PayloadUsuario = {
    pid: number;
    pnome: string;
    ptipo: TipoPessoa
}

export type PayloadToken = {
    token: string;
}