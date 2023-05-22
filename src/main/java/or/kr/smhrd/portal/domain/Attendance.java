package or.kr.smhrd.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Attendance {
    int seq;
    String mb_id;
    String mb_name;
    String mb_birthdate;
    String mb_gender;
    String att_check;
}