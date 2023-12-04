import Footer from "components/fixeds/Footer";
import Header from "components/fixeds/Header";
import React from "react";
import { Routes, Route } from "react-router-dom";
const Inicio = React.lazy(() => import("views/Home"));
const Login = React.lazy(() => import("views/Login"))
const Registro = React.lazy(() => import("views/SignUp"))
const Atividades = React.lazy(() => import("views/Activities"))
const Projetos = React.lazy(() => import("views/Projects"))
function App() {
  const [showNavAndFooter, setShowNavAndFooter] = React.useState<boolean>(false);
  React.useEffect(() => {
    const windowLocation = window.location.pathname;
    if(windowLocation.startsWith("/login") || windowLocation.startsWith("/registro")){
      setShowNavAndFooter(false);
    } else {
      setShowNavAndFooter(true);
    }
  })

  return (
    <>
      <React.Suspense>
          <div className="font-global">
            <Header isShown={showNavAndFooter} />
            <div className="w-[90%] mx-auto min-h-screen pt-[150px] text-text">
              <Routes>
                <Route index path="/" Component={Inicio} />
                <Route path="login" Component={Login} />
                <Route path="registro" Component={Registro} />
                  <Route path="atividades" Component={Atividades}/>
                  <Route path="projetos" Component={Projetos} />
                
              </Routes>
            </div>
            <Footer isShown={showNavAndFooter} />
          </div>
      </React.Suspense>
    </>
  );
}

export default App;
