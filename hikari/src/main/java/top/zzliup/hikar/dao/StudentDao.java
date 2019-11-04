package top.zzliup.hikar.dao;

import org.apache.ibatis.annotations.Mapper;
import top.zzliup.hikar.model.Student;

import java.util.List;

/**
 * @author: Liupan on 2019-10-25 16:23
 */
@Mapper
public interface StudentDao {

    List<Student> findAll();
}
