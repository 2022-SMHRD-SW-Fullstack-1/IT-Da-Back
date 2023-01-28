package or.kr.smhrd.portal.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enterprise {
    String enter_id;
    String enter_pw;
    String enter_name;
    String enter_manager;
    String enter_tel;
    char enter_approve;
    String enter_address;
    String enter_num;
}
