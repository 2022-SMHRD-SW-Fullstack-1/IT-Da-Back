package or.kr.smhrd.portal.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import or.kr.smhrd.portal.domain.Member;

@Mapper
public interface MemberMapper {
    
   @Insert("insert into t_member values(#{mb_id}, #{mb_pw}, #{mb_name}, 's', #{mb_birthdate}, #{mb_phone}, #{mb_addr}, #{mb_gender}, #{mb_expire_dt}, UNHEX(concat(#{course_key},'000000000000000000000000')), now())")
   public void register(Member member);

   @Select("select mb_id, mb_pw, mb_name, mb_job, mb_birthdate, mb_phone, mb_addr, mb_gender, mb_expire_dt, LEFT(HEX(course_key),8) as course_key from t_member where mb_id = #{id} and mb_pw = #{pw}")
   public Member login(String id, String pw);
}
