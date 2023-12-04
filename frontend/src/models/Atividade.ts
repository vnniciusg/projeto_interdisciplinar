import { Pessoa } from "./Pessoa";
import { Projeto } from "./Projeto";

export type Atividade = {
    aId: number;
    aIdProjeto: Projeto;
    aDescricao: string;
    aTipo: TipoAtividade;
    aPessoaCadastra?: Pessoa;

}

export enum TipoAtividade {
    MANUTENCAO = "MANUTENCAO",
    IMPLEMENTACAO = "IMPLEMENTACAO",
    ALTERACAO = "ALTERACAO",
    MODELAGEM = "MODELAGEM",
    OUTRO = "OUTRO"
}