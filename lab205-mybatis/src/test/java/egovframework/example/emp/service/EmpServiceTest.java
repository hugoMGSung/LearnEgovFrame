package egovframework.example.emp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.annotation.Resource;

import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class EmpServiceTest {
	
	@Resource(name = "empService")
	EmpService empService;
	
	public EmpVO makeVO() throws ParseException {
		EmpVO vo = new EmpVO();
		vo.setEmpName("홍길동");
		vo.setJob("개발자");
		vo.setMgr(new BigDecimal(7902));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		vo.setHireDate(sdf.parse("2021-11-10"));
		vo.setSal(new BigDecimal(42000));
		vo.setComm(new BigDecimal(0));
		vo.setDeptNo(new BigDecimal(40));
		
		return vo;
	}
	
	public void checkResult(EmpVO vo, EmpVO resultVO) {
		assertNotNull(resultVO);
		assertEquals(vo.getEmpNo(), resultVO.getEmpNo());
		assertEquals(vo.getEmpName(), resultVO.getEmpName());
		assertEquals(vo.getJob(), resultVO.getJob());
		assertEquals(vo.getHireDate(), resultVO.getHireDate());
		// 나머지도 비교하는 것 추천함
	}
	
	@Test
	public void testInsertEmp() throws Exception {
		EmpVO vo = makeVO();
		empService.insertEmp(vo);  // insert
		
		EmpVO resultVO = empService.selectEmp(vo); //select
		checkResult(vo, resultVO); // check
	}
}
