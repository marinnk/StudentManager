package raisetech.Student.Manager.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import raisetech.Student.Manager.date.Student;
import raisetech.Student.Manager.date.StudentCourses;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentCourses> searchStudentCourse();

  @Insert("INSERT INTO students (name, furigana, nickname, email_address, address, age, gender, remark) VALUES (#{name}, #{furigana}, #{nickname}, #{emailAddress}, #{address}, #{age}, #{gender}, #{remark})")
  void insert(Student student);




}
