package raisetech.Student.Manager.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import raisetech.Student.Manager.controller.converter.StudentConverter;
import raisetech.Student.Manager.date.Student;
import raisetech.Student.Manager.date.StudentCourses;
import raisetech.Student.Manager.domain.StudentDetail;
import raisetech.Student.Manager.service.StudentService;

@Controller
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
  public String getStudentList(Model model) {
    List<Student> students = service.searchStudentList();
    List<StudentCourses> studentCourses = service.searchStudentCouseList();

    model.addAttribute("studentList", converter.convertStudentDetails(students, studentCourses));
    return "studentList";
  }


  @GetMapping("/studentCourseList")
  public List<StudentCourses> getStudentCouseList() {
    return service.searchStudentCouseList();
  }

  @GetMapping("/newStudent")
  public String newStudent(Model model) {
    model.addAttribute("studentDetail", new StudentDetail());
    return "registerStudent";
  }

  @PostMapping("/registerStudent")
  public String registerStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result) {
    if(result.hasErrors()) {
      return "registerStudent";
    }

    //新規受講生情報を登録する処理を実装
    //コース情報も一緒に登録できるよう実装。コースは単体で良い。
    service.registerStudent(studentDetail);
    return "redirect:/studentList";
  }
}
