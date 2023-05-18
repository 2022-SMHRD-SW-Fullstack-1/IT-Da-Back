import React, { useEffect, useState } from "react";
import axios from "axios";

import "../../../css/M_main.css";

const M_t_approve = () => {
  const [tapprove, setTapprove] = useState([]);

  useEffect(() => {
    axios
      .get("/member/t_approve_list")
      .then(function (res) {
        console.log(res.data);
        setTapprove(res.data);
      })
      .catch(function (error) {
        console.log("error");
      });
  }, []);

  const teacher_approve_submit = (e) => {
    e.preventDefault();
    console.log(e.currentTarget.getAttribute("mb_id"));
    axios
      .post("/member/t_approve", {
        params: {
          mb_id: e.currentTarget.getAttribute("mb_id"),
        },
      })
      .then(function (res) {
        window.location.reload();
      })
      .catch(function (error) {
        console.log("error");
      });
  };

  const teacher_approve_cancel = (e) => {
    e.preventDefault();
    console.log(e.currentTarget.getAttribute("mb_id"));
    axios
      .post("/member/t_approve", {
        params: {
          mb_id: e.currentTarget.getAttribute("mb_id"),
        },
      })
      .then(function (res) {
        window.location.reload();
      })
      .catch(function (error) {
        console.log("error");
      });
  };

  const approveList = tapprove.map((item) => (
    <tr key={item.mb_id}>
      <td className="annItem_manager">{item.mb_name}</td>
      <td className="annItem_manager">{item.mb_id}</td>
      <td className="annItem_manager">
        <button
          mb_id={item.mb_id}
          onClick={teacher_approve_submit}
          className="btbtbtbt"
        >
          승인
        </button>
        <button
          mb_id={item.mb_id}
          onClick={teacher_approve_cancel}
          className="btbtbtbt"
        >
          승인
        </button>
      </td>
    </tr>
  ));

  return (
    <div className="topDiv" style={{ minHeight: "12rem" }}>
      <div className="annHead">
        <p>연구원 승인</p>
      </div>
      <div className="annBody_manager">
        <table className="attTable_manager">
          <thead>
            <tr>
              <td className="annItem_manager">연구원</td>
              <td className="annItem_manager">아이디</td>
              <td className="annItem_manager"></td>
            </tr>
          </thead>
          <tbody>{approveList}</tbody>
        </table>
      </div>
    </div>
  );
};

export default M_t_approve;
