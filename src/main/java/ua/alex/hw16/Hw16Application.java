package ua.alex.hw16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.alex.hw16.dao.StudentDao;
import ua.alex.hw16.dao.StudentDaoImpl;
import ua.alex.hw16.entity.Student;

@SpringBootApplication
public class Hw16Application {

	public static void main(String[] args) {
		final ConfigurableApplicationContext context = SpringApplication.run(Hw16Application.class, args);

		StudentDao studentDao = context.getBean("studentDaoImpl", StudentDaoImpl.class);

		System.out.println("Get all students: ");
		// print all students
		studentDao.getAllStudents().forEach(System.out::println);

		System.out.println("---------------------------");
		System.out.println("Update student with id = 1");
		//update student
		Student student = studentDao.getAllStudents().get(1);
		student.setName("Daniel");
		student.setAge(41);
		studentDao.updateStudent(student);
		// check result print all students again
		studentDao.getAllStudents().forEach(System.out::println);


		System.out.println("---------------------------");
		System.out.println("Delete student with id = 1");

		studentDao.deleteStudent(1);

		// check result print all students again
		studentDao.getAllStudents().forEach(System.out::println);

		System.out.println("---------------------------");
		System.out.println("Add student from Configuration");

		// create new and add to List
		Student studentToAdd = context.getBean("studentToAdd", Student.class);
		studentDao.create(studentToAdd);
		// check result print all students again
		studentDao.getAllStudents().forEach(System.out::println);





	}

}
