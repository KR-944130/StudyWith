package com.project.persistence;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DBConnectionTest {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
//	@Test
//	public void dataSourceTest() {
//		log.info("dataSource : " + dataSource);
//	}
	
//	@Test
//	public void sqlSessionFactoryTest() {
//		log.info("factory : " + sqlSessionFactory);
//	}
	
	@Test
	public void sqlSessionTest() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		log.info("sqlSession : " + sqlSession);
	}
}
