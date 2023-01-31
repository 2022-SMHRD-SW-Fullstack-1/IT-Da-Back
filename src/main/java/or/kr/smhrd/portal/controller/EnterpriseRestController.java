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

    @GetMapping("/select_enterprise")
    public List<Enterprise> selectAllEnterprise() {
        return enterpriseService.selectAllEnterprise();
    }

    @PostMapping("/edit_enterprise")
    public void editEnterprise(@RequestBody Enterprise enterprise) {
        enterpriseService.editEnterprise(enterprise);
    }

    @PostMapping("/delete_enterprise")
    public void deleteEnterprise(@RequestBody Enterprise enterprise) {
        enterpriseService.deleteEnterprise(enterprise);
    }

    // 기업공고
    @PostMapping("/make_company")
    public void makeCompany(@RequestBody Company company) {
        enterpriseService.makeCompany(company);
    }

    @GetMapping("/select_company")
    public List<Company> selectCompany() {
        return enterpriseService.selectCompany();
    }

    @PostMapping("/edit_company")
    public void editCompany(@RequestBody Company company) {
        System.out.println(company);
        enterpriseService.editCompany(company);
    }

    @PostMapping("/delete_company")
    public void delete(@RequestBody Company company) {
        enterpriseService.deleteCompany(company);
    }

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

    // 기업승인
    @GetMapping("/approve_list")
    public List<Enterprise> enterApproveList(String enter_name, String enter_id) {
        return enterpriseService.enterApproveList(enter_name, enter_id);
    }

    @GetMapping("/approve")
    public void enterApprove(@RequestParam String enter_id) {
        enterpriseService.enterApprove(enter_id);
    }

}
