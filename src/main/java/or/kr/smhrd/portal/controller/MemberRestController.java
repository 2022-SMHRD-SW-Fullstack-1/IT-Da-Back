package or.kr.smhrd.portal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import or.kr.smhrd.portal.domain.Alarm;
import or.kr.smhrd.portal.domain.Member;
import or.kr.smhrd.portal.domain.StudentInfo;
import or.kr.smhrd.portal.service.EnterpriseService;
import or.kr.smhrd.portal.service.MemberService;

@RequiredArgsConstructor
@RequestMapping("member")
@RestController
public class MemberRestController {

   private final MemberService memberService;

   @Autowired
   EnterpriseService enterpriseService;

   @PostMapping("/register")
   public int register(@RequestBody Map<String, String> data) {
      return memberService.register(data);
   }

   @PostMapping("/login")
   public Member login(@RequestBody Map<String, String> data) {
      return memberService.login(data);
   }

   @PostMapping("/getStudentInfo")
   public List<StudentInfo> getStudentInfo(@RequestBody Map<String, String> data) {
      return memberService.getStudentInfo(data);
   }

   @PostMapping("/updateStdInfo")
   public void updateStdInfo(@RequestBody Map<String, List<StudentInfo>> data) {
      memberService.updateStdInfo(data.get("stdInfo"));
   }

   @PostMapping("/alarm")
   public void stdAddAlarm(@RequestBody Map<String, String> data) {
      System.out.println("받아온값"+data.get("course_key") + data.get("alarm_content"));
      memberService.stdAddAlarm(data.get("course_key"), data.get("alarm_content"));
   }

}
