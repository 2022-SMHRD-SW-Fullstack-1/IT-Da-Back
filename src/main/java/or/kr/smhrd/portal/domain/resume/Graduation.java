package or.kr.smhrd.portal.domain.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Graduation {
    String mb_id;
    String grad_school;
    String school_type;
    String grad_dt;
    String grad_type;
    float grad_score;
}
