package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.example.sample.service.SampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.example.sample.service.impl.SampleDAO;
import egovframework.example.sample.service.impl.SampleMapper;
/**
 * @Class Name : SampleServiceImpl.java
 * @Description : Sample Business Implement class
 * @Modification Information
 *
 * @author MG Sung
 * @since 2021/12/25
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("sampleService")
public class SampleServiceImpl extends EgovAbstractServiceImpl implements
        SampleService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);

    @Resource(name="sampleMapper")
    private SampleMapper sampleDAO;
    
    //@Resource(name="sampleDAO")
    //private SampleDAO sampleDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSampleIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * sample을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSample(SampleVO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	sampleDAO.insertSample(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * sample을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSample(SampleVO vo) throws Exception {
        sampleDAO.updateSample(vo);
    }

    /**
	 * sample을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SampleVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSample(SampleVO vo) throws Exception {
        sampleDAO.deleteSample(vo);
    }

    /**
	 * sample을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SampleVO
	 * @return 조회한 sample
	 * @exception Exception
	 */
    public SampleVO selectSample(SampleVO vo) throws Exception {
        SampleVO resultVO = sampleDAO.selectSample(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * sample 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return sample 목록
	 * @exception Exception
	 */
    public List<?> selectSampleList(SampleDefaultVO searchVO) throws Exception {
        return sampleDAO.selectSampleList(searchVO);
    }

    /**
	 * sample 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return sample 총 갯수
	 * @exception
	 */
    public int selectSampleListTotCnt(SampleDefaultVO searchVO) {
		return sampleDAO.selectSampleListTotCnt(searchVO);
	}
    
}
