package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.dao.EmployeeDao;
import org.joonzis.dao.EmployeeDaoImpl;
import org.joonzis.vo.EmployeeVO;

public class EmployeeServiceLmpl implements EmployeeService{
	private EmployeeDao dao = EmployeeDaoImpl.GetInstance();
	
	@Override
	public List<EmployeeVO> getAll() {
		
		return dao.getAllEmployees();
		
	}
	@Override
	public List<EmployeeVO> getDept(int department_id) {
		
		return dao.getDeptList(department_id);
	}
	
	@Override
	public List<EmployeeVO> sDynamicList(Map<String, String> map) {
		
		return dao.getDynamicList(map);
	}
}
