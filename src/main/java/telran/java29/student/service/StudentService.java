package telran.java29.student.service;

import telran.java29.student.dto.ScoreDto;
import telran.java29.student.dto.StudentDto;
import telran.java29.student.dto.StudentEditDto;
import telran.java29.student.dto.StudentResponseDto;

public interface StudentService {

		boolean addStudent(StudentDto studentDto);
		
		StudentResponseDto findStudent(int id);
		
		StudentResponseDto updateStudent(int id, StudentEditDto studentEditDto);
		
		StudentResponseDto deleteStudent(int id);
		
		boolean addScore(int id, ScoreDto scoreDto);
}
