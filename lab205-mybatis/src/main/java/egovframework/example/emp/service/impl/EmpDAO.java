package egovframework.example.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.emp.service.EmpVO;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("empDAO")
public class EmpDAO extends EgovAbstractMapper {

	public int insertEmp(EmpVO vo) {
		return insert("insertEmp", vo);
	}
	public int updateEmp(EmpVO vo) {
		return update("updateEmp", vo);
	}
	public int deleteEmp(EmpVO vo) {
		return delete("deleteEmp", vo);

	}
	public EmpVO selectEmp(EmpVO vo) {
		return selectOne("selectEmp", vo);
	}
	public List<EmpVO> selectEmpList(EmpVO searchVO) {
		return selectList("selectEmpList", searchVO);
	}
}
