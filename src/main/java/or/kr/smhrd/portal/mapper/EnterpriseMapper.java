package or.kr.smhrd.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import or.kr.smhrd.portal.domain.Enterprise;

@Mapper
public interface EnterpriseMapper {

    @Insert("insert into t_enterprise values(default, #{enter_name})")
    public void makeEnterprise(Enterprise enterprise);

    @Select("select * from t_enterprise")
    public List<Enterprise> selectAllEnterprise();
}
