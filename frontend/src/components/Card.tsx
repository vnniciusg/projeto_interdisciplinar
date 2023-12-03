import { RecuperaAtividade } from "models/DTOs";
import { MdAssignmentAdd } from "react-icons/md";
import Button from "./Button";
import { LuLoader2 } from "react-icons/lu";
import React from "react";
interface CardProps {
  activity: RecuperaAtividade;
}
const Card = ({ activity }: CardProps) => {
  const [isLoading, setIsLoading] = React.useState<boolean>(false);
  return (
    <div className="flex flex-col gap-4 w-full h-auto min-h-[140px] shadow-md rounded-lg p-4 justify-between">
      <h1 className="text-lg font-black  text-title">Atividade</h1>
      <div className="flex flex-col gap-4 text-sm">
        <p className="flex flex-col gap-y-1">
          <span className="text-xs uppercase font-semibold">
            Nome do projeto pertencente
          </span>
          <span className="p-2 border rounded-lg capitalize"> {activity.prNome} </span>
        </p>
        <p className="flex flex-col gap-y-1">
          <span className="text-xs uppercase font-semibold">Descrição</span>
          <span className="p-2 border rounded-lg capitalize"> {activity.aDescricao} </span>
        </p>
        <p className="flex flex-col gap-y-1">
          <span className="text-xs uppercase font-semibold">Tipo de atividade</span>
          <span className="p-2 border rounded-lg capitalize"> {activity.aTipo} </span>
        </p>
        <div className="flex flex-col gap-1">
          <p className="text-xs italic">Cadastro por: {activity.pNome}</p>
          <Button
            disabled={isLoading}
            message={
              !isLoading ? (
                <p className="flex flex-row items-center gap-x-2 justify-center">
                  Realizar <MdAssignmentAdd />
                </p>
              ) : (
                <p className="flex flex-row items-center justify-center gap-x-2">
                  {" "}
                  Enviando...
                  <LuLoader2 className="animate-spin" />
                </p>
              )
            }
          />
        </div>
      </div>
    </div>
  );
};

export default Card;
