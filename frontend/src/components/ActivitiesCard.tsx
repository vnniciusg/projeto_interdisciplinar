import { PessoaTrabalhaAtividade } from 'models/RelacoesN'
import React from 'react'
interface ActivitiesCardProps {
    activity: PessoaTrabalhaAtividade
}
const ActivitiesCard = ({activity}: ActivitiesCardProps) => {
    console.log(activity);
  return (
    <>
        <div className="flex flex-col gap-4 w-full h-auto min-h-[140px] shadow-md rounded-lg p-4 justify-between">
        <h1 className="text-lg font-black  text-title">Atividade</h1>
        <div className="flex flex-col gap-4 text-sm">
          <p className="flex flex-col gap-y-1">
            <span className="text-xs uppercase font-semibold">
              Descricao da atividade
            </span>
            <span className="p-2 border rounded-lg capitalize">
              {" "}
              {activity?.ptaAtividade?.aDescricao}{" "}
            </span>
          </p>
          <p className="flex flex-col gap-y-1">
            <span className="text-xs uppercase font-semibold">Tipo da atividade</span>
            <span className="p-2 border rounded-lg capitalize">
              {" "}
              {activity.ptaAtividade?.aTipo}{" "}
            </span>
          </p>
          <p className="flex flex-col gap-y-1">
            <span className="text-xs uppercase font-semibold">
              Data início da atividade
            </span>
            <span className="p-2 border rounded-lg capitalize">
              {" "}
              {new Date(activity.ptpDataInicio).toLocaleDateString("pt-BR")}{" "}
            </span>
          </p>
          <span className="text-xs uppercase font-semibold">
              Data prevista para término da atividade
            </span>
            <span className="p-2 border rounded-lg capitalize">
              {" "}
              {new Date(activity.ptpDataFim).toLocaleDateString("pt-BR")}{" "}
            </span>
          <div className="flex flex-col gap-1">
            <p className="text-xs italic">Foi cadastrada por:</p>
            <div className='flex flex-row items-center gap-x-1'>
                <span className='capitalize'>{activity.ptaPessoa?.pNome} </span> - {activity.ptaPessoa?.pTipo}
            </div>
          </div>
        </div>
      </div>
    </>
  )
}

export default ActivitiesCard