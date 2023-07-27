package org.worldfinder.service;

import org.worldfinder.domain.CountryClassVO;
import org.worldfinder.domain.RequestVO;

import java.util.List;

public interface MainService {
    public List<CountryClassVO> readCountry();
    public int writeRequest(RequestVO vo);
}
