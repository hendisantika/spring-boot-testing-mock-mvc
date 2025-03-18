package id.my.hendisantika.testingmockmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.testingmockmvc.SpringBootTestingMockMvcApplication;
import id.my.hendisantika.testingmockmvc.constants.URIConstant;
import id.my.hendisantika.testingmockmvc.entity.Student;
import id.my.hendisantika.testingmockmvc.service.StudentService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-testing-mock-mvc
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 18/03/25
 * Time: 08.51
 * To change this template use File | Settings | File Templates.
 */
@WebMvcTest
@ContextConfiguration(classes = SpringBootTestingMockMvcApplication.class)
class StudentControllerTest {
    private static final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private StudentService studentService;

    @Test
    public void testGetExample() throws Exception {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setId(1);
        student.setName("Yuji");
        students.add(student);
        Mockito.when(studentService.getStudents()).thenReturn(students);
        mockMvc.perform(get(URIConstant.GET_MAPPING)).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.equalTo("Yuji")));
    }
}
