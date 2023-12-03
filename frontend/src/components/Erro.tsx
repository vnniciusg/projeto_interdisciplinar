interface ErroProps {
    message: string;
}
const Erro = ({message}: ErroProps) => {
  return (
    <small className='text-xs font-semibold font-body pl-2 text-red-600'>{message}</small>
  )
}

export default Erro