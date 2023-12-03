import {
  ChangeEventHandler,
  HTMLInputTypeAttribute,
  MouseEventHandler,
} from "react";
import { IoIosClose } from "react-icons/io";
interface InputProps {
  type?: HTMLInputTypeAttribute | undefined;
  placeholder?: string | undefined;
  value?: string | number | readonly string[] | undefined;
  onChange?: ChangeEventHandler<HTMLInputElement> | undefined;
  label?: string;
  hasText?: boolean;
  onClick?: MouseEventHandler<undefined & HTMLInputElement> | undefined;
}
const SearchInput = ({
  onChange,
  placeholder,
  type,
  value,
  label,
  hasText,
  onClick,
}: InputProps) => {
  return (
    <>
      <div className="gap-y-1 relative flex flex-row items-center h-[60px] w-full">
        <div className="flex flex-col w-full gap-2 h-full relative">
          <label htmlFor="input" className="text-sm">{label}</label>
          <input
            id="input"
            type={type}
            placeholder={placeholder}
            value={value}
            onChange={onChange}
            className="pl-2 pr-8 h-full rounded-lg text-xs text-newBlack w-full border-2"
          />
        </div>
        {hasText && (
          <button
            onClick={onClick}
            className="absolute bottom-2 right-1 text-iconSize transition-all duration-300 text-black"
          >
            <IoIosClose />
          </button>
        )}
      </div>
    </>
  );
};

export default SearchInput;
