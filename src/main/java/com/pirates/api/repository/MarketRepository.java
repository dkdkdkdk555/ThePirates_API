package com.pirates.api.repository;

import com.pirates.api.domain.Market;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository {
    //점포추가
    void save(Market market);
}
