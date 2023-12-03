interface SubtitleProps {
    message?: string
}
const Subtitle = ({message}: SubtitleProps) => {
  return (
    <h1 className='w-fit text-base font-normal' >
        {message}
    </h1>
  )
}

export default Subtitle