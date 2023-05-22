import React, { useEffect, useState } from 'react'
import axios from 'axios';
import formChange from '../../utils/dateForm'

import '../../css/MainComponent.css'

const Attendance = () => {

   // 출석, 지각, 결석 수를 저장할 변수
   const [yNum, setY] = useState(0)
   const [nNum, setN] = useState(0)
   const [tNum, setT] = useState(0)

   useEffect(() => {
      axios
         .post('/teacher/getAttendance', { course_key: window.sessionStorage.getItem('course_key'), today: formChange(new Date().toString().substring(4, 15)) })
         .then((res) => {
            setY(res.data.filter(item => item.att_check === 'y').length)
            setN(res.data.filter(item => item.att_check === 'n').length)
            setT(res.data.filter(item => item.att_check === 't').length)
         })
         .catch((e) => console.log(e));
   }, [])

   return (
      <div className='topDiv'>
         <table className='attTable'>
            <thead>
               <tr>
                  <td colSpan={3}>오늘 출석 현황</td>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td>출석</td>
                  <td>지각</td>
                  <td>결석</td>
               </tr>
               <tr className='attNum'>
                  <td>{yNum}</td>
                  <td>{nNum}</td>
                  <td>{tNum}</td>
               </tr>
            </tbody>
         </table>
      </div>
   )
}

export default Attendance