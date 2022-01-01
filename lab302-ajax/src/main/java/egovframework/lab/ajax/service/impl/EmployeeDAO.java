package egovframework.lab.ajax.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("employeeDAO")
public class EmployeeDAO extends EgovAbstractMapper {

	@SuppressWarnings("unchecked")
	public List<String> getNameListForSuggest(String namePrefix) {
		return (List<String>) list("Employee.getNameListForSuggest", namePrefix); 
	}
}
