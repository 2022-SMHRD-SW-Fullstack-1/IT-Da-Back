import React from "react";
import { useNavigate } from "react-router-dom";

const RegisterSel = () => {
  const navigate = useNavigate();

  const onClickS_Register = () => {
    navigate("/register", { state: { role: 's'} });
  };

  const onClickT_Register = () => {
    navigate("/register", { state: { role: 't'} });
  };

  const onClickE_Register = () => {
    navigate("/e_register");
  };

  const button_enter = () => { };

  const button_leave = () => {};

  return (
    <div>
      <div className="register_select_container">
        <div>
          <button id="register_student_button" onClick={onClickS_Register}>
            <p>수강생</p>
          </button>
        </div>
        <div>
          <button id="register_teacher_button" onClick={onClickT_Register}>
            <p>연구원</p>
          </button>
        </div>
        <div>
          <div></div>
          <button id="register_enterprise_button" onClick={onClickE_Register}>
            <p>기업</p>
          </button>
        </div>
      </div>
    </div>
  );
};

export default RegisterSel;
