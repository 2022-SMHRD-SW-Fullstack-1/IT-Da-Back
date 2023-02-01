package or.kr.smhrd.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
   String sche_num;
   String sche_type;
   String sche_date;
   String sche_content;
}
