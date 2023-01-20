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
        System.out.println(enterpriseService.selectAllEnterprise());
        return enterpriseService.selectAllEnterprise();
    }

    @PostMapping("/edit_enterprise")
    public void editEnterprise(@RequestBody Enterprise enterprise) {
        System.out.println("컨트롤러로 넘어온 값" + enterprise);
        enterpriseService.editEnterprise(enterprise);
    }

    @PostMapping("/delete_enterprise")
    public void deleteEnterprise(@RequestBody Enterprise enterprise) {
        enterpriseService.deleteEnterprise(enterprise);
    }

}
