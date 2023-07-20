package org.joonzis.service;

import lombok.extern.log4j.Log4j;
import org.joonzis.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class TestServiceImpl implements TestService{

   @Autowired
   TestMapper mapper;

    @Override
    public int  testService(){
        return mapper.TestSelect();
    };
}
