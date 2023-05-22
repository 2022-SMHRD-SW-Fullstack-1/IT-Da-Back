import React from 'react'
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

import "../css/Footer.css"
import logo from "../asset/img/logo_cwl.png"

import contents from "../asset/list/FooterContents"

const Footer = () => {

  /**기업명 */
  const companyTitle = contents.companyTitle;
  /**기업관련 내용 */
  const companyContents = contents.companyContents;
  /**고객센터 */
  const helpTitle = contents.helpTitle;
  /**고객센터 관련 내용 */
  const helpContents = contents.helpContents;
  /**추가적인 내용 */
  const additionalInformation = contents.additionalInformation;
  
  return (
    <div className='footerContainer'>
      <div className='footerInnerDiv'>
        <div className='footerInnerTop'>
          <img src={logo} className='footerLogo' />
          {/* <div className='snsLinkIcon'>
            <a href='https://pf.kakao.com/_VYlpM'><img src='https://smhrd.or.kr/wp-content/themes/bridge-child/img/sns1.png' /></a>
            <a href='https://blog.naver.com/jang0_0yw'><img src='https://smhrd.or.kr/wp-content/themes/bridge-child/img/sns2.png' /></a>
            <a href='https://www.youtube.com/channel/UCubIpLB7cA9tWIUZ26WFKPg'><img src='https://smhrd.or.kr/wp-content/themes/bridge-child/img/sns3.png' /></a>
            <a href='https://www.instagram.com/smhrd0317/'><img src='https://smhrd.or.kr/wp-content/themes/bridge-child/img/sns4.png' /></a>
            <a href='https://www.facebook.com/smhrd0317'><img src='https://smhrd.or.kr/wp-content/themes/bridge-child/img/sns5.png' /></a>
          </div> */}
        </div>

        <div className='footerInnerBottom'>
          <Row>
            <Col xs={12} lg={6} className='footerInnerBottomL'>

              <Row>
                <Col xs={12} lg={3}>
                  <p>{companyTitle}</p>
                </Col>
                <Col xs={12} lg={9}>
                  {companyContents.map((item)=>(
                    <div>
                      <span className='emphasize'>{item.title} </span>{item.contents}
                    </div>
                  ))}
                </Col>
              </Row>

            </Col>
            <Col xs={12} lg={6} className='footerInnerBottomR'>
              <Row>
                <Col xs={12} lg={2}>
                  <p>{helpTitle}</p>
                </Col>
                <Col xs={12} lg={10}>
                  {helpContents.map((item)=>(
                    <div key={item.title}>
                      <span className='emphasize'>{item.title} </span>{item.contents}
                    </div>
                  ))}
                  <span className='emphasize'>{additionalInformation}</span>
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