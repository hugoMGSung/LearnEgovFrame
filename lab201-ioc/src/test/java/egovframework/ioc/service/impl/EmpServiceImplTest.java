package egovframework.ioc.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egovframework.ioc.service.EmpService;
import egovframework.ioc.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/context-common.xml")
public class EmpServiceImplTest {
	@Resource(name = "annotationEmpService")
	EmpService empService;
	
	public EmpVO makeVO() {
		return makeVO(101);
	}
	
	public EmpVO makeVO(int empNo) {
		EmpVO newVO = new EmpVO();
		newVO.setEmpNo(empNo);
		newVO.setEmpName("홍길동 : " + empNo);
		newVO.setJob("테스터");
		return newVO;
	}
	
	public void checkResult(EmpVO vo, EmpVO resultVO) {
		assertNotNull(resultVO); // resultVO가 null이 아닌지
		assertEquals(vo.getEmpNo(), resultVO.getEmpNo());
		assertEquals(vo.getEmpName(), resultVO.getEmpName());
		assertEquals(vo.getJob(), resultVO.getJob());		
	}
	
	@Test
	public void testInsertEmp() throws Exception {
		EmpVO vo = new EmpVO();
		empService.insertEmp(vo);  // insert
		EmpVO resultVO = empService.selectEmp(vo); // select
		checkResult(vo, resultVO);
	}
	
	@Test
	public void testUpdateEmp() throws Exception {
		EmpVO vo = makeVO(102);
		empService.insertEmp(vo);  // insert
		vo.setEmpName("홍길술");
		vo.setJob("아키텍처");
		empService.updateEmp(vo);  // update
		EmpVO resultVO = empService.selectEmp(vo);  // select
		checkResult(vo, resultVO);
	}
	
	@Test
	public void testDeleteEmp() throws Exception {
	    EmpVO vo = makeVO(103);        
	    empService.insertEmp(vo);  // insert
	    empService.deleteEmp(vo);  // delete
	    EmpVO resultVO = empService.selectEmp(vo);  // select
	    assertNull(resultVO);  // null 이어야 함
	}
	
	@Test
	public void testSelectEmpList() throws Exception {
	    List<EmpVO> resultList = empService.selectEmpList();  // select list
	    int firstListSize = resultList.size();  // check
	    assertTrue(firstListSize > 100);
	    // DAO 에서 Emp 데이터를 관리할 때 항상 sorted 된 상태임
	    assertEquals(1, resultList.get(0).getEmpNo());
	    EmpVO empVO = new EmpVO();  // delete first data
	    empVO.setEmpNo(1);
	    empService.deleteEmp(empVO);
	    resultList = empService.selectEmpList();  // select List again
	 
	        assertEquals(firstListSize - 1, resultList.size());
	        // DAO 에서 Emp 데이터를 관리할 때 항상 sorted 된 상태임
	    assertEquals(2, resultList.get(0).getEmpNo());
	    assertEquals("EmpName 2", resultList.get(0).getEmpName());
	    assertEquals("SALESMAN", resultList.get(0).getJob());
	}
}
