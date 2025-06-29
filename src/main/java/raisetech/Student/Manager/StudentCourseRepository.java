package raisetech.Student.Manager;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@Mapper
public interface StudentCourseRepository {

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> search();
}
