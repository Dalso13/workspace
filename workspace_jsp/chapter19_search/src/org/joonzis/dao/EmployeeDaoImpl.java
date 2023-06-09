package org.joonzis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.EmployeeVO;


public class EmployeeDaoImpl implements EmployeeDao{
	
	// DAO 객체 생성
	private static EmployeeDaoImpl instance = null;
	public EmployeeDaoImpl() {
	}
	public static EmployeeDaoImpl GetInstance() {
		if (instance == null) {
			instance = new EmployeeDaoImpl();
		}
		return instance;
	}
	
	// 필드
	private static SqlSession sqlsession = null;
	private synchronized static SqlSession getSqlSession() {
		if (sqlsession == null) {
			sqlsession = DBService.getFactory().openSession(false);
		}
		return sqlsession;
	}
	
	
	@Override
	public List<EmployeeVO> getAllEmployees() {
		
		return null;
	}
}
