package or.kr.smhrd.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfo {
   private String id;
   private String name;
   private String phone;
   private String gender;
   private String birthdate;
   private String school;
   private String major;
   private String certification;
   private String hope_jop;
   private String hope_city;
   private String example;
   private String division;
   private String special;
   private String address;
}
