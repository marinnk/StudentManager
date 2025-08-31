package raisetech.Student.Manager.controller.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import raisetech.Student.Manager.date.Student;
import raisetech.Student.Manager.date.StudentCourses;
import raisetech.Student.Manager.domain.studentDetail;

@Component
public class StudentConverter {

  public List<studentDetail> convertStudentDetails(List<Student> students,
      List<StudentCourses> studentCourses) {
    List<studentDetail> studentDetails = new ArrayList<>();
    students.forEach(student -> {
      studentDetail studentDetail = new studentDetail();
      studentDetail.setStudent(student);

      List<StudentCourses> convertStudentCourses = new ArrayList<>();
      for (StudentCourses studentCourse : studentCourses) {
        if (student.getId().equals(studentCourse.getStudentId())) {
          convertStudentCourses.add(studentCourse);
        }
      }
      studentDetail.setStudentCourses(convertStudentCourses);
      studentDetails.add(studentDetail);
    });
    return studentDetails;
  }

}
