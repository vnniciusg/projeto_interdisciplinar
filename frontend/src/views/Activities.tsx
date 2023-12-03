import React from "react";
import { FaFolderPlus, FaFolderOpen } from "react-icons/fa";
import { MdContacts } from "react-icons/md";
import { FaBookOpen } from "react-icons/fa6";
import { LuLoader2 } from "react-icons/lu";
import { MdAssignment } from "react-icons/md";
import {
  Tab,
  Tabs,
  TabList,
  TabPanel,
  ReactTabsFunctionComponent,
  TabProps,
  TabPanelProps,
} from "react-tabs";
import "react-tabs/style/react-tabs.css";
import Title from "components/Title";
import { useForm, Controller } from "react-hook-form";
import {
  CadastroAtividade,
  RecuperaAtividade,
  RecuperaProjeto,
} from "models/DTOs";
import { TipoAtividade } from "models/Atividade";
import Button from "components/Button";
import Select from "components/Select";
import Erro from "components/Erro";
import {
  CreateNewActivity,
  GetAllActivities,
  GetAvailableProjects,
  GetDoingActivities,
  GetSelfRegisteredActivities,
} from "services/Api";
import Card from "components/Card";
import SearchInput from "components/SearchInput";
import LoginContext from "contexts/AuthContext";
import { PessoaTrabalhaAtividade } from "models/RelacoesN";
import ActivitiesCard from "components/ActivitiesCard";

const CustomTab: ReactTabsFunctionComponent<TabProps> = ({
  children,
  ...props
}) => (
  <Tab
    className="cursor-pointer hover:bg-secondary/10 rounded-lg"
    selectedClassName="border-0 text-secondary font-bold"
    {...props}
  >
    <span className="py-4 px-4 flex flex-row items-center gap-x-4">
      {children}
    </span>
  </Tab>
);

const CustomPanel: ReactTabsFunctionComponent<TabPanelProps> = ({
  children,
  ...props
}) => (
  <TabPanel
    className="hidden active:block w-full md:w-[70%] self-start py-10 px-4 bg-white shadow-xl rounded-lg min-h-[400px]"
    {...props}
  >
    {children}
  </TabPanel>
);
CustomPanel.tabsRole = "TabPanel";
CustomTab.tabsRole = "Tab";

