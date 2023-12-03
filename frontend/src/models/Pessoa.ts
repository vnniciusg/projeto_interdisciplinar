export type Pessoa = {
    pID: number;
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
    pIdAdministradorCadastra?: Pessoa;
    pDataCriacao?: Date
}

export type Estagiario = {
    eIdPessoa: Pessoa
    eRa: number;
    ePeriodo: number;
    eCurso: string;
    eAcademico: boolean;
}

export enum TipoPessoa {
    ADMINISTRADOR = "ADMINISTRADOR",
    COORDENADOR = "COORDENADOR",
    ESTAGIÁRIO = "ESTAGIÁRIO"
}