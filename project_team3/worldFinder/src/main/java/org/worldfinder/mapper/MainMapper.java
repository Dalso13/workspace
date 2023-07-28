package org.worldfinder.mapper;

import org.worldfinder.domain.CountryClassVO;
import org.worldfinder.domain.ReportVO;
import org.worldfinder.domain.RequestVO;

import java.util.List;

public interface MainMapper {
    public List<CountryClassVO> readCountry();
    public int writeRequest(RequestVO vo);
    public  List<ReportVO> readReport(String category);
    public  List<RequestVO> readRequest();
}
