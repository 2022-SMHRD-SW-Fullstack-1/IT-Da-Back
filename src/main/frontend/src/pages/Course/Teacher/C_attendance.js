import React, { useEffect, useState } from 'react'
import axios from 'axios';
import Calendar from 'react-calendar';
import moment from 'moment';
import intoKorean from '../../../utils/dateCaculate'
import ageCaculate from '../../../utils/ageCaculate'
import formChange from '../../../utils/dateForm'

const C_attendance = () => {

  // 해당 코스의 출석 정보를 저장할 변수
  const [attInfo, setAttInfo] = useState([])
  // 오늘 날짜
  const today = new Date().toString().substring(0, 10)
  // 클릭한 날짜를 저장할 변수
  const [value, setValue] = useState(new Date());
  console.log(value)
  console.log(attInfo)

  useEffect(() => {
    axios
      .post('/teacher/getAttendance', { course_key: window.sessionStorage.getItem('course_key'), today: formChange(value.toString().substring(4, 15)) })
      .then((res) => setAttInfo(res.data))
      .catch((e) => console.log(e));
  }, [value])

  const onAttChange = (e) => {
    let seq = e.currentTarget.getAttribute('seq')
    const { value } = e.target;
    setAttInfo(attInfo.map((item) => item.seq == seq ? { ...item, att_check: value } : item));
  };

  const attCheck = () => {
    setAttInfo(attInfo.map((item) => true ? { ...item, att_check: 'y' } : item));
  }

  const saveAttCheck = () => {
    axios
      .post('/teacher/setAttendance', { attInfo: attInfo })
      .then((res) => alert('저장 성공'))
      .catch((e) => console.log(e));
  }

  return (
    <div className='container'>
      <p value={value}>{value.toString().substring(0, 10) == today ? '오늘의' : intoKorean(value.toString().substring(4, 10))} 출석체크</p>
      <Calendar onChange={setValue} value={value} calendarType="US" formatDay={(locale, date) => moment(date).format("DD")} showNeighboringMonth={false} />
      <div className='content'>
        <table>
          <thead>
            <tr>
              <td>No.</td>
              <td>이름</td>
              <td>나이</td>
              <td>성별</td>
              <td>출석여부</td>
            </tr>
          </thead>
          <tbody>
            {attInfo.map((item, idx) => <tr key={idx + item.mb_id}>
              <td>{idx + 1}</td>
              <td>{item.mb_name}</td>
              <td>{ageCaculate(item.mb_birthdate.substring(0, 4))}</td>
              <td>{item.mb_gender === 'm' ? '남' : '여'}</td>
              <td><select onChange={onAttChange} seq={item.seq} value={item.att_check}><option value="n">결석</option>
                <option value="y">출석</option><option value="t">지각</option></select></td>
            </tr>)}
          </tbody>
        </table>
        <div className='annWriteButton'>
          <button onClick={attCheck}>모두 출석</button>
          <button onClick={saveAttCheck}>저장</button>
        </div>
      </div>
    </div>
  )
}

export default C_attendance