import React from 'react'
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

import "../css/Footer.css"
import logo from "../asset/img/logo_cwl.png"

const Footer = () => {
  return (
    <div className='footerContainer'>
      <div className='footerInnerDiv'>
        <div className='footerInnerTop'>
          <img src={logo} className='footerLogo' />
          <div className='snsLinkIcon'>
            <a href='https://pf.kakao.com/_VYlpM'><img src='https://smhrd.or.kr/wp-content/themes/bridge-child/img/sns1.png' /></a>
            <a href='https://blog.naver.com/jang0_0yw'><img src='https://smhrd.or.kr/wp-content/themes/bridge-child/img/sns2.png' /></a>
            <a href='https://www.youtube.com/channel/UCubIpLB7cA9tWIUZ26WFKPg'><img src='https://smhrd.or.kr/wp-content/themes/bridge-child/img/sns3.png' /></a>
            <a href='https://www.instagram.com/smhrd0317/'><img src='https://smhrd.or.kr/wp-content/themes/bridge-child/img/sns4.png' /></a>
            <a href='https://www.facebook.com/smhrd0317'><img src='https://smhrd.or.kr/wp-content/themes/bridge-child/img/sns5.png' /></a>
          </div>
        </div>

        <div className='footerInnerBottom'>
          <Row>
            <Col xs={12} lg={6} className='footerInnerBottomL'>

              <Row>
                <Col xs={12} lg={3}>
                  <p>(사)스마트인재개발원</p>
                </Col>
                <Col xs={12} lg={9}>
                  대표자 : 차준섭
                  <br />
                  개인정보책임관리자 : 반수경
                  <br />
                  사업자번호 : 178-82-00065
                  <br />
                  <span className='emphasize'>서울 서초점 : </span>서울시 서초구 동작대로 132 9층
                  <br />
                  <span className='emphasize'>서울 가산점 : </span>서울시 금천구 벚꽃로 254
                  <br />
                  <span className='emphasize'>광주 동구본점 : </span>광주 동구 예술길 31-15 3~4, 7층
                  <br />
                  <span className='emphasize'>광주 남구점 : </span>광주 남구 송암로 60 2층
                  <br />
                  <span className='emphasize'>순천점 : </span>전라남도 순천시 중앙로 260
                  <br />
                  <span className='emphasize'>대표 FAX : </span>062-655-3510
                  <br />
                  <span className='emphasize'>대표 E-Mail : </span>smhrd@smhrd.or.kr
                  <br />
                </Col>
              </Row>

            </Col>
            <Col xs={12} lg={6} className='footerInnerBottomR'>
              <Row>
                <Col xs={12} lg={2}>
                  <p>고객센터</p>
                </Col>
                <Col xs={12} lg={10}>
                  전화상담 : <span className='emphasize'>062-655-3510, 9</span>
                  <br />
                  카카오톡 : <span className='emphasize'>@스마트인재개발원</span>
                  <br />
                  홈페이지 : <span className='emphasize'>상담신청 메뉴 클릭</span>
                  <br />
                  상담시간
                  <br />
                  <span className='emphasize'>전화상담 : </span>09시~19시(월~금)
                  <br />
                  <span className='emphasize'>홈페이지 : </span>09시~22시(연중무휴)
                  <br />
                  <span className='emphasize'>카카오톡 : </span>09시~22시(연중무휴)
                  <br />
                  <span className='emphasize'>*표기된 취업/수료율은 HRD-Net 훈련기관</span>
                  <br />
                  <span className='emphasize'>정보의 2022년도 14개 과정 평균 취업률입니다.</span>

                </Col>
              </Row>
            </Col>
          </Row>
        </div>
      </div>
    </div>
  )
}

export default Footer