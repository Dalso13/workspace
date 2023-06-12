package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.EmployeeVO;

public interface EmployeeDao {
	public List<EmployeeVO> getAllEmployees();
	public List<EmployeeVO> getDeptList(int department_id);
	public List<EmployeeVO> getDynamicList(Map<String, String> map);
}
