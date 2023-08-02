package org.worldfinder.service;

import org.apache.ibatis.annotations.Param;
import org.worldfinder.domain.CountryClassVO;
import org.worldfinder.domain.CountryVO;
import org.worldfinder.domain.ReportVO;
import org.worldfinder.domain.RequestVO;

import java.util.List;
import java.util.Map;

public interface MainService {
    // 대륙 세부대륙 나라 가져오기
    public List<CountryClassVO> readCountry();
    // 건의사항 입력
    public int writeRequest(RequestVO vo);
    // 신고내역 가져오기
    public  List<ReportVO> readReport(String category);
    // 건의사항 가져오기
    public  List<RequestVO> readRequest();
//     대륙, 세부대륙 가져오기
    public  List<CountryClassVO> readContinent();
    // 특정 대륙 나라 가져오기
    public  List<Map<String,String>> countryList(String details_continet);
    //나라 페이지 내용 인설트하기
    public void writeCountry(CountryVO vo);
    // 나라 메인페이지 가져오기
    public CountryVO readCountryPage(String country);
    // 필터에 필요한값 가져오기
    public  List<Map<String,String>> readfilter(String filterValue , String category);
}
