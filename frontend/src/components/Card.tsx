import { CadastraAtividadePessoa, RecuperaAtividade } from "models/DTOs";
import { MdAssignmentAdd } from "react-icons/md";
import Button from "./Button";
import { LuLoader2 } from "react-icons/lu";
import React from "react";
import { Controller, useForm } from "react-hook-form";
import Input from "./Input";
import Erro from "./Erro";
import { PerformActivityToPerson } from "services/Api";
import LoginContext from "contexts/AuthContext";
interface CardProps {
  activity: RecuperaAtividade;
}
const Card = ({ activity }: CardProps) => {
  const { userToken } = React.useContext(LoginContext);
  const { handleSubmit, control } = useForm<CadastraAtividadePessoa>({
    defaultValues: {
      ptaIdAtividade: 0,
      ptpDataFim: "",
      ptpDataInicio: "",
    },
  });
  const [isLoading, setIsLoading] = React.useState<boolean>(false);
  const [openedModal, setOpenedModal] = React.useState<number | null>(null);
  const candidateToActivity = (data: CadastraAtividadePessoa) => {
    const newData = { ...data, ptaIdAtividade: activity.aId };
    setIsLoading(true);
    if (userToken) {
      Promise.resolve(
        PerformActivityToPerson(newData, userToken)
          .then(() => {
            setIsLoading(false);
            handleCloseModal();
          })
          .catch((err) => {
            console.log(err), setIsLoading(false);
          })
      );
    }
  };

  const handleOpenModal = (id: number) => {
    setOpenedModal(id);
  };

  const handleCloseModal = () => {
    setOpenedModal(null);
  };
  return (
    <>
      <div className="flex flex-col gap-4 w-full h-auto min-h-[140px] shadow-md rounded-lg p-4 justify-between">
        <h1 className="text-lg font-black  text-title">Atividade</h1>
        <div className="flex flex-col gap-4 text-sm">
          <p className="flex flex-col gap-y-1">
            <span className="text-xs uppercase font-semibold">
              Nome do projeto pertencente
            </span>
            <span className="p-2 border rounded-lg capitalize">
              {" "}
              {activity.prNome}{" "}
            </span>
          </p>
          <p className="flex flex-col gap-y-1">
            <span className="text-xs uppercase font-semibold">Descrição</span>
            <span className="p-2 border rounded-lg capitalize">
              {" "}
              {activity.aDescricao}{" "}
            </span>
          </p>
          <p className="flex flex-col gap-y-1">
            <span className="text-xs uppercase font-semibold">
              Tipo de atividade
            </span>
            <span className="p-2 border rounded-lg capitalize">
              {" "}
              {activity.aTipo}{" "}
            </span>
          </p>
          <div className="flex flex-col gap-1">
            <p className="text-xs italic">Cadastro por: {activity.pNome}</p>
            <Button
              type="button"
              disabled={isLoading}
              onClick={() => handleOpenModal(activity.aId)}
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
      {openedModal === activity.aId && (
        <form
          onSubmit={handleSubmit(candidateToActivity)}
          className="fixed inset-0 z-50 overflow-auto flex flex-col justify-between pb-2 w-full h-full bg-black/30"
        >
          <div className="w-5/6  md:w-[400px] bg-white rounded-lg shadow-xl absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 p-10 flex flex-col gap-y-4">
            <h1 className="text-title font-black text-xl">
              Confirme que você quer fazer esta atividade e informe os campos
              abaixo:{" "}
            </h1>
            <Controller
              control={control}
              name="ptaIdAtividade"
              render={() => (
                <Input
                  id="ptaIdAtividade"
                  type="text"
                  disabled
                  value={activity.aId}
                />
              )}
            />
            <Controller
              control={control}
              name="ptpDataInicio"
              render={({
                field: { value, name, onChange },
                formState: { errors },
              }) => (
                <div className="flex flex-col gap-y-1">
                  <Input
                    type="date"
                    label="Data de início da atividade"
                    onChange={onChange}
                    value={value}
                    id={name}
                    placeholder="Informe a data de início da atividade..."
                  />
                  {errors.ptpDataInicio &&
                    (errors.ptpDataInicio.type == "required" ? (
                      <Erro message="Preencha seu email" />
                    ) : (
                      ""
                    ))}
                </div>
              )}
            />
            <Controller
              control={control}
              name="ptpDataFim"
              render={({
                field: { value, name, onChange },
                formState: { errors },
              }) => (
                <div className="flex flex-col gap-y-1">
                  <Input
                    type="date"
                    label="Data prevista de término da atividade"
                    onChange={onChange}
                    value={value}
                    id={name}
                    placeholder="Informe a data de término da atividade..."
                  />
                  {errors.ptpDataFim &&
                    (errors.ptpDataFim.type == "required" ? (
                      <Erro message="Preencha seu email" />
                    ) : (
                      ""
                    ))}
                </div>
              )}
            />
            <div className="flex flex-row gap-x-1 ">
              <Button
                type="submit"
                message={
                  isLoading ? (
                    <p className="flex flex-row items-center justify-center gap-x-2">
                      {" "}
                      Enviando...
                      <LuLoader2 className="animate-spin" />
                    </p>
                  ) : (
                    "Confirmar"
                  )
                }
                disabled={isLoading}
              />
              <Button
                onClick={() => handleCloseModal()}
                type="button"
                message="Cancelar"
              />
            </div>
          </div>
        </form>
      )}
    </>
  );
};

export default Card;
