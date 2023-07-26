package org.worldfinder.mapper;

import org.worldfinder.domain.CountryClassVO;

import java.util.List;

public interface MainMapper {
    public List<CountryClassVO> readCountry();
}
