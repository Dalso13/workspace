package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.EmployeeVO;

public interface EmployeeService {
	public List<EmployeeVO> getAll();
	public List<EmployeeVO> getDept(int department_id);
	public List<EmployeeVO> sDynamicList(Map<String, String> map);
 }