const Atividades = () => {
  const [isLoading, setIsLoading] = React.useState<boolean>(false);
  const [availableProjects, setAvailableProjects] = React.useState<
    RecuperaProjeto[]
  >([]);
  const [allActivities, setAllActivities] = React.useState<RecuperaAtividade[]>(
    []
  );
  const [myActivities, setMyActivities] = React.useState<RecuperaAtividade[]>(
    []
  );
  const [doingActivities, setDoingActivities] = React.useState<PessoaTrabalhaAtividade[]>([]);
  const [acitivitySearch, setActivitySearch] = React.useState<string>("");
  const { isAdmin, isCoord, userToken } = React.useContext(LoginContext);
  React.useEffect(() => {
    if (userToken) {
      Promise.all([
        GetAvailableProjects(userToken),
        GetAllActivities(userToken),
        GetSelfRegisteredActivities(userToken),
        GetDoingActivities(userToken),
      ])
        .then((responses) => {
          setAvailableProjects(responses[0].data);
          setAllActivities(responses[1].data);
          setMyActivities(responses[2].data);
          setDoingActivities(responses[3].data)
        })
        .catch((errs) => console.log(errs));
    }
  }, []);
  const [tabIndex, setTabIndex] = React.useState<number>(0);
  const { control, handleSubmit } = useForm<CadastroAtividade>({
    defaultValues: {
      aIdProjeto: "1",
      aDescricao: "",
      aTipo: TipoAtividade.OUTRO,
    },
  });

  const tipos: { val: TipoAtividade }[] = [
    { val: TipoAtividade.MANUTENCAO },
    { val: TipoAtividade.IMPLEMENTACAO },
    { val: TipoAtividade.ALTERACAO },
    { val: TipoAtividade.MODELAGEM },
    { val: TipoAtividade.OUTRO },
  ];

  const onSubmit = (data: CadastroAtividade) => {
    setIsLoading(true);
    const newData: CadastroAtividade = {
      aIdProjeto:
        typeof data.aIdProjeto === "string"
          ? parseInt(data.aIdProjeto, 10)
          : data.aIdProjeto,
      aDescricao: data.aDescricao,
      aTipo: data.aTipo,
    };
    console.log(newData);
    if (userToken) {
      Promise.resolve(
        CreateNewActivity(userToken, newData)
          .then((res) => {
            console.log(res);
            setIsLoading(false);
          })
          .catch((err) => {
            console.log(err);
            setIsLoading(false);
          })
      );
    }
  };

  return (
    <>
      <Tabs
        selectedIndex={tabIndex}
        onSelect={(index) => setTabIndex(index)}
        direction="ltr"
        className="flex flex-col md:flex-row items-center gap-6 font-medium text-text w-full"
      >
        <TabList className="w-full md:w-[30%] flex flex-col gap-y-2 text-sm py-10 px-4 bg-white shadow-xl rounded-lg h-auto self-start">
          {isAdmin() || isCoord() ? (
            <>
              <CustomTab>
                <FaFolderPlus />
                Cadastrar nova atividade{" "}
              </CustomTab>
              <CustomTab>
                <FaFolderOpen />
                Ver atividades cadastradas por mim
              </CustomTab>
            </>
          ) : (
            <></>
          )}
          <CustomTab>
            <MdContacts />
            Ver minhas atividades
          </CustomTab>
          <CustomTab>
            <FaBookOpen />
            Ver todas as atividades
          </CustomTab>
          <CustomTab>
            <MdAssignment />
            Ver atividades que as pessoas estão fazendo
          </CustomTab>
        </TabList>
        <CustomPanel>
          <form
            onSubmit={handleSubmit(onSubmit)}
            className="flex flex-col gap-y-4"
          >
            <Title message="Cadastre uma nova atividade para ser realizada por alguém" />
            <Controller
              control={control}
              name="aIdProjeto"
              rules={{ required: true }}
              render={({
                field: { value, name, onChange },
                formState: { errors },
              }) => (
                <div className="flex flex-col gap-y-2">
                  <label className="text-sm font-semibold">
                    Selecione o projeto o qual esta atividade será vinculada
                  </label>
                  <select
                    value={value}
                    onChange={onChange}
                    id={name}
                    className="p-2 rounded-lg border-2 border-bordercolor w-full text-sm uppercase"
                  >
                    {availableProjects.map((proj) => (
                      <option key={proj.prId} value={proj.prId}>
                        {proj.prId} - {proj.prNome}
                      </option>
                    ))}
                  </select>
                  {errors.aIdProjeto &&
                    (errors.aIdProjeto.type == "required" ? (
                      <Erro message="Informe o projeto" />
                    ) : (
                      ""
                    ))}
                </div>
              )}
            />
            <Controller
              name="aTipo"
              rules={{ required: true }}
              render={({
                field: { value, name, onChange },
                formState: { errors },
              }) => (
                <div>
                  <Select
                    array={tipos}
                    value={value}
                    onChange={onChange}
                    id={name}
                    label="Selecione o tipo de atividade..."
                  />
                  {errors.aTipo &&
                    (errors.aTipo?.type == "required" ? (
                      <Erro message="Selecione o tipo" />
                    ) : (
                      ""
                    ))}
                </div>
              )}
              control={control}
            />
            <Controller
              name="aDescricao"
              rules={{ required: true }}
              render={({
                field: { value, name, onChange },
                formState: { errors },
              }) => (
                <div className="flex flex-col gap-y-2">
                  <label className="text-sm font-semibold">
                    Informe a descrição desta atividade
                  </label>
                  <textarea
                    value={value}
                    onChange={onChange}
                    id={name}
                    className="p-2 rounded-lg border-2 border-bordercolor w-full text-sm"
                    placeholder="Digite a descrição para a atividade."
                    rows={6}
                  />
                  {errors.aDescricao &&
                    (errors.aDescricao.type == "required" ? (
                      <Erro message="Preencha a descrição" />
                    ) : (
                      ""
                    ))}
                </div>
              )}
              control={control}
            />
            <Button
              disabled={isLoading}
              type="submit"
              message={
                isLoading ? (
                  <p className="flex flex-row items-center justify-center gap-x-2">
                    {" "}
                    Enviando...
                    <LuLoader2 className="animate-spin" />
                  </p>
                ) : (
                  "Enviar"
                )
              }
            />
          </form>
        </CustomPanel>
        <CustomPanel>
          <div className="flex flex-col gap-y-4">
            <Title message="Aqui você consegue ver todas as atividades cadastradas por você" />
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 w-full gap-2">
              {myActivities.map((act, index) => (
                <Card activity={act} key={index} />
              ))}
            </div>
          </div>
        </CustomPanel>
        <CustomPanel>3</CustomPanel>
        <CustomPanel>
          <div className="flex flex-col gap-y-4">
            <Title message="Aqui você consegue ver todas as atividades, disponíveis ou não" />
            <div className="w-full md:w-[70%]">
              <SearchInput
                label="Busque por uma atividade especifica"
                hasText={acitivitySearch.length > 0}
                value={acitivitySearch}
                onChange={(e) => setActivitySearch(e.target.value)}
                placeholder="Pesquise pela descrição..."
                type="text"
                onClick={() => setActivitySearch("")}
              />
            </div>
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 w-full gap-2">
              {allActivities.map((act, index) => (
                <Card activity={act} key={index} />
              ))}
            </div>
          </div>
        </CustomPanel>
        <CustomPanel>
        <div className="flex flex-col gap-y-4">
            <Title message="Aqui você consegue ver todas as atividades que estão sendo feitas" />
            <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 w-full gap-2">
              {doingActivities.map((doing, index) => (
                <ActivitiesCard key={index} activity={doing} />
              ))}
            </div>
          </div>
        </CustomPanel>
      </Tabs>
      <div></div>
    </>
  );
};

export default Atividades;
