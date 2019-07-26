package telran.java29.student.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.java29.student.domain.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

}
