import Button from "components/Button";
import Erro from "components/Erro";
import Input from "components/Input";
import Subtitle from "components/Subtitle";
import Title from "components/Title";
import LoginContext from "contexts/AuthContext";
import { Login } from "models/DTOs";
import React from "react";
import { useForm, Controller } from "react-hook-form";

const SignIn = () => {
  const { control, handleSubmit } = useForm<Login>({
    defaultValues: {
      pEmail: "",
      pSenha: "",
    },
  });
  const {login} = React.useContext(LoginContext)
  const doLogin = (data: Login) => {
    login(data);
  };
  return (
    <div className="absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2 h-[200px] w-[95%] sm:w-[70%] md:w-1/3 lg:w-[300px] flex flex-col gap-y-4">
      <div className="self-start flex flex-col gap-y-1">
        <Title message="Olá, já possui uma conta?" />
        <Subtitle message="Faça o login agora" />
      </div>
      <form
        onSubmit={handleSubmit(doLogin)}
        className="self-center flex flex-col gap-y-2 w-full"
      >
        <Controller
          control={control}
          name="pEmail"
          rules={{
            required: true
          }}
          render={({
            field: { name, value, onChange },
            formState: { errors },
          }) => (
            <div className="flex flex-col gap-y-1">
              <Input
                onChange={onChange}
                value={value}
                id={name}
                type="text"
                label="Email"
                placeholder="Digite seu email..."
              />
              
                {errors.pEmail &&
                  (errors.pEmail.type == "required"
                    ? <Erro message="Preencha seu email" />
                    : "")}
              
            </div>
          )}
        />
        <Controller
          control={control}
          name="pSenha"
          rules={{
            required: true
          }}
          render={({ field: { name, value, onChange }, formState: {errors} }) => (
            <div className="flex flex-col gap-y-1">
              <Input
                onChange={onChange}
                value={value}
                id={name}
                type="password"
                label="Senha"
                placeholder="Digite sua senha..."
              />
              
                {errors.pSenha &&
                  (errors.pSenha.type == "required"
                    ? <Erro message="Preencha sua senha" />
                    : "")}
              
            </div>
          )}
        />
        <Button message="Enviar" type="submit" />
      </form>
      <div className="flex flex-row items-center gap-x-1 flex-wrap text-xs gap-y-1 self-end">
            Ainda não possui uma conta? <a href="/registro" className="text-secondary underline">Crie uma agora</a>
        </div>
    </div>
  );
};

export default SignIn;
