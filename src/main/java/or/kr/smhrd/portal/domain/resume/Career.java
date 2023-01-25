package or.kr.smhrd.portal.domain.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Career {
    String cr_num;
    String mb_id;
    String cr_organization;
    String cr_position;
    String cr_s_dt;
    String cr_e_dt;
    String cr_activity;
}
