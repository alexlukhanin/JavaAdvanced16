package ua.alex.hw16.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alex.hw16.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoImpl implements StudentDao {

    List<Student> students;

    @Autowired
    public  StudentDaoImpl() {
        students = new ArrayList<>();
        Student student1 = new Student(0, "Alex", 42 );
        Student student2 = new Student(1, "George", 27);
        Student student3 = new Student(2, "Carnell", 31);
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }


    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public boolean create(Student student) {
        return students.add(student);
    }

    @Override
    public Student getStudent(Integer id) {
        return students.get(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        Student foundStudent = students.get(student.getId());
        if (foundStudent != null) {
            foundStudent.setName(student.getName());
            foundStudent.setAge(student.getAge());
            System.out.println("Student: id " + student.getId() + ", updated in database");
            return true;
        } else
            return false;

    }

    @Override
    public boolean deleteStudent(Integer id) {
        Student removedStudent = students.remove(id.intValue());
        if (removedStudent != null) {
            System.out.println("Student: id " + id + ", removed from database");
            return true;
        } else
            return false;

    }
}
