package org.worldfinder.mapper;

import org.worldfinder.domain.CountryClassVO;
import org.worldfinder.domain.RequestVO;

import java.util.List;

public interface MainMapper {
    public List<CountryClassVO> readCountry();
    public int writeRequest(RequestVO vo);
}
