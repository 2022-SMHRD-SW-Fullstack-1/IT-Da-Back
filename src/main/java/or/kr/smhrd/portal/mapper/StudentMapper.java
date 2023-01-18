package or.kr.smhrd.portal.mapper;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import or.kr.smhrd.portal.domain.resume.Career;
import or.kr.smhrd.portal.domain.resume.Certification;
import or.kr.smhrd.portal.domain.resume.Graduation;
import or.kr.smhrd.portal.domain.resume.Military;
import or.kr.smhrd.portal.domain.resume.Prize;
import or.kr.smhrd.portal.domain.resume.Resume;

@Mapper
public interface StudentMapper {

    // 학생 전체 이력서 조회
    @Select("select * from t_resume")
    List<Resume> selectAllResume();

    @Select("select * from t_graduation")
    List<Graduation> selectAllGraduation();

    @Select("select * from t_career")
    List<Career> selectAllCareer();

    @Select("select * from t_certification")
    List<Certification> selectAllCertification();

    @Select("select * from t_prize")
    List<Prize> selectAllPrize();

    @Select("select * from t_military")
    List<Military> selectAllMilitary();

    // 특정 학생 이력서 조회
    @Select("select * from t_resume where mb_id = #{id}")
    Resume selectResume(String id);

    @Select("select * from t_graduation where mb_id = #{id}")
    List<Graduation> selectGraduation(String id);

    @Select("select * from t_career where mb_id = #{id}")
    List<Career> selectCareer(String id);

    @Select("select * from t_certification where mb_id = #{id}")
    List<Certification> selectCertification(String id);

    @Select("select * from t_prize where mb_id = #{id}")
    List<Prize> selectPrize(String id);

    @Select("select * from t_military where mb_id = #{id}")
    List<Military> selectMilitary(String id);


    // 초기 이력서, 자소서 입력하기 */
    // 모든 이력서는 단방향으로 저장(초기 화면 select-> delete&insert) 
    // 이력서 수정
    @Update("update t_resume set name=#{resume.name}, gender=#{resume.gender}, birthday=#{resume.birthday}, major=#{resume.major}, phone=#{resume.phone}, email=#{resume.email}, addr=#{resume.addr}, skills=#{resume.skills}, wish_field=#{resume.wish_field}, wish_salary=#{resume.wish_salary}, wish_area1=#{resume.wish_area1}, wish_area2=#{resume.wish_area2}, wish_area3=#{resume.wish_area3} where mb_id=#{id}")
    void updateResume(Object resume, String id);
    // 교육
    @Delete("delete from t_graduation where mb_id =#{id}")
    public void deleteGraduation(String id);
    @Insert("insert into t_graduation values(default, #{id}, #{graduation.grad_school}, #{graduation.school_type}, #{graduation.grad_dt}, #{graduation.grad_type}, #{graduation.grad_score})")
    public void insertGraduation(Object graduation, String id);

    // 경력
    @Delete("delete from t_career where mb_id =#{id}")
    public void deleteCareer(String id);
    @Insert("insert into t_career values(default, #{id}, #{career.cr_organization}, #{career.cr_position}, #{career.cr_s_dt}, #{career.cr_e_dt}, #{career.cr_activity})")
    public void insertCareer(Object career, String id);

    // 자격증
    @Delete("delete from t_certification where mb_id =#{id}")
    public void deleteCertification(String id);
    @Insert("insert into t_certification values(default, #{id}, #{certification.cert_org}, #{certification.cert_name}, #{certification.cert_dt})")
    public void insertCertification(Object certification, String id);

    // 수상
    @Delete("delete from t_prize where mb_id =#{id}")
    public void deletePrize(String id);
    @Insert("insert into t_prize values(default, #{id}, #{prize.prize_org}, #{prize.prize_name}, #{prize.prize_dt})")
    public void insertPrize(Object prize, String id);

    // 병역
    @Delete("delete from t_military where mb_id =#{id}")
    public void deleteMilitary(String id);
    @Insert("insert into t_military values(default, #{id}, #{military.mili_title}, #{military.mili_army}, #{military.mili_s_dt}, #{military.mili_e_dt}, #{military.veteran_yn})")
    public void insertMilitary(Object military, String id);

    //업데이트 날짜 수정
    @Update("update t_member set mb_update=now() where mb_id=#{id}")
    public void updateUpdate(String id);

}
