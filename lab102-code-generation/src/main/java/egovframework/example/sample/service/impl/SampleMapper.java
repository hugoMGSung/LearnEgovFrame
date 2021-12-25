package egovframework.example.sample.service.impl;

import java.util.List;

import egovframework.example.sample.service.SampleVO;
import egovframework.example.sample.service.SampleDefaultVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @Class Name : SampleMapper.java
 * @Description : Sample Mapper Class
 * @Modification Information
 *
 * @author MG Sung
 * @since 2021/12/25
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Mapper("sampleMapper")
public interface SampleMapper {

	/**
	 * sample을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertSample(SampleVO vo) throws Exception;

    /**
	 * sample을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSample(SampleVO vo) throws Exception;

    /**
	 * sample을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SampleVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSample(SampleVO vo) throws Exception;

    /**
	 * sample을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SampleVO
	 * @return 조회한 sample
	 * @exception Exception
	 */
    public SampleVO selectSample(SampleVO vo) throws Exception;

    /**
	 * sample 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return sample 목록
	 * @exception Exception
	 */
    public List<?> selectSampleList(SampleDefaultVO searchVO) throws Exception;

    /**
	 * sample 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return sample 총 갯수
	 * @exception
	 */
    public int selectSampleListTotCnt(SampleDefaultVO searchVO);

}
