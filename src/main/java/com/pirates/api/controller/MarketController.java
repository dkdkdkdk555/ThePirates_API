package com.pirates.api.controller;

import com.pirates.api.domain.Businesstimes;
import com.pirates.api.domain.Market;
import com.pirates.api.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MarketController {

    private final MarketService marketService;

    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostMapping("/addMarket")
    @ResponseBody // 응답할게 없더라도 @ResponseBody를 해줘야 디스페쳐서블릿이 뷰페이지를 안찾기 때문에 오류 안남
    public void addMarket(@RequestBody Market market ) {
        marketService.save(market);
        marketService.saveBusiness(market);
    }

}
