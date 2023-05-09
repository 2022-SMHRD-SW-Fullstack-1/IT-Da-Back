import React, { useState, useRef } from 'react';
import axios from 'axios';
import '../../css/Login.css';
import logo from '../../asset/img/logo_sbl.png'
import { LoginFooter } from './LoginFooter';
import { Personal_Info } from './Login/Personal_Info';

const IdInquiry = () => {

  const [tab, setTab] = useState(true);

  const inputName = useRef('');
  const [name, setName] = useState('');
  const onNameChange = (e) => {
    setName(e.target.value);
  };

  const inputPhone = useRef('');
  const [phone, setPhone] = useState('');
  const onPhoneChange = (e) => {
    setPhone(e.target.value);
  };

  const inputId = useRef('');
  const [id, setId] = useState('');
  const onIdChange = (e) => {
    setId(e.target.value);
  };

  const onIdInquiryClick = () => {
    console.log(name);
    console.log(phone);
    // console.log(id);
    // console.log(pw);
//     axios
//       .post('/member/login', { id: id, pw: pw })
//       .then((res) => {
//         console.log(res.data);
//         if (res.data.mb_job == 's') {
//           window.sessionStorage.setItem('loginId', res.data.mb_id);
//           window.sessionStorage.setItem('role', 's');
//           window.sessionStorage.setItem('userName', res.data.mb_name);
//           window.sessionStorage.setItem('course_key', res.data.course_key);
//           window.location.replace('/');
//         } else if (res.data.mb_job == 't') {
//           window.sessionStorage.setItem('loginId', res.data.mb_id);
//           window.sessionStorage.setItem('role', 't');
//           window.sessionStorage.setItem('userName', res.data.mb_name);
//           window.sessionStorage.setItem('course_key', res.data.course_key);
//           window.location.replace('/');
//         } else if (res.data.mb_job == 'a') {
//           window.sessionStorage.setItem('loginId', res.data.mb_id);
//           window.sessionStorage.setItem('role', 'a');
//           window.sessionStorage.setItem('userName', res.data.mb_name);
//           window.sessionStorage.setItem('course_key', '52D8EECC');
//           window.location.replace('/');

//         } else alert('일치하는 회원정보가 없습니다');
//       })
//       .catch((e) => console.log(e));
  };

  const onPwInquiryClick = () => {

    console.log(id);
    console.log(name);
    console.log(phone);
    //window.sessionStorage.setItem('role', 'e');
    //window.sessionStorage.setItem('userName', '유티소프트');
    //window.location.replace('/e_main');
    // axios
    //   .post('/enterprise/login', { id: id, pw: pw })
    //   .then((res) => {
    //     console.log(res.data);
    //     if (res.data.enter_approve == 'N') {
    //       alert('승인되지 않은 아이디입니다.')
    //     } else {
    //       window.sessionStorage.setItem('loginId', res.data.enter_id);
    //       window.sessionStorage.setItem('role', 'e');
    //       window.sessionStorage.setItem('userName', res.data.enter_name);
    //       window.location.replace('/');
    //     }
    //   })
    //   .catch((e) => console.log(e));
  };

  const handleOnKeyPress = (e) => {
    if (e.key === 'Enter') {
      onIdInquiryClick(); // Enter 입력이 되면 클릭 이벤트 실행
    }
  };
  const handleOnKeyPress2 = (e) => {
    if (e.key === 'Enter') {
      onPwInquiryClick(); // Enter 입력이 되면 클릭 이벤트 실행
    }
  };

  return (
    <div>
        <div><img  className='loginLogo' src={logo} /></div>
    <div className="loginContainer">
    
      <div className="topDiv loginDiv">
        
        <div className="loginTab">
       
          <button className={tab?'loginBtnStyle':''}
            onClick={() => {
              setTab(true);
              setName('');
              setPhone('');
            }}
          >
            아이디 찾기
          </button>
          <button  className={tab?'':'loginBtnStyle'}
            onClick={() => {
              setTab(false);
              setId('');
              setName('');
              setPhone('');
            }}
          >
            비밀번호 찾기
          </button>
        </div>
        {tab ? (
            <div className="memberLogin">
            <input
              ref={inputName}
              onChange={onNameChange}
              value={name}
              id="NameInput"
              type="text"
              placeholder="이름 입력해주세요"
            ></input>
            <input
              ref={inputPhone}
              onChange={onPhoneChange}
              value={phone}
              id="PhoneInput"
              type="text"
              placeholder="전화번호를 입력해주세요"
              onKeyPress={handleOnKeyPress}
            ></input>
            {/* <div>
              <input type="checkbox"></input>
              <span>로그인 유지</span>
              <input type="checkbox"></input>
              <span>아이디 저장</span>
            </div> */}
            <button onClick={onIdInquiryClick}>본인인증 및 아이디 확인</button>
            {/* <div>
              <span className='hoverHand' onClick={onIdInquiryClick}>
                아이디 찾기
              </span>
              <span className='loginLine_1'>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
              <span className='hoverHand' onClick={onPwInquiryClick}>
                비밀번호 찾기
              </span>
              <span className='loginLine_1'>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
              <span className="loginRegisterNav" onClick={onClickRegister}>
                회원가입
              </span>
            </div> */}
          </div>
        ) : (
          <div className="enterpriseLogin">
            <input
              ref={inputId}
              onChange={onIdChange}
              value={id}
              id="IdInput"
              type="text"
              placeholder="아이디를 입력해주세요"
            ></input>
            <input
              ref={inputName}
              id='NameInput'
              onChange={onNameChange}
              value={name}
              type="text"
              placeholder="이름을 입력해주세요"
            ></input>
            <input
              ref={inputPhone}
              id='PhoneInput'
              onChange={onPhoneChange}
              value={phone}
              type="text"
              placeholder="전화번호를 입력해주세요"
              onKeyPress={handleOnKeyPress2}
            ></input>
            {/* <div>
              <input type="checkbox"></input>
              <span>로그인 유지</span>
              <input type="checkbox"></input>
              <span>아이디 저장</span>
            </div> */}
            <button onClick={onPwInquiryClick}>본인인증 및 비밀번호 변경</button>
            {/* <div>
              <span>아이디 찾기</span>
              <span className='loginLine_1'>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
              <span>비밀번호 찾기</span>
              <span className='loginLine_1'>&nbsp;&nbsp;|&nbsp;&nbsp;</span>
              <span className='hoverHand' onClick={onClickE_Register}>회원가입</span>
            </div> */}
          </div>
        )}
      </div>
    </div>
    <div >
      <Personal_Info/>
    </div>
    <div className='loginFooter'>
    <LoginFooter/>
    </div></div>
  );
};


export default IdInquiry;
