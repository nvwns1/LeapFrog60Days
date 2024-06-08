package org.suman.studentdao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.suman.studentdao.entities.Student;
import org.suman.studentdao.repos.StudentRepository;

@SpringBootTest
class StudentDaoApplicationTests {
    @Autowired
    private StudentRepository studentRepository;

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Test
    public void testCreateStudent() {
        Student student = new Student();
        student.setName("Ram");
        student.setCourse("JAVA");
        student.setFee(400);

        studentRepository.save(student);
    }

    @Test
    public void testFindStudent() {
        Student student =
                studentRepository.findById(2).orElse(null);

        System.out.println(student);
    }

    @Test
    public void testUpdateStudent() {
        Student student = studentRepository.findById(2).orElse(null);

        student.setFee(600);
        studentRepository.save(student);
        Student updatedStudent = studentRepository.findById(2).orElse(null);
        System.out.println(updatedStudent);
    }

    @Test
    public void testDeleteStudent() {
        studentRepository.deleteById(2);
    }
}
