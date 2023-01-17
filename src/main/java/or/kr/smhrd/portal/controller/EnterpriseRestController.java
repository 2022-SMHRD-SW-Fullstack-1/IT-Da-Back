package or.kr.smhrd.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import or.kr.smhrd.portal.domain.Enterprise;
import or.kr.smhrd.portal.service.EnterpriseService;

@RequestMapping("/")
@RestController
public class EnterpriseRestController {

    @Autowired
    EnterpriseService enterpriseService;

    @PostMapping("/make_enterprise")
    public void makeEnterprise(@RequestBody Enterprise enterprise) {
        enterpriseService.makeEnterprise(enterprise);
    }

    @GetMapping("/select_all_enterprise")
    public List<Enterprise> selectAllEnterprise() {
        return enterpriseService.selectAllEnterprise();
    }

}
