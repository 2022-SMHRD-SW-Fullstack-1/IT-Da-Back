package or.kr.smhrd.portal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import or.kr.smhrd.portal.domain.Company;
import or.kr.smhrd.portal.domain.Enterprise;
import or.kr.smhrd.portal.service.EnterpriseService;

@RequestMapping("enterprise")
@RestController
public class EnterpriseRestController {

    @Autowired
    EnterpriseService enterpriseService;

    // 기업 리스트 가져오기
    @GetMapping("/select_enterprise")
    public List<Enterprise> selectAllEnterprise() {
        return enterpriseService.selectAllEnterprise();
    }

    // 기업정보 수정
    @PostMapping("/edit_enterprise")
    public void editEnterprise(@RequestBody Enterprise enterprise) {
        enterpriseService.editEnterprise(enterprise);
    }

    // 기업 삭제
    @PostMapping("/delete_enterprise")
    public void deleteEnterprise(@RequestBody Enterprise enterprise) {
        enterpriseService.deleteEnterprise(enterprise);
    }

    // 기업공고 만들기
    @PostMapping("/make_company")
    public void makeCompany(@RequestBody Company company) {
        enterpriseService.makeCompany(company);
    }

    // 공고 리스트 불러오기
    @GetMapping("/select_company")
    public List<Map<String,Object>> selectCompany() {
        return enterpriseService.selectCompany();
    }

    // 기업공고 수정
    @PostMapping("/edit_company")
    public void editCompany(@RequestBody Company company) {
        System.out.println(company);
        enterpriseService.editCompany(company);
    }

    // 공고 삭제
    @PostMapping("/delete_company")
    public void delete(@RequestBody Company company) {
        enterpriseService.deleteCompany(company);
    }

    // 해당 기업 공고 가져오기
    @GetMapping("/select_one_company")
    public List<Company> selectOneCompany(@RequestParam String company_name) {
        return enterpriseService.selectOneCompany(company_name);
    }

    // 기업 회원가입
    @PostMapping("/register")
    public void register(@RequestBody Enterprise enterprise) {
        enterpriseService.register(enterprise);
    }

    // 기업 로그인
    @PostMapping("/login")
    public Enterprise login(@RequestBody Map<String, String> data) {
        return enterpriseService.login(data);
    }

    // 기업 승인
    @GetMapping("/approve_list")
    public List<Enterprise> enterApproveList(String enter_name, String enter_id) {
        return enterpriseService.enterApproveList(enter_name, enter_id);
    }

    // 기업 승인 받기
    @GetMapping("/approve")
    public void enterApprove(@RequestParam String enter_id) {
        enterpriseService.enterApprove(enter_id);
    }

  

}
