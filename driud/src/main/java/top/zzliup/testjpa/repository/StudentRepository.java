package top.zzliup.testjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.zzliup.testjpa.entity.Student;

/**
 * @author: Liupan on 2019-10-25 17:16
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
