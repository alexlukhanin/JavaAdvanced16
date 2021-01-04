package ua.alex.hw16.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.alex.hw16.entity.Student;

@Configuration
public class CustomConfiguration {

    @Bean(name="studentToAdd")
    public Student getStudent() {
        Student student = new Student();
        student.setId(5);
        student.setName("Jefrey");
        student.setAge(21);
        return student;
    }


}
