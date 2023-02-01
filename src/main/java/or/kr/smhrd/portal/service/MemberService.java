package or.kr.smhrd.portal.service;

import or.kr.smhrd.portal.domain.Member;
import or.kr.smhrd.portal.mapper.MemberMapper;
import or.kr.smhrd.portal.mapper.StudentMapper;

import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
    
   private final MemberMapper memberMapper;
   private final StudentMapper studentMapper;

   public int register(Map<String, String> data) {
      int i = memberMapper.register(new Member(
         data.get("id"), 
         data.get("pw"), 
         data.get("name"), 
         "s", 
         data.get("bd").replaceAll("-", ""), 
         data.get("tel"), 
         data.get("address"), 
         data.get("gender"), 
         data.get("expire"),
         data.get("key")));
      studentMapper.createResume(data.get("id"));
      studentMapper.createCoverLetter(data.get("id"));
      return i;
   }

   public Member login(Map<String, String> data) {
      return memberMapper.login(data.get("id"), data.get("pw"));
   }

}
