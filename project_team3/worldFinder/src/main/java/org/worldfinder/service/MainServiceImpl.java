package org.worldfinder.service;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.worldfinder.domain.CountryClassVO;
import org.worldfinder.domain.CountryVO;
import org.worldfinder.domain.ReportVO;
import org.worldfinder.domain.RequestVO;
import org.worldfinder.mapper.MainMapper;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<ReportVO> readReport(String category) {
        return mapper.readReport(category);
    }

    @Override
    public List<RequestVO> readRequest() {
        return mapper.readRequest();
    }

    @Override
    public List<CountryClassVO> readContinent() {
        return mapper.readContinent();
    }

    @Override
    public List<Map<String,String>> countryList(String details_continet) {
        return mapper.countryList(details_continet);
    }

    @Override
    public void writeCountry(CountryVO vo) {
        mapper.writeCountry(vo);
    }

    @Override
    public CountryVO readCountryPage(String country) {
        return mapper.readCountryPage(country);
    }


}
