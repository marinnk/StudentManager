package raisetech.Student.Manager.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import raisetech.Student.Manager.date.Student;
import raisetech.Student.Manager.date.StudentCourses;

@Getter
@Setter
public class studentDetail {

  private Student student;
  private List<StudentCourses> studentCourses;

}
