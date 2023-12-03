import Button from "components/Button";
import Erro from "components/Erro";
import Input from "components/Input";
import Select from "components/Select";
import Subtitle from "components/Subtitle";
import Title from "components/Title";
import { CadastroPessoa } from "models/DTOs";
import { TipoPessoa } from "models/Pessoa";
import React from "react";
import { Controller, useForm } from "react-hook-form";

const SignUp = () => {
  const [residencial, setResidencial] = React.useState<boolean>(false);
  const [recado, setRecado] = React.useState<boolean>(false);

  const { control, handleSubmit } = useForm<CadastroPessoa>({
    defaultValues: {
      pNome: "",
      pNomeMae: "",
      pNomePai: "",
      pCpf: "",
      pRg: "",
      pEmail: "",
      pTelCelular: "",
      pTelRecado: "",
      pTelResidencial: "",
      pSenha: "",
      pTipo: TipoPessoa.ESTAGIÁRIO,
    },
  });

  const tipos: { val: TipoPessoa; nome: string }[] = [
    { val: TipoPessoa.ESTAGIÁRIO, nome: "Estagiário" },
    { val: TipoPessoa.COORDENADOR, nome: "Coordenador" },
    { val: TipoPessoa.ADMINISTRADOR, nome: "Administrador" },
  ];

  const onSubmit = (data: CadastroPessoa) => {
    console.log(data);
  };
  return (
    <>
      <div className="absolute left-1/2 -translate-x-1/2  h-auto w-[85%] sm:w-[70%] md:w-1/3 lg:w-[300px] flex flex-col gap-y-6">
        <div className="flex flex-col gap-y-1">
          <Title message="Olá, primeira vez acessando?" />
          <Subtitle message="Crie a sua conta" />
        </div>
        <form
          onSubmit={handleSubmit(onSubmit)}
          className="flex flex-col gap-y-2"
        >
          <Controller
            name="pNome"
            control={control}
            defaultValue=""
            rules={{
              required: true,
            }}
            render={({ field: { name, value, onChange }, formState:{errors} }) => (
              <div>
                <Input
                  id={name}
                  type="text"
                  label="Seu nome completo"
                  onChange={onChange}
                  value={value}
                  placeholder="Digite seu nome completo..."
                />
                {errors.pNome &&
                  (errors.pNome.type == "required"
                    ? <Erro message="Preencha seu nome" />
                    : "")}
              </div>
            )}
          />
          <Controller
            name="pNomeMae"
            control={control}
            rules={{
              required: true,
            }}
            render={({ field: { name, onChange, value }, formState: {errors} }) => (
              <div>
                <Input
                  id={name}
                  value={value}
                  onChange={onChange}
                  type="text"
                  label="Nome da mãe"
                  placeholder="Digite o nome completo da sua mãe..."
                />
                {errors.pNomeMae &&
                  (errors.pNomeMae.type == "required"
                    ? <Erro message="Preencha o nome da sua mãe" />
                    : "")}
              </div>
            )}
          />
          <Controller
            name="pNomePai"
            control={control}
            rules={{
              required: true,
            }}
            render={({ field: { name, onChange, value }, formState: {errors} }) => (
              <div>
                <Input
                  id={name}
                  value={value}
                  onChange={onChange}
                  type="text"
                  label="Nome do pai"
                  placeholder="Digite o nome completo do seu pai..."
                />
                {errors.pNomePai &&
                  (errors.pNomePai.type == "required"
                    ? <Erro message="Preencha o nome do seu pai" />
                    : "")}
              </div>
            )}
          />
          <Controller
            name="pEmail"
            control={control}
            rules={{
              required: true,
            }}
            render={({ field: { name, onChange, value }, formState: {errors} }) => (
              <div>
                <Input
                  id={name}
                  value={value}
                  onChange={onChange}
                  type="email"
                  label="Endereço de email"
                  placeholder="Digite o seu endereço de email"
                />
                {errors.pEmail &&
                  (errors.pEmail.type == "required"
                    ? <Erro message="Preencha o seu email" />
                    : "")}
              </div>
            )}
          />
          <Controller
            name="pCpf"
            control={control}
            rules={{
              required: true,
            }}
            render={({ field: { name, onChange, value }, formState: {errors} }) => (
              <div>
                <Input
                  id={name}
                  value={value}
                  onChange={onChange}
                  type="text"
                  label="Seu CPF"
                  placeholder="Digite o seu número de CPF..."
                />
                {errors.pCpf &&
                  (errors.pCpf.type == "required"
                    ? <Erro message="Preencha o seu CPF" />
                    : "")}
              </div>
            )}
          />
          <Controller
            name="pRg"
            control={control}
            rules={{
              required: true,
            }}
            render={({ field: { name, onChange, value }, formState: {errors} }) => (
              <div>
                <Input
                  id={name}
                  value={value}
                  onChange={onChange}
                  type="text"
                  label="Número do RG"
                  placeholder="Digite o seu RG..."
                />
                {errors.pRg &&
                  (errors.pRg.type == "required"
                    ? <Erro message="Preencha o seu RG" />
                    : "")}
              </div>
            )}
          />
          <Controller
            name="pTelCelular"
            control={control}
            rules={{
              required: true,
            }}
            render={({ field: { name, onChange, value }, formState: {errors} }) => (
              <div>
                <Input
                  id={name}
                  value={value}
                  onChange={onChange}
                  type="tel"
                  label="Número de celular"
                  placeholder="Digite o seu número de celular..."
                />
                {errors.pTelCelular &&
                  (errors.pTelCelular.type == "required"
                    ? <Erro message="Preencha o seu celular" />
                    : "")}
              </div>
            )}
          />

          <div className="flex flex-row gap-2 items-center text-xs flex-wrap">
            <div className="flex flex-row items-center gap-x-2">
              <input
                type="checkbox"
                id="telres"
                onClick={() => setResidencial(!residencial)}
              />
              <label htmlFor="telres">Possui telefone residencial?</label>
            </div>
            <div className="flex flex-row items-center gap-x-2">
              <input
                type="checkbox"
                id="telrec"
                onClick={() => setRecado(!recado)}
              />
              <label htmlFor="telrec">Possui telefone de recado?</label>
            </div>
          </div>
          {residencial && (
            <Controller
              name="pTelResidencial"
              control={control}
              rules={{
                required: residencial,
              }}
              render={({ field: { name, onChange, value } }) => (
                <div>
                  <Input
                    id={name}
                    value={value}
                    onChange={onChange}
                    type="tel"
                    label="Número do telefone residencial"
                    placeholder="Digite o seu número de telefone residencial..."
                  />
                </div>
              )}
            />
          )}

          {recado && (
            <Controller
              name="pTelRecado"
              control={control}
              rules={{
                required: recado,
              }}
              render={({ field: { name, onChange, value }, formState: {errors} }) => (
                <div>
                  <Input
                    id={name}
                    value={value}
                    onChange={onChange}
                    type="tel"
                    label="Número do telefone de recado"
                    placeholder="Digite o seu número de telefone para recados..."
                  />
                  {errors.pEmail &&
                  (errors.pEmail.type == "required"
                    ? <Erro message="Preencha o seu email" />
                    : "")}
                </div>
              )}
            />
          )}

          <Controller
            name="pTipo"
            control={control}
            rules={{
              required: true,
            }}
            render={({ field: { name, onChange, value }, formState: {errors} }) => (
              <div>
                <Select
                  label="Selecione o seu tipo de usuário"
                  id={name}
                  onChange={onChange}
                  value={value}
                  array={tipos}
                />
                {errors.pTipo &&
                  (errors.pTipo.type == "required"
                    ? <Erro message="Selecione o seu tipo" />
                    : "")}
              </div>
            )}
          />
          <Controller
            name="pSenha"
            control={control}
            rules={{
              required: true,
            }}
            render={({ field: { name, onChange, value }, formState:{errors} }) => (
              <div>
                <Input
                  id={name}
                  value={value}
                  onChange={onChange}
                  type="password"
                  label="Senha"
                  placeholder="Digite a sua senha..."
                />
                {errors.pSenha &&
                  (errors.pSenha.type == "required"
                    ? <Erro message="Informe uma senha" />
                    : "")}
              </div>
            )}
          />
          <Button type="submit" message="Enviar" />
        </form>
        <div className="flex flex-row items-center gap-x-1 flex-wrap text-xs gap-y-1 self-end">
            Já possui uma conta? <a href="/signin" className="text-secondary underline">Faça o login agora</a>
        </div>
      </div>
    </>
  );
};

export default SignUp;
