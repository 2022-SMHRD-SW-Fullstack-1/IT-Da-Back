// import React, { useState, useRef } from 'react';
// import { useNavigate } from 'react-router-dom';
// import axios from 'axios';
// import '../../css/Login.css';
// import logo from '../../asset/img/logo_sbl.png'
// import { LoginFooter } from './LoginFooter';
// import { Personal_Info } from './Login/Personal_Info';

// /**본인 인증 시, 로그인 및 개인 정보 변경 페이지로 */
// const PwChange = () => {
//   const navigate = useNavigate();
//   const [tab, setTab] = useState(true);

//   const inputPw = useRef('');
//   const [pw, setPw] = useState('');
//   const onPwChange = (e) => {
//     setPw(e.target.value);
//   };
//   const inputPwCheck = useRef('');
//   const [pwCheck, setPwCheck] = useState('');
//   const onPwCheckChange = (e) => {
//     setPwCheck(e.target.value);
//   };

//   const inputId = useRef('');
//   const [id, setId] = useState('');
//   const onIdChange = (e) => {
//     setId(e.target.value);
//   };

//   const onPwChangeLoginPageClick = () => {
//     console.log(pw);
//     axios
//     .post('/member/pwChange', {mb_pw :pw})
//     .then((res) => {
//         console.log(res.data)
//     })
//     .catch((err)=>{
//         alert('서버 연결 실패')
//     })
//     alert('로그인 페이지로 이동합니다')
//     navigate('/')
//   }

//   const handleOnKeyPress = (e) => {
//     if (e.key === 'Enter') {
//         onPwChangeLoginPageClick(); // Enter 입력이 되면 클릭 이벤트 실행
//     }
//   };

//   return (
//     <div>
//         <div><img  className='loginLogo' src={logo} /></div>
//     <div className="loginContainer">
    
//       <div className="topDiv loginDiv">
        
//         <div className="loginTab">
       
//           <button className={tab?'loginBtnStyle':''}
//             onClick={() => {
//               setTab(true);
//               setPw('');
//               setPwCheck('');
//             }}
//           >
//             비밀번호 변경하기 
//           </button>
//         </div>
//         {
//             <div className="memberLogin">
//             <input
//               ref={inputPw}
//               onChange={onPwChange}
//               value={pw}
//               id="PwInput"
//               type="password"
//               placeholder="변경할 비밀번호를 입력해주세요"
//             ></input>
//             <input
//               ref={inputPwCheck}
//               onChange={onPwCheckChange}
//               value={pwCheck}
//               id="PwCheckInput"
//               type="password"
//               placeholder="변경할 비밀번호를 다시 입력해주세요"
//               onKeyPress={handleOnKeyPress}
//             ></input>
//             <button onClick={onPwChangeLoginPageClick}>비밀번호 변경 및 로그인 페이지로 이동</button>
//           </div>
//         }
//       </div>
//     </div>
//     <div >
//       <Personal_Info/>
//     </div>
//     <div className='loginFooter'>
//     <LoginFooter/>
//     </div></div>
//   );
// };


// export default PwChange;
