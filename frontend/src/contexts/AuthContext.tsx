import { AxiosResponse } from "axios";
import { Login, PayloadToken, PayloadUsuario } from "models/DTOs";
import { TipoPessoa } from "models/Pessoa";
import React from "react";
import { useNavigate } from "react-router-dom";
import { GetUserPayloadByToken, PerformLogin } from "services/Api";

interface LoginContextProvider {
  children: React.ReactNode;
}

interface LoginContext {
  userPayload?: PayloadUsuario;
  userToken?: string;
  login: (data: Login) => void;
  logout: () => void;
  isLoggedIn: () => boolean;
  isAdmin: () => boolean;
  isCoord: () => boolean;
  isLoading: boolean;
}
const LoginContext = React.createContext<LoginContext>({
  isAdmin: () => false,
  isCoord: () => false,
  isLoggedIn: () => false,
  login: () => "",
  logout: () => {},
  userPayload: {
    pnome: "",
    ptipo: TipoPessoa.ESTAGIÁRIO,
    pid: 0,
  } as PayloadUsuario,
  userToken:"",
  isLoading: false,
});

const LoginContextProvider: React.FC<LoginContextProvider> = ({ children }) => {
  const navigate = useNavigate();
  const [isLoading, setIsLoading] = React.useState<boolean>(false);
  const [userPayload, setUserPayload] = React.useState<PayloadUsuario>();
  const [userToken, setUserToken] = React.useState<string>("");

  const login = (data: Login) => {
    Promise.resolve(
      PerformLogin(data)
        .then((res: AxiosResponse<PayloadToken>) => {
          const { token } = res.data;
          setIsLoading(false);
          setUserToken(token);
          localStorage.setItem("userToken", token);
          navigate("/");
        })
        .catch((err) => {
          console.log(err);
        })
    );
  };
  React.useEffect(() => {
    const userToken = localStorage.getItem("userToken");
    if (userToken) {
      setUserToken(userToken);
      Promise.resolve(
        GetUserPayloadByToken(userToken).then(
          (res: AxiosResponse<PayloadUsuario>) => {
            const userPayload = res.data;
            setUserPayload(userPayload);
            localStorage.setItem("userPayload", JSON.stringify(userPayload));
          }
        ).catch((err) => {
          console.log(err);
        })
      );
    }
  }, [userToken]);

  const isLoggedIn = () => {
    return !!localStorage.getItem("userToken");
  };

  const isAdmin = () => {
    const userPayloadString: string | null =
      localStorage.getItem("userPayload");

    if (userPayloadString) {
      const userPayload: PayloadUsuario = JSON.parse(userPayloadString);
      return userPayload.ptipo === TipoPessoa.ADMINISTRADOR;
    }
    console.log(userPayloadString);
    return false;
  };

  const isCoord = () => {
    const userPayloadString: string | null =
      localStorage.getItem("userPayload");
    console.log(userPayloadString);
    if (userPayloadString) {
      const userPayload: PayloadUsuario = JSON.parse(userPayloadString);
      console.log(userPayload)
      return userPayload.ptipo === TipoPessoa.COORDENADOR;
    }
    return false;
  };

  const logout = () => {
    localStorage.removeItem("userPayload");
    localStorage.removeItem("userToken");
    navigate("/login");
  };
  return (
    <LoginContext.Provider
      value={{
        isAdmin,
        isCoord,
        isLoggedIn,
        login,
        logout,
        userPayload,
        userToken,
        isLoading,
      }}
    >
      {children}
    </LoginContext.Provider>
  );
};

export default LoginContext;
export { LoginContextProvider };
