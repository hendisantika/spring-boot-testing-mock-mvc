package id.my.hendisantika.testingmockmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.testingmockmvc.SpringBootTestingMockMvcApplication;
import id.my.hendisantika.testingmockmvc.constants.URIConstant;
import id.my.hendisantika.testingmockmvc.entity.Student;
import id.my.hendisantika.testingmockmvc.service.StudentService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.http.RequestEntity.put;
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

    @Test
    public void testPostExample() throws Exception {
        Student student = new Student();
        student.setId(1);
        student.setName("Yuji");
        Mockito.when(studentService.saveStudent(ArgumentMatchers.any())).thenReturn(student);
        String json = mapper.writeValueAsString(student);
        mockMvc.perform(post(URIConstant.POST_MAPPING).contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                        .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("Yuji")));
    }

    @Test
    public void testPutExample() throws Exception {
        Student student = new Student();
        student.setId(2);
        student.setName("Geto");
        Mockito.when(studentService.updateStudent(ArgumentMatchers.any())).thenReturn(student);
        String json = mapper.writeValueAsString(student);
        mockMvc.perform(put(URIConstant.PUT_MAPPING).contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                        .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.equalTo(2)))
                .andExpect(jsonPath("$.name", Matchers.equalTo("Geto")));
    }
}
