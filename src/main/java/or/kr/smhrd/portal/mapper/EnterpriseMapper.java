package or.kr.smhrd.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import or.kr.smhrd.portal.domain.Enterprise;

@Mapper
public interface EnterpriseMapper {

    @Insert("insert into t_enterprise values(default, #{enter_name})")
    public void makeEnterprise(Enterprise enterprise);

    @Select("select enter_name, LEFT(HEX(enter_num),8) as enter_num from t_enterprise")
    public List<Enterprise> selectAllEnterprise();

    @Update("update t_enterprise set enter_name=#{enter_name} where enter_num= UNHEX(concat(#{enter_num},'000000000000000000000000'))")
    public void editEnterprise(Enterprise enterprise);

    @Delete("delete from t_enterprise where enter_num= UNHEX(concat(#{enter_num},'000000000000000000000000'))")
    public void deleteEnterprise(Enterprise enterprise);
}
