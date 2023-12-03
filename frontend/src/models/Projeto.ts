import { Pessoa } from "./Pessoa";

export type Projeto = {
    prId: number;
    prNome: string;
    prRecursos: string;
    prObjetivo: string;
    prPessoaCoordena?: Pessoa;
    prPessoaCadastra?: Pessoa;
}