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
import { CadastroAtividade, RecuperaProjeto } from "models/DTOs";
import { TipoAtividade } from "models/Atividade";
import Button from "components/Button";
import Select from "components/Select";
import Erro from "components/Erro";
import { CreateNewActivity, GetAvailableProjects } from "services/Api";

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
  React.useEffect(() => {
    Promise.resolve(
      GetAvailableProjects(
        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MDMiLCJpc3MiOiJ0ZXN0ZSIsImV4cCI6MTcwMTU4NjkzOX0.JpRCp3nD__0NoENEKPhnY7X223zxDOSGsPVyzPCFCuA"
      )
        .then((res) => setAvailableProjects(res.data))
        .catch((err) => console.log(err))
    );
  }, []);
  const [isLoading, setIsLoading] = React.useState<boolean>(false);
  const [availableProjects, setAvailableProjects] = React.useState<
    RecuperaProjeto[]
  >([]);
  const [tabIndex, setTabIndex] = React.useState<number>(0);
  const { control, handleSubmit } = useForm<CadastroAtividade>({
    defaultValues: {
      aIdProjeto: "1",
      aDescricao: "",
      aTipo: TipoAtividade.OUTRO,
    },
  });

  const tipos: { val: TipoAtividade}[] = [
    { val: TipoAtividade.MANUTENCAO },
    { val: TipoAtividade.IMPLEMENTACAO},
    { val: TipoAtividade.ALTERACAO },
    { val: TipoAtividade.MODELAGEM },
    { val: TipoAtividade.OUTRO },
  ];

  const onSubmit = (data: CadastroAtividade) => {
    setIsLoading(true);
    const newData: CadastroAtividade = {aIdProjeto: typeof data.aIdProjeto === 'string' ? parseInt(data.aIdProjeto, 10) : data.aIdProjeto, aDescricao: data.aDescricao, aTipo: data.aTipo};
    console.log(newData);
    Promise.resolve(
      CreateNewActivity(
        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1MDMiLCJpc3MiOiJ0ZXN0ZSIsImV4cCI6MTcwMTU5MTYwOX0.lqBXp4llFMt7P2rcugnZs2mHrnyaY24-1-FOTAoHYvk",
        newData
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
          <CustomTab>
            <FaFolderPlus />
            Cadastrar nova atividade{" "}
          </CustomTab>
          <CustomTab>
            <FaFolderOpen />
            Ver atividades cadastradas por mim
          </CustomTab>
          <CustomTab>
            <MdContacts />
            Ver minhas atividades
          </CustomTab>
          <CustomTab>
            <FaBookOpen />
            Ver todas as atividades
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
                <div>
                  <select
                    value={value}
                    onChange={onChange}
                    id={name}
                    className="p-2 rounded-lg border-2 border-bordercolor w-full text-sm"
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
                <div>
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
        <CustomPanel>2</CustomPanel>
        <CustomPanel>3</CustomPanel>
        <CustomPanel>4</CustomPanel>
      </Tabs>
      <div></div>
    </>
  );
};

export default Atividades;
