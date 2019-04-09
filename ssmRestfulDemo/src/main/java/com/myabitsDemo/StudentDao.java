package com.myabitsDemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class StudentDao {

    public void add(Student student) throws Exception {
    	
        //得到连接对象
    	 SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            sqlSession.insert("com.myabitsDemo.StudentDao.add", student);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    
    }
    
    public Student findById(int id) throws Exception {
        //得到连接对象
    	 SqlSession sqlSession = MybatisUtil.getSqlSession();
        try{
            //映射文件的命名空间.SQL片段的ID，就可以调用对应的映射文件中的SQL
            //sqlSession.insert("com.myabitsDemo.StudentDao.findById", id);
            return sqlSession.selectOne("com.myabitsDemo.StudentDao.findById",id);
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally{
            MybatisUtil.closeSqlSession();
        }
    
    }
    
    public List<Student> findAll() throws Exception{
    	SqlSession sqlSession = MybatisUtil.getSqlSession();
    	try {
    		return sqlSession.selectList("com.myabitsDemo.StudentDao.findAll");
    	}catch(Exception e) {
    		 e.printStackTrace();
             sqlSession.rollback();
             throw e;
    	}finally {
            MybatisUtil.closeSqlSession();

    	}
    	
    }
    
    public int delete(int id) throws Exception {
    	
    	SqlSession sqlSession = MybatisUtil.getSqlSession();
    	try {
        sqlSession.delete("com.myabitsDemo.StudentDao.delete",id);
        sqlSession.commit();
        return id;
    	}catch(Exception e) {
    		 e.printStackTrace();
             sqlSession.rollback();
             throw e;
    	}finally {
            MybatisUtil.closeSqlSession();

    	}
    	
    }
    
    public void updateStudent(Student student) {
        //得到连接对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
        	sqlSession.update("com.myabitsDemo.StudentDao.update", student);
        	sqlSession.commit();
        	
        }catch(Exception e) {
        	
        }finally {
            MybatisUtil.closeSqlSession();

        }
    }
    
    public List<Student> pagination(int start, int end) throws Exception {
    	
    	SqlSession sqlSession = MybatisUtil.getSqlSession();
    	try {
    		Map<String,Object> map = new HashMap<String, Object>(); 
    		map.put("start", start);
    		map.put("end", end);
    		return sqlSession.selectList("com.myabitsDemo.StudentDao.pagination",map);
    	}catch(Exception e) {
    		 e.printStackTrace();
             sqlSession.rollback();
             throw e;
    	}finally {
            MybatisUtil.closeSqlSession();
    	}
    }
    
    public List<Student> findByCondition(String name, Double sal) throws Exception{
    	SqlSession sqlSession = MybatisUtil.getSqlSession();
    	try {
    		Map<String, Object> map = new HashMap<String,Object>();
    		map.put("name", name);
    		map.put("sal", sal);
    		return sqlSession.selectList("com.myabitsDemo.StudentDao.findByCondition", map);
    		
    	}catch(Exception e) {
    		e.printStackTrace();
            sqlSession.rollback();
            throw e;
    	}finally {
    		MybatisUtil.closeSqlSession();
    	}
    	
    }
    
    public void updateByConditions(Student student) throws Exception {
    	SqlSession sqlSession = MybatisUtil.getSqlSession();
    	try {
    		
    		sqlSession.update("com.myabitsDemo.StudentDao.updateByConditions", student);
    		sqlSession.commit();
    		
    	}catch(Exception e) {
    		e.printStackTrace();
            sqlSession.rollback();
            throw e;
    	}finally {
    		MybatisUtil.closeSqlSession();
    	}
    	
    }
    
    public void deleteByConditions(int... ids) throws Exception {
     	SqlSession sqlSession = MybatisUtil.getSqlSession();
    	try {
    		
    		sqlSession.update("com.myabitsDemo.StudentDao.deleteByConditions", ids);
    		sqlSession.commit();
    		
    	}catch(Exception e) {
    		e.printStackTrace();
            sqlSession.rollback();
            throw e;
    	}finally {
    		MybatisUtil.closeSqlSession();
    	}
    }
    
    

}
