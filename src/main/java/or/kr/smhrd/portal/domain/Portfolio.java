package or.kr.smhrd.portal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {
    String portfolio_num;
    String mb_id;
    String portfolio_title;
    String portfolio_period;
    String portfolio_etc;
    String portfolio_img1;
    String portfolio_img2;
    String portfolio_img3;
    String portfolio_content;
    String portfolio_stack_front;
    String portfolio_stack_back;
    String portfolio_stack_db;
    String portfolio_url;
    String portfolio_file;
    String portfolio_dt;
}