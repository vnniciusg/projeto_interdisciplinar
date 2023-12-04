import React from "react";
import { FaFolderPlus } from "react-icons/fa";
import { LuLoader2 } from "react-icons/lu";
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
import { CadastroProjeto } from "models/DTOs";
import Button from "components/Button";
import Erro from "components/Erro";
import { CreateNewProject, GetEveryone } from "services/Api";
import LoginContext from "contexts/AuthContext";
import Input from "components/Input";
import { Pessoa, TipoPessoa } from "models/Pessoa";

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

const Projetos = () => {
  const { isAdmin, userToken } = React.useContext(LoginContext);
  const [isLoading, setIsLoading] = React.useState<boolean>(false);
  const [tabIndex, setTabIndex] = React.useState<number>(0);
  const { control, handleSubmit } = useForm<CadastroProjeto>({
    defaultValues: {
      prNome: "",
      prObjetivo: "",
      prRecursos: "",
      prIdPessoaCoordena: 0,
    },
  });
  const [coords, setCoords] = React.useState<Pessoa[]>([]);
  React.useEffect(() => {
    if (userToken) {
      Promise.resolve(
        GetEveryone(userToken)
          .then((res) => {
            const allCoords = res.data.filter((users: Pessoa) => {
              return users.pTipo === TipoPessoa.COORDENADOR;
            });
            setCoords(allCoords);
          })
          .catch((err) => console.log(err))
      );
    }
  }, []);
  const onSubmit = (data: CadastroProjeto) => {
    setIsLoading(true);
    if (userToken) {
      Promise.resolve(
        CreateNewProject(userToken, data)
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
          {isAdmin() && (
            <>
              <CustomTab>
                <FaFolderPlus />
                Cadastrar novo projeto{" "}
              </CustomTab>
            </>
          )}
        </TabList>
        {isAdmin() && (
          <>
            <CustomPanel>
              <form
                onSubmit={handleSubmit(onSubmit)}
                className="flex flex-col gap-y-4"
              >
                <Title message="Cadastre uma nova atividade para ser realizada por alguém" />
                <Controller
                  name="prIdPessoaCoordena"
                  control={control}
                  rules={{ required: true }}
                  render={({
                    field: { value, name, onChange },
                    formState: { errors },
                  }) => (
                    <div className="flex flex-col gap-1">
                      <label className="text-sm font-semibold">Nome do coordenador</label>
                      <select
                        value={value}
                        onChange={onChange}
                        id={name}
                        className="p-2 rounded-lg border-2 border-bordercolor w-full text-sm uppercase"
                      >
                        {coords.map((coord) => (
                          <option key={coord.pID} value={coord.pID}>
                            {coord.pID} - {coord.pNome}
                          </option>
                        ))}
                      </select>
                      {errors.prIdPessoaCoordena &&
                        (errors.prIdPessoaCoordena?.type == "required" ? (
                          <Erro message="Selecione o tipo" />
                        ) : (
                          ""
                        ))}
                    </div>
                  )}
                />
                <Controller
                  name="prNome"
                  control={control}
                  rules={{ required: true }}
                  render={({
                    field: { value, name, onChange },
                    formState: { errors },
                  }) => (
                    <div>
                      <Input
                        value={value}
                        onChange={onChange}
                        type="text"
                        label="Nome do projeto"
                        placeholder="Informe o nome do projeto..."
                        id={name}
                      />
                      {errors.prNome &&
                        (errors.prNome.type == "required" ? (
                          <Erro message="Informe o nome projeto" />
                        ) : (
                          ""
                        ))}
                    </div>
                  )}
                />
                <Controller
                  name="prRecursos"
                  rules={{ required: true }}
                  render={({
                    field: { value, name, onChange },
                    formState: { errors },
                  }) => (
                    <div className="flex flex-col gap-1">
                      <label className="text-sm font-semibold">Lista dos recursos</label>
                      <textarea
                        value={value}
                        onChange={onChange}
                        id={name}
                        className="p-2 rounded-lg border-2 border-bordercolor w-full text-sm"
                        placeholder="Digite a lista de recursos para o projeto..."
                        rows={6}
                      />
                      {errors.prRecursos &&
                        (errors.prRecursos?.type == "required" ? (
                          <Erro message="Informe a lista de recursos" />
                        ) : (
                          ""
                        ))}
                    </div>
                  )}
                  control={control}
                />
                <Controller
                  name="prObjetivo"
                  rules={{ required: true }}
                  render={({
                    field: { value, name, onChange },
                    formState: { errors },
                  }) => (
                    <div className="flex flex-col gap-1">
                      <label className="text-sm font-semibold">Descrição do projeto</label>
                      <textarea
                        value={value}
                        onChange={onChange}
                        id={name}
                        className="p-2 rounded-lg border-2 border-bordercolor w-full text-sm"
                        placeholder="Digite a descrição para o projeto..."
                        rows={6}
                      />
                      {errors.prObjetivo &&
                        (errors.prObjetivo.type == "required" ? (
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
          </>
        )}
      </Tabs>
      <div></div>
    </>
  );
};

export default Projetos;
