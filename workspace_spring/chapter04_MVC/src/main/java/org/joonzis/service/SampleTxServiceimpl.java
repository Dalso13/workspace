package org.joonzis.service;

import org.joonzis.mapper.Sample1Mapper;
import org.joonzis.mapper.Sample2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Transactional
@Log4j
@Service
public class SampleTxServiceimpl implements SampleTxService{
	
	@Autowired
	private Sample1Mapper mapper1;
	
	@Autowired
	private Sample2Mapper mapper2;
	
	@Override
	public void addData(String value) {
		
		log.info("mapper1--");
		mapper1.insertCol1(value);
		log.info("mapper2--");
		mapper2.insertCol2(value);
		
		log.info("end--");
	};
}
