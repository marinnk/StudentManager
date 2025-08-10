package raisetech.Student.Manager.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.Student.Manager.date.Student;
import raisetech.Student.Manager.date.StudentCourses;
import raisetech.Student.Manager.domain.StudentDetail;
import raisetech.Student.Manager.repository.StudentRepository;

@Service
public class StudentService {

  private StudentRepository repository;

  @Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  public List<Student> searchStudentList() {
    return repository.search();
  }

  public void registerStudent(StudentDetail studentDetail) {
    Student student = studentDetail.getStudent();
    student.setId(UUID.randomUUID().toString());
    student.setDelete(false);
    repository.insert(student);

  }

  public List<StudentCourses> searchStudentCouseList() {
    return repository.searchStudentCourse().stream()
        .filter(studentCourse -> studentCourse.getCoursesName().equals("java"))
        .toList();
  }


}
