package com.myabitsDemo;

import java.util.List;

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
        return sqlSession.delete("com.myabitsDemo.StudentDao.delete");
    	}catch(Exception e) {
    		 e.printStackTrace();
             sqlSession.rollback();
             throw e;
    	}finally {
            MybatisUtil.closeSqlSession();

    	}
    	
    }
    
    
    

}
