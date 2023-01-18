package or.kr.smhrd.portal.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.websocket.Decoder.Binary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
