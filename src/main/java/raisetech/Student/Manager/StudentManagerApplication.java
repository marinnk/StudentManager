package raisetech.Student.Manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagerApplication {

	@Autowired
	private StudentRepository repository;

	private String name = "Enami Kouji";
	private int age = 37;



	public static void main(String[] args) {
		SpringApplication.run(StudentManagerApplication.class, args);
	}

	//登録されたデータを表示する
	@GetMapping("/student")
	public String getStudent(@RequestParam String name) {
		Student student = repository.searchByName(name);
		if(student == null) {
			return name+ " さんは登録されていません。";
		}
		return  student.getName() + "：" + student.getAge() + "歳";
	}

	//新規登録
	@PostMapping("/student")
	public String registerStudent(@RequestParam String name,@RequestParam int age) {
		name = name.trim();

		repository.registerStudent(name, age);
		return name + " " + age + "歳を登録";

	}


	//情報の更新
	@PatchMapping("/student")
	public String updateStudentName(@RequestParam String name, @RequestParam int age) {
		name = name.trim();
		repository.updateStudent(name,age);

		return name + "を" + age + "歳に更新";
	}

	//データの削除
	@DeleteMapping("/student")
	public String student(@RequestParam String name) {
		name = name.trim();
		repository.deleteStudent(name);
		return name + "を" + "削除";
	}
}
