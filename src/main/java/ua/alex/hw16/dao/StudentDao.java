package ua.alex.hw16.dao;

import ua.alex.hw16.entity.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> getAllStudents();
    public boolean create (Student student);
    public  Student getStudent(Integer id);
    public boolean updateStudent (Student student);
    public boolean deleteStudent (Integer id);

}
