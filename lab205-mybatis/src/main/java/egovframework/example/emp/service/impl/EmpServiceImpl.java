package egovframework.example.emp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import egovframework.example.emp.service.EmpService;

import egovframework.example.emp.service.EmpVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("empService")
public class EmpServiceImpl extends EgovAbstractServiceImpl implements EmpService {

	@Resource(name = "empMapper")
	EmpMapper empDAO;
	
	@Override
	public void insertEmp(EmpVO empVO) throws Exception {
		empDAO.insertEmp(empVO);
	}
	@Override
	public void updateEmp(EmpVO empVO) throws Exception {
		empDAO.updateEmp(empVO);
	}
	@Override
	public void deleteEmp(EmpVO empVO) throws Exception {
		empDAO.deleteEmp(empVO);
	}
	@Override
	public EmpVO selectEmp(EmpVO empVO) throws Exception {
		EmpVO resultVO = empDAO.selectEmp(empVO);
		
		return resultVO;
	}
	@Override
	public List<EmpVO> selectEmpList(EmpVO searchVO) throws Exception {
		return empDAO.selectEmpList(searchVO);
	}
}