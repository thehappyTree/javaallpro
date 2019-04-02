package com.myabitsDemo;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisUtil {
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sqlSessionFactory;
    /**
     * 加载位于src/mybatis.xml配置文件
     */
    static{
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    public static SqlSession getSqlSession() {
    	SqlSession sqlSession = threadLocal.get();
    	if(sqlSession == null) {
    		sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
            System.out.println(sqlSession);
    	}
    	return sqlSession;	
    }
    
    public static void closeSqlSession() {
    	SqlSession sqlSession = threadLocal.get();
    	if(sqlSession != null) {
    		sqlSession.close();
    		threadLocal.remove();
    	}
    }
    
    public static void main(String[] args) {
    	Connection conn =   MybatisUtil.getSqlSession().getConnection();
    	System.out.println(conn!=null?"连接成功":"连接失败");
    }
    

}
