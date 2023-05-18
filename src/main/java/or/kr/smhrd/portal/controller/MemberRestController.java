package or.kr.smhrd.portal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.domain.Member;
import or.kr.smhrd.portal.domain.StudentInfo;
import or.kr.smhrd.portal.service.EnterpriseService;
import or.kr.smhrd.portal.service.MemberService;

@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberRestController {

   private final MemberService memberService;

   @Autowired
   EnterpriseService enterpriseService;

   @PostMapping("/register")
   public int register(@RequestBody Map<String, String> data) {
      System.out.println("받아온 값 : " + data);
      return memberService.register(data);
   }

   // 선생님 승인
   @GetMapping("/t_approve_list")
   public List<Map<String, String>> t_approve_list() {
      return memberService.t_approve_list();
   }

   @PostMapping("/t_approve")
   public void t_approve(@RequestBody Map<String, String> data) {
      System.out.println("받아온 값 : " + data.get("mb_id"));
      memberService.t_approve(data.get("mb_id"));
   }

   @PostMapping("/t_approve_cancel")
   public void t_approve_cancel(@RequestBody Map<String, String> data){
      System.out.println("받아온 값 : " + data.get("mb_id"));
      memberService.t_approve_cancel(data.get("mb_id"));
   }

   @PostMapping("/login")
   public Member login(@RequestBody Map<String, String> data) {
      return memberService.login(data);
   }

   @PostMapping("/getStudentInfo")
   public List<StudentInfo> getStudentInfo(@RequestBody Map<String, String> data) {
      return memberService.getStudentInfo(data);
   }

   @PostMapping("/getOneStudentInfo")
   public StudentInfo getOneStudentInfo(@RequestBody Map<String, String> data) {
      return memberService.getOneStudentInfo(data);
   }

   @PostMapping("/updateStdInfo")
   public void updateStdInfo(@RequestBody Map<String, List<StudentInfo>> data) {
      memberService.updateStdInfo(data.get("stdInfo"));
   }

   // 마이페이지 보안체크
   @GetMapping("/memberEditCheck")
   public String memberEditCheck(@RequestParam Map<String, String> data) {
      System.out.println(data);
      String pw = data.get("mb_pw");
      String db_pw = memberService.memberEditCheck(data.get("mb_id"));

      if (pw.equals(db_pw)) {
         return "success";
      } else {
         return "fail";
      }
   }

   // 회원 정보 수정
   @GetMapping("/memberEdit")
   public Member memberEdit(@RequestParam Map<String, String> data) {
      System.out.println(data);
      return memberService.memberEdit(data.get("mb_id"));
   }

   @PostMapping("/memberEditUpdate")
   public void memberEditUpdate(@RequestBody Map<String, String> data) {
      System.out.println(data);
      memberService.memberEditUpdate(data);
   }

}
