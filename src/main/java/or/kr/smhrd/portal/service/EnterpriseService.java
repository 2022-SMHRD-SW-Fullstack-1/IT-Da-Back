package or.kr.smhrd.portal.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import or.kr.smhrd.portal.domain.Alarm;
import or.kr.smhrd.portal.domain.Company;
import or.kr.smhrd.portal.domain.Enterprise;
import or.kr.smhrd.portal.mapper.EnterpriseMapper;

@Service
public class EnterpriseService {

    @Autowired
    EnterpriseMapper enterpriseMapper;

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

    public List<Map<String, Object>> selectCompany() {
        return enterpriseMapper.selectCompany();
    }

    public void editCompany(Company company) {
        enterpriseMapper.editCompany(company);
    }

    public void deleteCompany(Company company) {
        enterpriseMapper.deleteCompany(company);
    }

    public List<Company> selectOneCompany(String company_name) {
        return enterpriseMapper.selectOneCompany(company_name);
    }

    // 기업 회원가입
    public void register(Enterprise enterprise) {
        enterpriseMapper.register(enterprise);
    }

    // 기업 로그인
    public Enterprise login(Map<String, String> data) {
        return enterpriseMapper.login(data.get("id"), data.get("pw"));
    }

    // 기업 승인
    public List<Enterprise> enterApproveList(String enter_name, String enter_id) {
        return enterpriseMapper.enterApproveList(enter_name, enter_id);
    }

    public void enterApprove(String enter_id) {
        enterpriseMapper.enterApprove(enter_id);
    }

   

}
