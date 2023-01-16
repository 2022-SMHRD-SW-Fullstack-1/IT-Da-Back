package or.kr.smhrd.portal.service;

import or.kr.smhrd.portal.domain.Member;
import or.kr.smhrd.portal.mapper.MemberMapper;

import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
    
   private final MemberMapper memberMapper;

   public void register(Map<String, String> data) {
      memberMapper.register(new Member(
         data.get("id"), 
         data.get("pw"), 
         data.get("name"), 
         "s", 
         data.get("bd").replaceAll("-", ""), 
         data.get("tel"), 
         data.get("address"), 
         data.get("gender"), 
         data.get("expire")));
   }

   public Member login(Map<String, String> data) {
      return memberMapper.login(data.get("id"), data.get("pw"));
   }

}
