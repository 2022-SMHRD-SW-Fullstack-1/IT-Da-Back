package or.kr.smhrd.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
   String b_num;
   String b_title;
   String b_content;
   String b_file;
   String b_dt;
   String mb_id;
}
