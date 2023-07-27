package org.worldfinder.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.worldfinder.domain.CountryClassVO;
import org.worldfinder.domain.RequestVO;
import org.worldfinder.mapper.MainMapper;

import java.util.List;

@Log4j
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private MainMapper mapper;

    @Override
    public List<CountryClassVO> readCountry() {
        return mapper.readCountry();
    }

    @Override
    public int writeRequest(RequestVO vo) {
        return mapper.writeRequest(vo);
    }


}
