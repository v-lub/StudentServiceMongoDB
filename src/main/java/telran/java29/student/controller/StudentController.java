package telran.java29.student.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import telran.java29.student.dto.ScoreDto;
import telran.java29.student.dto.StudentDto;
import telran.java29.student.dto.StudentEditDto;
import telran.java29.student.dto.StudentResponseDto;
import telran.java29.student.dto.TeapotException;
import telran.java29.student.service.Credential;
import telran.java29.student.service.StudentService;
import telran.java29.student.service.StudentServiceImpl;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/student")
	boolean addStudent(@RequestBody StudentDto studentDto) {
		return studentService.addStudent(studentDto);
	}
	
	@GetMapping("/student/{id}")
	StudentResponseDto findStudent(@PathVariable int id) {
		return studentService.findStudent(id);
	}
	
	@PutMapping("/student")
	StudentResponseDto updateStudent(@RequestHeader("Authorization") String auth, @RequestBody StudentEditDto studentEditDto) {
		Credential credential = decodeToken(auth);
		int id = Integer.parseInt(credential.getLogin());
		return studentService.updateStudent(id,studentEditDto);
	}
	
	private Credential decodeToken(String auth) {
		try {
			int index = auth.indexOf(" ");
			auth = auth.substring(index + 1);
			byte[] bytesDecode = Base64.getDecoder().decode(auth);
			String token = new String(bytesDecode);
			String[] credentials = token.split(":");
			return new Credential(credentials[0], credentials[1]);
		} catch (Exception e) {
			throw new TeapotException();
		}
	}

	@DeleteMapping("/student/{id}")
	StudentResponseDto deleteStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
	
	@PutMapping("/student/{id}/score")
	boolean addScore(@PathVariable int id, @RequestBody ScoreDto scoreDto) {
		return studentService.addScore(id, scoreDto);
	}

}
