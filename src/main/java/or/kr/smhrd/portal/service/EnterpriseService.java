package or.kr.smhrd.portal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import or.kr.smhrd.portal.domain.Company;
import or.kr.smhrd.portal.domain.Enterprise;
import or.kr.smhrd.portal.mapper.EnterpriseMapper;

@Service
public class EnterpriseService {

    @Autowired
    EnterpriseMapper enterpriseMapper;

    public void makeEnterprise(Enterprise enterprise) {
        enterpriseMapper.makeEnterprise(enterprise);
    }

    public List<Enterprise> selectAllEnterprise() {
        return enterpriseMapper.selectAllEnterprise();
    }

    public void editEnterprise(Enterprise enterprise) {
        enterpriseMapper.editEnterprise(enterprise);
    }

    public void deleteEnterprise(Enterprise enterprise) {
        enterpriseMapper.deleteEnterprise(enterprise);
    }

    // 기업공고
    public void makeCompany(Company company) {
        enterpriseMapper.makeCompany(company);
    }

    public List<Company> selectCompany() {
        return enterpriseMapper.selectCompany();
    }

    public void editCompany(Company company) {
        enterpriseMapper.editCompany(company);
    }

    public void deleteCompany(Company company) {
        enterpriseMapper.deleteCompany(company);
    }

    // 기업 회원가입
    public void register(Map<String, String> data) {
        enterpriseMapper.register(new Enterprise(
           data.get("id"), 
           data.get("pw"), 
           data.get("enter_name"),
           data.get("manager"),
           data.get("tel"),
           'N'));
     }

     // 기업 로그인
     public Enterprise login(Map<String, String> data) {
        return enterpriseMapper.login(data.get("id"), data.get("pw"));
     }

}
