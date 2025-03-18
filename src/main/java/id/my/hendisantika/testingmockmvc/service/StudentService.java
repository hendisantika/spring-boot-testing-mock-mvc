package id.my.hendisantika.testingmockmvc.service;

import id.my.hendisantika.testingmockmvc.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-testing-mock-mvc
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 18/03/25
 * Time: 08.44
 * To change this template use File | Settings | File Templates.
 */
@Service
public class StudentService {
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        students.add(student);
        return students;
    }
}
