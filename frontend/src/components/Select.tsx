import { TipoAtividade } from "models/Atividade";
import { TipoPessoa } from "models/Pessoa";
import {ChangeEventHandler} from "react";
interface SelectProps {
    array?: {val: TipoPessoa | TipoAtividade | number}[]
    onChange?: ChangeEventHandler<HTMLSelectElement> | undefined
    value?: string | readonly string[] | number | undefined;
    id: string;
    label?: string;
}
const Select = ({array, onChange, value, id, label}: SelectProps) => {
  return (
    <>
    <div className="flex justify-center gap-y-2 flex-col w-full">
    <label className="text-sm font-semibold">{label}</label>
      <select id={id} value={value} className="p-2 rounded-lg border-2 border-bordercolor w-full text-sm" onChange={onChange} >
        {array?.map((tipo, index) => (
            <option value={tipo.val} key={index} >
                {tipo.val}
            </option>
        ))}
      </select>
        </div>
    </>
  );
};

export default Select;
