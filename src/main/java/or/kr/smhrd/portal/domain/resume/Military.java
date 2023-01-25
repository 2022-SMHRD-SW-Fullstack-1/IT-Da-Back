package or.kr.smhrd.portal.domain.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Military {
    String mili_num;
    String mb_id;
    String mili_title;
    String mili_army;
    String mili_s_dt;
    String mili_e_dt;
    String veteran_yn;
}
