package or.kr.smhrd.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import or.kr.smhrd.portal.domain.Company;
import or.kr.smhrd.portal.domain.Enterprise;

@Mapper
public interface EnterpriseMapper {

    @Insert("insert into t_enterprise values(default, #{enter_name})")
    public void makeEnterprise(Enterprise enterprise);

    @Select("select * from t_enterprise")
    public List<Enterprise> selectAllEnterprise();

    @Update("update t_enterprise set enter_pw=#{enter_pw}, enter_manager=#{enter_manager}, enter_tel=#{enter_tel} where enter_id= #{enter_id}")
    public void editEnterprise(Enterprise enterprise);

    @Delete("delete from t_enterprise where enter_id=#{enter_id}")
    public void deleteEnterprise(Enterprise enterprise);

    // 기업공고 생성
    @Insert("insert into t_company value(default, #{company_name}, #{company_deadline}, #{company_area}, #{company_employ}, #{company_grade}, #{company_position}, #{company_qual}, #{company_essential}, #{company_advantage}, #{company_etc}, #{company_salary}, #{company_apply})")
    public void makeCompany(Company company);

    @Select("select * from t_company order by company_deadline")
    public List<Company> selectCompany();

    @Update("update t_company set company_deadline=#{company_deadline}, company_area=#{company_area}, company_employ=#{company_employ}, company_grade=#{company_grade}, company_position=#{company_position}, company_qual=#{company_qual}, company_essential=#{company_essential}, company_advantage=#{company_advantage}, company_etc=#{company_etc}, company_salary=#{company_salary}, company_apply=#{company_apply} where company_name=#{company_name}")
    public void editCompany(Company company);

    @Delete("delete from t_company where company_name=#{company_name}")
    public void deleteCompany(Company company);

    // 기업 회원가입
    @Insert("insert into t_enterprise value(#{enter_id}, #{enter_pw}, #{enter_name}, #{enter_manager}, #{enter_tel}, 'N')")
    public void register(Enterprise enterprise);

    // 기업 로그인
    @Select("select * from t_enterprise where enter_id = #{id} and enter_pw = #{pw}")
    public Enterprise login(String id, String pw);

    // 위젯 기업리스트
    @Select("select enter_name, enter_id from t_enterprise where enter_approve='N'")
    public List<Enterprise> enterApproveList(String enter_name, String enter_id);

    @Update("update t_enterprise set enter_approve='Y' where enter_id=#{enter_id}")
    public void enterApprove(String enter_id);
}
