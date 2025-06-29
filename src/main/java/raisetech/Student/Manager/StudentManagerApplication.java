package raisetech.Student.Manager;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagerApplication {

	@Autowired
	private StudentRepository repository;

	@Autowired
	private StudentCourseRepository studentCourseRepository;



	public static void main(String[] args) {
		SpringApplication.run(StudentManagerApplication.class, args);
	}

	//登録されたデータを表示する
	@GetMapping("/studentList")
	public List<Student> getStudentList() {
		return repository.search();
	}

	@GetMapping("/studentCourseList")
	public List<StudentCourse> getStudentCouseList() {
		return studentCourseRepository.search();
	}
}
