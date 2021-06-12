package com.pirates.api.repository;

import com.pirates.api.domain.Businesstimes;
import com.pirates.api.domain.Market;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MarketRepository {
    //점포추가
    void save(Market market);

    void saveBusiness(List<Businesstimes> businesstimes);
}
