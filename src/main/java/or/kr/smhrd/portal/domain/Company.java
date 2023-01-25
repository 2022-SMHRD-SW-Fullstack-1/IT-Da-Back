package or.kr.smhrd.portal.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    String company_register_date;
    String company_name;
    String company_deadline;
    String company_area;
    String company_employ;
    String company_grade;
    String company_position;
    String company_advantage;
    String company_salary;
    String company_require;
    String company_etc;
}
