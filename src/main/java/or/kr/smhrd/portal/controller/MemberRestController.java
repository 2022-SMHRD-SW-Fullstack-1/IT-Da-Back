package or.kr.smhrd.portal.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.domain.Member;
import or.kr.smhrd.portal.service.MemberService;

@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberRestController {

   private final MemberService memberService;
    
   @PostMapping("/register")
   public void register(@RequestBody Map<String, String> data) {
      memberService.register(data);
   }

   @PostMapping("/login")
   public Member login(@RequestBody Map<String, String> data) {
      return memberService.login(data);
   }
}
