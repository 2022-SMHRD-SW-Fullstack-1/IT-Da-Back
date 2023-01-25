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

    // 기업키 생성

    @Insert("insert into t_enterprise values(default, #{enter_name})")
    public void makeEnterprise(Enterprise enterprise);

    @Select("select enter_name, LEFT(HEX(enter_num),8) as enter_num from t_enterprise")
    public List<Enterprise> selectAllEnterprise();

    @Update("update t_enterprise set enter_name=#{enter_name} where enter_num= UNHEX(concat(#{enter_num},'000000000000000000000000'))")
    public void editEnterprise(Enterprise enterprise);

    @Delete("delete from t_enterprise where enter_num= UNHEX(concat(#{enter_num},'000000000000000000000000'))")
    public void deleteEnterprise(Enterprise enterprise);

    // 기업공고 생성
    @Insert("insert into t_company value(default, #{company_name}, #{company_deadline}, #{company_area}, #{company_employ}, #{company_grade}, #{company_position}, #{company_qual}, #{company_essential}, #{company_advantage}, #{company_etc}, #{company_salary}, #{company_apply})")
    public void makeCompany(Company company);

    @Select("select * from t_company")
    public List<Company> selectCompany();

    @Update("update t_company set company_deadline=#{company_deadline}, company_area=#{company_area}, company_employ=#{company_employ}, company_grade=#{company_grade}, company_position=#{company_position}, company_qual=#{company_qual}, company_essential=#{company_essential}, company_advantage=#{company_advantage}, company_etc=#{company_etc}, company_salary=#{company_salary}, company_apply=#{company_apply} where company_name=#{company_name}")
    public void editCompany(Company company);

    @Delete("delete from t_company where company_name=#{company_name}")
    public void deleteCompany(Company company);
}
