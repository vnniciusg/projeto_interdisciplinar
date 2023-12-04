import Link from "components/Link";
import LoginContext from "contexts/AuthContext";
import { useMediaQuery } from "hooks/MediaQuery";
import { FiMenu } from "react-icons/fi";
import React from "react";
interface HeaderProps {
  isShown: boolean;
}
const Header = ({ isShown }: HeaderProps) => {
  const [isMenuOpen, setMenuOpen] = React.useState<boolean>(false);
  const { isLoggedIn, logout } = React.useContext(LoginContext);
  const isAboveMD = useMediaQuery("(min-width: 768px)");
  const handleOpenMenu = () => {
    setMenuOpen(!isMenuOpen);
  };
  return (
    <>
      {isShown && (
        <header className="w-full h-[90px]  text-sm fixed top-0 mt-[20px] text-text z-50">
          <nav className="w-[90%] mx-auto flex flex-row bg-white  shadow-xl bg-opacity-80 rounded-lg px-10 items-center h-full justify-between md:justify-normal relative">
            <div className="font-title font-bold text-2xl flex flex-shrink-0 text-secondary">
              Logo
            </div>
            {isAboveMD ? (
              <div className="flex flex-grow gap-10 justify-center font-title">
                <Link link="/" text="Início" target="_self" />
                {!isLoggedIn() ? (
                  <>
                    <Link link="/registro" text="Cadastro" target="_self" />
                    <Link link="/login" text="Login" target="_self" />
                  </>
                ) : (
                  <>
                    <Link
                      link="/atividades"
                      text="Ver atividades"
                      target="_self"
                    />
                    <Link link="/projetos" text="Ver projetos" target="_self" />
                    <button
                      className="bg-secondary px-4 py-2 rounded-lg text-white text-sm hover:bg-secondary/80 active:scale-[0.98] transition duration-300"
                      onClick={() => logout()}
                    >
                      Logout
                    </button>
                  </>
                )}
              </div>
            ) : (
              <>
                <button
                  onClick={() => handleOpenMenu()}
                  className="active:scale-[0.98] text-2xl"
                >
                  <FiMenu />
                </button>
                {isMenuOpen && (
                  <div className="flex flex-col gap-y-4 absolute top-full right-0 shadow-xl bg-white/80 p-6 items-end">
                    <Link link="/" text="Início" target="_self" />
                    {!isLoggedIn() ? (
                      <>
                        <Link link="/registro" text="Cadastro" target="_self" />
                        <Link link="/login" text="Login" target="_self" />
                      </>
                    ) : (
                      <>
                        <Link
                          link="/atividades"
                          text="Ver atividades"
                          target="_self"
                        />
                        <Link
                          link="/projetos"
                          text="Ver projetos"
                          target="_self"
                        />
                        <button
                          className="bg-secondary px-4 py-2 rounded-lg text-white text-sm hover:bg-secondary/80 active:scale-[0.98] transition duration-300"
                          onClick={() => logout()}
                        >
                          Logout
                        </button>
                      </>
                    )}
                  </div>
                )}
              </>
            )}
          </nav>
        </header>
      )}
    </>
  );
};

export default Header;
