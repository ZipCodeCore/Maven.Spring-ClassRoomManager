package io.zipcoder.repository;

import io.zipcoder.domain.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by thook on 6/1/16.
 */
public interface StudentRepository extends CrudRepository<Student, Long>{
}
