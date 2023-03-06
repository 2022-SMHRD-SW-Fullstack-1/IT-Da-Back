package or.kr.smhrd.portal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FileMapper {

    @Update("update t_resume set photo=#{path} where mb_id=#{id}")
    public void uploadResume(String id, String path);
    @Update("update t_resume set photo=#{''} where photo=#{photo}")
    public void deleteResume(String id, String path);

    @Update("update t_portfolio set portfolio_img#{idx}=#{path} where portfolio_img#{idx}=#{path}")
    public void uploadPortfolio(String id, String path, String idx);
    @Update("update t_portfolio set portfolio_img#{idx}=#{''} where portfolio_img#{idx}=#{path}")
    public void deletePortfolio(String id, String path);

    @Update("update t_board set b_file=#{path} where where b_num = UNHEX(concat(#{num},'000000000000000000000000'))")
    public void uploadBoard(String id, String path, String num);
    @Update("update t_board set b_file=#{''} b_file=#{path}")
    public void deleteBoard(String id, String path);
}
