package or.kr.smhrd.portal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import or.kr.smhrd.portal.domain.Company;
import or.kr.smhrd.portal.domain.Enterprise;
import or.kr.smhrd.portal.service.EnterpriseService;

@RequestMapping("enterprise")
@RestController
public class EnterpriseRestController {

    @Autowired
    EnterpriseService enterpriseService;

    @PostMapping("/make_enterprise")
    public void makeEnterprise(@RequestBody Enterprise enterprise) {
        enterpriseService.makeEnterprise(enterprise);
    }

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
        enterpriseService.editCompany(company);
    }

    @PostMapping("/delete_company")
    public void delete(@RequestBody Company company) {
        enterpriseService.deleteCompany(company);
    }

    // 기업 회원가입
    @PostMapping("/register")
    public void register(@RequestBody Map<String, String> data) {
        enterpriseService.register(data);
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

    @PostMapping("/approve")
    public void enterApprove(String enter_id) {
        System.out.println(enter_id);
        enterpriseService.enterApprove(enter_id);
    }

}
