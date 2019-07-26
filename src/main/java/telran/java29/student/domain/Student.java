package telran.java29.student.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Document(collection = "student2019")
public class Student {
	@Id
	int id;
	@Setter
	String password;
	@Setter
	String email;
	Map<String, Integer> scores;

	public Student(int id, String password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
		scores = new HashMap<>();
	}

	public boolean addScore(String exam, int score) {
		return scores.put(exam, score) == null;
	}

}
