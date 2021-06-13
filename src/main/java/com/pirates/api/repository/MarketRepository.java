package com.pirates.api.repository;

import com.pirates.api.domain.Businesstimes;
import com.pirates.api.domain.Market;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MarketRepository {
    //점포추가
    void save(Market market);

    //점포 영업시간 추가
    void saveBusiness(List<Businesstimes> businesstimes);

    //점포 휴무일 추가
    void saveHolidays(Market market);
}
