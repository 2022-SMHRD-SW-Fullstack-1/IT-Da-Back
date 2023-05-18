package or.kr.smhrd.portal.service;

import or.kr.smhrd.portal.domain.Member;
import or.kr.smhrd.portal.domain.StudentInfo;
import or.kr.smhrd.portal.mapper.MemberMapper;
import or.kr.smhrd.portal.mapper.StudentMapper;

import java.util.List;
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
      studentMapper.createResume(
            data.get("id"),
            data.get("name"),
            data.get("gender").replaceAll("m", "남성").replaceAll("f", "여성"),
            data.get("tel"),
            data.get("bd"),
            data.get("address"));
      studentMapper.createCoverLetter(data.get("id"));
      memberMapper.createStdInfo(data.get("id"));
      return i;
   }

   public Member login(Map<String, String> data) {
      return memberMapper.login(data.get("id"), data.get("pw"));
   }

   public List<StudentInfo> getStudentInfo(Map<String, String> data) {
      return memberMapper.getStudentInfo(data.get("course_key"));
   }

   public StudentInfo getOneStudentInfo(Map<String, String> data) {
      System.out.println(data);
      System.out.println(memberMapper.getOneStudentInfo(data.get("id"), data.get("course_key")));
      return memberMapper.getOneStudentInfo(data.get("id"), data.get("course_key"));
   }

   public void updateStdInfo(List<StudentInfo> data) {
      for (StudentInfo s : data) {
         memberMapper.updateStdInfo(s);
      }
   }

   // 회원정보 수정 전 검사 페이지
   public String memberEditCheck(String mb_id) {
      return memberMapper.memberEditCheck(mb_id);
   }

   // 회원 정보 수정
   public Member memberEdit(String mb_id) {
      return memberMapper.memberEdit(mb_id);
   }

   public void memberEditUpdate(Map<String, String> data) {
      memberMapper.memberEditUpdate(data);
   }

   // 회원 탈퇴
   public void memberWithdrawal(String mb_id) {
      memberMapper.memberWithdrawal(mb_id);
   }

   // 아이디 찾기, 비밀번호 찾기
   public String idInquiry(Map<String, String> data) {
      return memberMapper.idInquiry(data);
   }

   public Member pwInquiry(Map<String, String> data) {
      return memberMapper.pwInquiry(data.get("id"), data.get("name"), data.get("phone"));
   }

}
