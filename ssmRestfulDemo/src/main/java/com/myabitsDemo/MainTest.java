package com.myabitsDemo;

import java.util.List;

public class MainTest {
	
	public static void test(int ...ids) {
		System.out.println(ids.getClass().toString());
		System.out.println(ids);
		for(int i : ids) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) throws Exception {
        //StudentDao studentDao = new StudentDao();
        /*Student student1 = new Student(4,"zhangsan",19000D);
        Student student2 = new Student(5,"lisi",20000D);
        
        studentDao.add(student1);
        studentDao.add(student2);
        List<Student> sts = studentDao.pagination(1, 3);
        for (Student s:sts) {
        	System.out.println(s.getId());
        	System.out.println(s.getName());
        	System.out.println(s.getSal());
        }*/
        
        /*List<Student> ss = studentDao.findByCondition(null, 20000D);
        for(Student s : ss) {
        	System.out.println(s.getId());
        	System.out.println(s.getName());
        	System.out.println(s.getSal());
        	
        }*/
        
        //int id = 1;
        //int ret = studentDao.delete(id);
        //System.out.println(ret);
        //List<Student> students = studentDao.findAll();
        /*for (Student s : students) {
        	System.out.println(s.getId());
        	System.out.println(s.getName());
        	System.out.println(s.getSal());
        }*/
        /*Student student = studentDao.findById(2);
        student.setName("yetingsb");
        student.setSal(900D);
        studentDao.updateByConditions(student);*/
		test(1,2,3);
      
    }

}
