package raisetech.Student.Manager.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.Student.Manager.controller.converter.StudentConverter;
import raisetech.Student.Manager.date.Student;
import raisetech.Student.Manager.date.StudentCourses;
import raisetech.Student.Manager.domain.StudentDetail;
import raisetech.Student.Manager.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  //絞り込み検索
  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList() {
    List<Student> students = service.searchStudentList();
    List<StudentCourses> studentCourses = service.searchStudentCouseList();

    return converter.convertStudentDetails(students, studentCourses);
  }


  @GetMapping("/studentCourseList")
  public List<StudentCourses> getStudentCouseList() {
    return service.searchStudentCouseList();
  }

}
