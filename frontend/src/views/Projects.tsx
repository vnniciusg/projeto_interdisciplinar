import React from "react";
import { FaFolderPlus, FaFolderOpen } from "react-icons/fa";
import { MdContacts } from "react-icons/md";
import { FaBookOpen } from "react-icons/fa6";
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
import { CreateNewProject } from "services/Api";
import LoginContext from "contexts/AuthContext";

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
  const {isAdmin} = React.useContext(LoginContext);
  const [isLoading, setIsLoading] = React.useState<boolean>(false);
  const [tabIndex, setTabIndex] = React.useState<number>(0);
  const { control, handleSubmit } = useForm<CadastroProjeto>({
    defaultValues: {
      prNome: "1",
      prObjetivo: "",
      prRecursos: "",
    },
  });

  const onSubmit = (data: CadastroProjeto) => {
    setIsLoading(true);
    Promise.resolve(
      CreateNewProject(
        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MDMiLCJpc3MiOiJ0ZXN0ZSIsImV4cCI6MTcwMTY0NjI0NH0.Z380S_rOEEXt9wJ1kPgrXeWT5L8eppzf2DUjmfHpSEU",
        data
      )
        .then((res) => {
          console.log(res);
          setIsLoading(false);
        })
        .catch((err) => {
          console.log(err);
          setIsLoading(false);
        })
    );
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
              <CustomTab>
                <FaFolderOpen />
                Ver projetos cadastrador por min
              </CustomTab>
            </>
          )}
          <CustomTab>
            <MdContacts />
            Projetos em andamento
          </CustomTab>
          <CustomTab>
            <FaBookOpen />
            Ver Todos os projetos
          </CustomTab>
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
                  control={control}
                  name="prNome"
                  rules={{ required: true }}
                  render={({
                    field: { value, name, onChange },
                    formState: { errors },
                  }) => (
                    <div>
                      <select
                        value={value}
                        onChange={onChange}
                        id={name}
                        className="p-2 rounded-lg border-2 border-bordercolor w-full text-sm"
                      ></select>
                      {errors.prNome &&
                        (errors.prNome.type == "required" ? (
                          <Erro message="Informe o projeto" />
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
                    <div>
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
                          <Erro message="Selecione o tipo" />
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
                    <div>
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

            <CustomPanel>2</CustomPanel>
          </>
        )}
        <CustomPanel>3</CustomPanel>
        <CustomPanel>4</CustomPanel>
      </Tabs>
      <div></div>
    </>
  );
};

export default Projetos;
