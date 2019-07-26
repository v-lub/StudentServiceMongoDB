package telran.java29.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.java29.student.dao.StudentRepository;
import telran.java29.student.domain.Student;
import telran.java29.student.dto.ScoreDto;
import telran.java29.student.dto.StudentDto;
import telran.java29.student.dto.StudentEditDto;
import telran.java29.student.dto.StudentResponseDto;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public boolean addStudent(StudentDto studentDto) {
		boolean res = studentRepository.existsById(studentDto.getId());
		if(res) {
			return false;
		}
		Student student = new Student(studentDto.getId(), 
				studentDto.getPassword(), studentDto.getEmail());
		
		studentRepository.save(student);
		return true;
	}

	@Override
	public StudentResponseDto findStudent(int id) {
		Student student = studentRepository.findById(id).orElse(null);
		return student == null ? null : 
			new StudentResponseDto(student.getId(), student.getEmail(), student.getScores());
	}

	@Override
	public StudentResponseDto updateStudent(int id, StudentEditDto studentEditDto) {
//		Student student = studentRepository.updateStudent(id, studentEditDto.getEmail(),
//				studentEditDto.getPassword());
//		
//		return new StudentResponseDto(student.getId(), student.getEmail(), student.getScores());
		return null;
	}

	@Override
	public StudentResponseDto deleteStudent(int id) {
		
//		  Student student = studentRepository.removeStudent(id); return new
//		  StudentResponseDto(student.getId(), student.getEmail(), student.getScores());
		return null;
		 
	}

	@Override
	public boolean addScore(int id, ScoreDto scoreDto) {
		//return studentRepository.addScore(id, scoreDto.getExam(), scoreDto.getScore());
		return false;
	}

}
