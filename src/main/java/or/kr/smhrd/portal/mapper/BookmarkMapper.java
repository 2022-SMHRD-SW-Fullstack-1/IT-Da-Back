package or.kr.smhrd.portal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import or.kr.smhrd.portal.domain.Bookmark;
import or.kr.smhrd.portal.domain.Bookmark_company;

@Mapper
public interface BookmarkMapper {

    @Insert("insert into t_bookmark values(default, #{enter_id}, #{mb_id})")
    public void addBookmark(Bookmark bookmark);

    @Select("select mb_id from t_bookmark where enter_id=#{enter_id}")
    public List<String> selectBookmark(String enter_id);

    @Delete("delete from t_bookmark where enter_id=#{enter_id} and mb_id=#{mb_id}")
    public void deleteBookmark(Bookmark bookmark);
    
    @Insert("insert into t_bookmark_company values(default, #{company_num}, #{mb_id})")
    public void addBookmarkCompany(Bookmark_company bookmark_company);

    @Select("select company_num from t_bookmark_company where mb_id=#{mb_id}")
    public List<String> selectBookmarkCompany(String mb_id);

    @Delete("delete from t_bookmark_company where company_num=#{company_num} and mb_id=#{mb_id}")
    public void deleteBookmarkCompany(Bookmark_company bookmark);
}
