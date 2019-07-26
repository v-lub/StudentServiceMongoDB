package telran.java29.student.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
	Integer id;
	String email;
	Map<String, Integer> scores;
}
