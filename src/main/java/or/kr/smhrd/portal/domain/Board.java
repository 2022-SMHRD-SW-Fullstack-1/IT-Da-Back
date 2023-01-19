package or.kr.smhrd.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Board {
   private String b_num;
   private String b_title;
   private String b_content;
   private String b_file;
   private String b_dt;
   private String mb_id;
}
