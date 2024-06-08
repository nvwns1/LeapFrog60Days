package org.suman.studentdao.repos;

import org.springframework.data.repository.CrudRepository;
import org.suman.studentdao.entities.Student;

public interface StudentRepository extends CrudRepository <Student, Integer>{
}
