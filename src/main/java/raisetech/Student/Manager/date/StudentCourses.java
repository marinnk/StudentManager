package raisetech.Student.Manager.date;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourses {

  private String id;
  private String studentId;
  private String coursesName;
  private LocalDateTime coursesStart;
  private LocalDateTime coursesFinish;
}
