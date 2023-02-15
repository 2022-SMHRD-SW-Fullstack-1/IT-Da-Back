package or.kr.smhrd.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Alarm {
    int alarm_num;
    String mb_id_to;
    String alarm_content;
    String alarm_check;
    String alarm_dt;
}
