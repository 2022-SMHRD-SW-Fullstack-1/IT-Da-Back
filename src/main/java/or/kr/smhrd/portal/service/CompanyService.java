package or.kr.smhrd.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import or.kr.smhrd.portal.mapper.CompanyMapper;

@Service
public class CompanyService {

    @Autowired
    CompanyMapper companyMapper;
    
}
