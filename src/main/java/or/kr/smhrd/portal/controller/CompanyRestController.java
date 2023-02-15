package or.kr.smhrd.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.domain.Company;
import or.kr.smhrd.portal.service.CompanyService;
import or.kr.smhrd.portal.service.MemberService;
import or.kr.smhrd.portal.service.StudentService;

@RequiredArgsConstructor
@RequestMapping("company")
@RestController

public class CompanyRestController {

@Autowired
CompanyService companyservice;

private final StudentService studentService;
private final MemberService memberService;






    
    
}
