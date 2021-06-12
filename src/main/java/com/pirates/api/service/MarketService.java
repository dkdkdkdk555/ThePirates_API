package com.pirates.api.service;

import com.pirates.api.domain.Businesstimes;
import com.pirates.api.domain.Market;
import com.pirates.api.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service // SpringConfig에서 따로 @Bean 등록 해주는거 아니면 여기서 직접 빈 등록
public class MarketService {

    private final MarketRepository repository;

    @Autowired
    public MarketService(MarketRepository repository) {
        this.repository = repository;
    }

    //점포 추가 로직
    public void save(Market market) {
        repository.save(market);
    }
    //점포 영업시간 추가 로직
    public void saveBusiness(Market market) {
        repository.saveBusiness(market.getBusinessTimes());
    }
}
