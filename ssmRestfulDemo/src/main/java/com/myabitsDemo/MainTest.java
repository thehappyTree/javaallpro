package com.myabitsDemo;

import java.util.List;

public class MainTest {
	
	public static void main(String[] args) throws Exception {
        StudentDao studentDao = new StudentDao();
        //Student student = new Student(3,"lishuai",19000D);
        //studentDao.add(student);
        List<Student> students = studentDao.findAll();
        for (Student s : students) {
        	System.out.println(s.getName());
        	System.out.println(s.getId());
        	System.out.println(s.getSal());
        }
    }

}
