import React from "react";
interface FooterProps {
  isShown: boolean;
}
const Footer = ({ isShown }: FooterProps) => {
  return (
    <>{isShown && 
      <footer className="w-full h-[100px] bg-primary p-2 text-white text-sm flex flex-col justify-center items-center">

      <div className="w-[90%] mx-auto text-center">
        Trabalho Interdisciplinar Fagoc - 
        Copyright &copy; 2023
      </div>
      </footer>
      }
      </>
  );
};

export default Footer;
