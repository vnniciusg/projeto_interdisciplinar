import { HTMLAttributeAnchorTarget } from "react";

interface LinkProps {
    link: string
    text: string
    target?: HTMLAttributeAnchorTarget | undefined;
}
const Link = ({link, text, target}: LinkProps) => {
  return (
    <a target={target} href={link} className='text-sm font-semibold after:w-0 hover:after:w-full flex flex-col justify-center items-center after:h-[2px] after:block after:bg-text after:transition-all after:duration-300 '>{text}</a>
  )
}

export default Link