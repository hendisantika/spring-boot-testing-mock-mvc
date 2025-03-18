package id.my.hendisantika.testingmockmvc.controller;

import id.my.hendisantika.testingmockmvc.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-testing-mock-mvc
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 18/03/25
 * Time: 08.48
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
}
