package raisetech.Student.Manager;

import io.micrometer.common.util.StringUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagerApplication {

	private String name;
	private String age;

	private Map<String, String> student = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(StudentManagerApplication.class, args);
	}

	//登録されたデータを表示する
	@GetMapping("/studentInfo")
	public Object studentInfo() {
		if(student.isEmpty()) {
			return "何も登録されてません。";
		}
		return student;
	}

	//新規登録
	@PostMapping("/setStudent")
	public String setStudent(@RequestParam String name,@RequestParam String age) {
		name = name.trim();

		if(student.containsKey(name)) {
			return "すでに登録されています";
		}
		student.put(name, age);
		return "登録しました";
	}

	//情報の更新
	@PostMapping("/updateStudent")
	public String updateStudent(@RequestParam String name,@RequestParam String age) {
		name = name.trim();

		if(!student.containsKey(name)) {
			return "登録されていません。";
		}

		student.put(name, age);
		return "情報を更新しました";
	}

	//データの削除
	@PostMapping("/deleteStudent")
	public String deleteStudent(@RequestParam String name,@RequestParam String age) {
		name = name.trim();
		if(!student.containsKey(name)) {
			return "登録されていません。";
		}
		student.remove(name, age);
		return "情報を削除しました";
	}
}
