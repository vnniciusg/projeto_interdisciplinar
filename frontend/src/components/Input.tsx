import { FaEyeSlash } from "react-icons/fa";
import { IoEyeSharp } from "react-icons/io5";
import React, { ChangeEventHandler } from "react";
interface InputProps {
  id: string;
  label?: string;
  disabled?: boolean;
  type: React.HTMLInputTypeAttribute;
  value?: string | ReadonlyArray<string> | number | undefined;
  onChange?: ChangeEventHandler<HTMLInputElement> | undefined;
  placeholder?: string | undefined;
}
const Input = ({
  id,
  label,
  type = "text",
  disabled,
  onChange,
  value,
  placeholder,
}: InputProps) => {
  const [showPassword, setShowPassword] = React.useState(false);

  const handleShowPassword = () => {
    setShowPassword(!showPassword);
  };

  return (
    <div className="flex justify-center gap-y-2 flex-col w-full">
      <label className="text-sm font-semibold">{label}</label>
      <div className="relative w-full flex flex-row items-center">
        <input
          id={id}
          disabled={disabled}
          type={showPassword ? "text" : type}
          onChange={onChange}
          value={value}
          className="p-2 rounded-lg border-2 border-bordercolor w-full text-sm"
          placeholder={placeholder}
        />
        {type === "password" && (
          <button
            type="button"
            onClick={handleShowPassword}
            className=" absolute right-3 text-lg active:scale-[0.98]"
          >
            {showPassword ? <IoEyeSharp /> : <FaEyeSlash />}
          </button>
        )}
      </div>
    </div>
  );
};

export default Input;
