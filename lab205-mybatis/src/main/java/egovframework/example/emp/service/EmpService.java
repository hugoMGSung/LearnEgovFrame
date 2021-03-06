package egovframework.example.emp.service;

import java.util.List;

public interface EmpService {
	public void insertEmp(EmpVO empVO) throws Exception;
	public void updateEmp(EmpVO empVO) throws Exception;
	public void deleteEmp(EmpVO empVO) throws Exception;
	public EmpVO selectEmp(EmpVO empVO) throws Exception;
	public List<EmpVO> selectEmpList(EmpVO searchVO) throws Exception;
}
