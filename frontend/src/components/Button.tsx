import {MouseEventHandler} from 'react'
interface ButtonProps {
    type?: "submit" | "reset" | "button" | undefined;
    onClick?: MouseEventHandler | undefined;
    message: string | React.ReactNode;
    disabled?: boolean
}

const Button = ({type, onClick, message, disabled}: ButtonProps) => {
  return (
    <>
        <button disabled={disabled} className='text-center py-2 w-full rounded-lg text-white bg-primary text-sm hover:bg-primary/90 active:scale-[.98] transition duration-300 font-semibold' type={type} onClick={onClick} >{message}</button>
    </>
  )
}

export default Button