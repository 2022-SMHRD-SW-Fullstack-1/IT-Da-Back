package or.kr.smhrd.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Member {
    private String mb_id;
    private String mb_pw;
    private String mb_name;
    private String mb_job;
    private String mb_birthdate;
    private String mb_phone;
    private String mb_addr;
    private String mb_gender;
    // private String mb_expire_dt;
    private String course_key;
}
