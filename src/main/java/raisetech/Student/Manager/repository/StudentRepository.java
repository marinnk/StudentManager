package raisetech.Student.Manager.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import raisetech.Student.Manager.date.Student;
import raisetech.Student.Manager.date.StudentCourses;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students_courses")
  List<StudentCourses> searchStudentCourse();

  @Insert("INSERT INTO students (name, furigana, nickname, email_address, address, age, gender, remark) "
      + "VALUES (#{name}, #{furigana}, #{nickname}, #{emailAddress}, #{address}, #{age}, #{gender}, #{remark})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(Student student);

  @Insert("INSERT INTO students_courses (student_id, courses_name, courses_start,  courses_finish)"
      + "VALUES(#{studentId}, #{coursesName}, #{coursesStart}, #{coursesFinish})")
  void registerStudentCourses(StudentCourses studentCourses);



}
