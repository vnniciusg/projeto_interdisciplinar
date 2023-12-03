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
  userToken?: PayloadToken;
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
  userToken: { token: "" } as PayloadToken,
  isLoading: false,
});

const LoginContextProvider: React.FC<LoginContextProvider> = ({ children }) => {
  const navigate = useNavigate();
  const [isLoading, setIsLoading] = React.useState<boolean>(false);
  const [userPayload, setUserPayload] = React.useState<PayloadUsuario>();
  const [userToken, setUserTokoen] = React.useState<PayloadToken>();

  const login = (data: Login) => {
    Promise.resolve(
      PerformLogin(data)
        .then((res: AxiosResponse<PayloadToken>) => {
          const { token } = res.data;
          setIsLoading(false);
          setUserTokoen((prevState: PayloadToken | undefined) => {
            if (!prevState) {
              return { token };
            }
            return { ...prevState, token };
          });
          localStorage.setItem("userToken", JSON.stringify(token));
          navigate("/");
        })
        .catch((err) => {
          console.log(err);
        })
    );
  };
  React.useEffect(() => {
    if (userToken?.token) {
      Promise.resolve(
        GetUserPayloadByToken(userToken?.token).then(
          (res: AxiosResponse<PayloadUsuario>) => {
            const userPayload = res.data;
            console.log(res);
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
