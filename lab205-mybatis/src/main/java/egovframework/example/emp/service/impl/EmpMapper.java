package egovframework.example.emp.service.impl;

import java.util.List;

import egovframework.example.emp.service.EmpVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("empMapper")
public interface EmpMapper {
	public void insertEmp(EmpVO vo) throws Exception;
	public int updateEmp(EmpVO vo) throws Exception;
	public int deleteEmp(EmpVO vo) throws Exception;
	public EmpVO selectEmp(EmpVO vo) throws Exception;
	public List<EmpVO> selectEmpList(EmpVO searchVO) throws Exception;
}
