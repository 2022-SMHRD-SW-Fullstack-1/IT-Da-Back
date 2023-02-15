package or.kr.smhrd.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    String mb_id;
    String name;
    String gender;
    String birthday;
    String phone;
    String addr;
    String skills;
    String wish_area1;
    String wish_area2;
    String wish_area3;
    String is_bookmark;
}
