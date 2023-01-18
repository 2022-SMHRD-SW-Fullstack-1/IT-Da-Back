package or.kr.smhrd.portal.domain;

import javax.websocket.Encoder.Binary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    String course_key;
    String course_subject;
    String course_name;
    String course_campus;
    String course_s_dt;
    String course_e_dt;
    String course_teacher;
    String course_limit;
}
