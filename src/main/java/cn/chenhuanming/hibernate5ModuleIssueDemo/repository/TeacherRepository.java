package cn.chenhuanming.hibernate5ModuleIssueDemo.repository;

import cn.chenhuanming.hibernate5ModuleIssueDemo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by chenhuanming on 2017-08-16.
 *
 * @author chenhuanming
 */
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
