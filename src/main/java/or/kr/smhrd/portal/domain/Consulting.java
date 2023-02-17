package or.kr.smhrd.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulting {
    int seq;
    String teacher;
    String student;
    String title;
    String content;
    String date;
}
