import Link from "components/Link";
interface HeaderProps {
  isShown: boolean;
}
const Header = ({ isShown }: HeaderProps) => {
  return (
    <>
      {isShown && (
        <header className="w-full h-[90px]  text-sm fixed top-0 mt-[20px] text-text z-50">
        <nav className="w-[90%] mx-auto flex flex-row bg-white  shadow-xl bg-opacity-80 rounded-lg px-10 items-center h-full">
          <div className="font-title font-bold text-2xl flex flex-shrink-0 text-secondary">Logo</div>
          <div className="flex flex-grow gap-10 justify-center font-title">
            <Link link="/" text="Início" target="_self" />
            <Link link="/atividades" text="Ver atividades" target="_self" />
            <Link link="/projetos" text="Ver projetos" target="_self" />
            <Link link="/registro" text="Cadastro" target="_self" />
            <Link link="/login" text="Login" target="_self" />
          </div>
        </nav>
      </header>
      )}
    </>
  );
};

export default Header;
