package com.nhnacademy.edu.jdbc;

import com.nhnacademy.edu.jdbc.config.DatabaseConfig;
import com.nhnacademy.edu.jdbc.config.MainConfig;
import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.Teacher;
import com.nhnacademy.edu.jdbc.service.StudentService;
import com.nhnacademy.edu.jdbc.service.TeacherService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class JdbcTemplateMain {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(MainConfig.class)) {
//            StudentService studentService = context.getBean(StudentService.class);
            TeacherService teacherService = context.getBean(TeacherService.class);
//            System.out.println("=======>All Students");
//            studentService.getAllStudents()
//                    .forEach(System.out::println);


            System.out.println("ID = 1L Teacher");
            System.out.println(teacherService.getTeacher(1L));

//
//            System.out.println("=======>Test Students");
//            teacherService.getTest()
//                    .forEach(System.out::println);
//
//            System.out.println("=======>All Teachers");
            teacherService.getAllTeachers()
                            .forEach(System.out::println);

//            System.out.println("======= Insert And Delete Without Tx.");
//            try {
//                studentService.insertAndDelete(new Student(21L, "김하위", new Date()));
//            } catch (Exception e) {
//                //ignore
//            }
//
//            System.out.println("===Insert And Delete");
            try {
                teacherService.insertAndDelete(new Teacher(50L, "김하위", new Date()));
            } catch (Exception e) {
            }
//
            System.out.println("=======>All Teachers");
            teacherService.getAllTeachers()
                    .forEach(System.out::println);


        }
    }
}
