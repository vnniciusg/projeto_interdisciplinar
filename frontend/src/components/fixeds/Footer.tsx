import React from "react";
interface FooterProps {
  isShown: boolean;
}
const Footer = ({ isShown }: FooterProps) => {
  return <>{isShown && <div className="h-[100px] bg-black">Footer</div>}</>;
};

export default Footer;
