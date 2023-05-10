import { React, useState } from "react";
import { useNavigate } from "react-router-dom";
import RegisterButton from "./RegisterButton";

const RegisterSel = () => {
  const navigate = useNavigate();

  const onClickS_Register = () => {
    navigate("/register", { state: { role: "s" } });
  };

  const onClickT_Register = () => {
    navigate("/register", { state: { role: "t" } });
  };

  const onClickE_Register = () => {
    navigate("/e_register");
  };

  return (
    <div>
      <div className="register_select_container">
        <div>
          <RegisterButton
            id="register_student_button"
            className="register_button"
            onClick={onClickS_Register}
          >
            <p>수강생</p>
          </RegisterButton>
        </div>
        <div>
          <RegisterButton
            id="register_teacher_button"
            className="register_button"
            onClick={onClickT_Register}
          >
            <p>연구원</p>
          </RegisterButton>
        </div>
        <div>
          <div></div>
          <RegisterButton
            id="register_enterprise_button"
            className="register_button"
            onClick={onClickE_Register}
          >
            <p>기업</p>
          </RegisterButton>
        </div>
      </div>
    </div>
  );
};

export default RegisterSel;
