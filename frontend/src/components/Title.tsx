interface TitleProps {
    message?: string
}
const Title = ({message}: TitleProps) => {
  return (
    <h1 className='w-fit text-xl sm:text-2xl md:text-3xl font-black text-title'>
        {message}
    </h1>
  )
}

export default Title