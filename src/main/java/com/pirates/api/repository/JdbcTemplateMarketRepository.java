package com.pirates.api.repository;

import com.pirates.api.domain.Businesstimes;
import com.pirates.api.domain.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcTemplateMarketRepository implements MarketRepository {

    long marketId;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateMarketRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override // 점포 추가
    public void save(Market market) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("Market").usingGeneratedKeyColumns("id"); //"id"칼럼 자동 키 생성

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", market.getName());
        parameters.put("owner", market.getOwner());
        parameters.put("description", market.getDescription());
        parameters.put("level", market.getLevel());
        parameters.put("address", market.getAddress());
        parameters.put("phone", market.getPhone());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters)); // 키 생성된거 빼오기
        market.setId(key.longValue());
        marketId = market.getId();
    }

    @Override // 점포 영업시간 추가
    public void saveBusiness(List<Businesstimes> businesstimes) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("businesstimes");
        for(Businesstimes businesstime : businesstimes) { // for문 돌면서 해당 마켓의 영업시간 테이블에 인설트
            Map<String, Object> businesstimesParam = new HashMap<>();
            businesstimesParam.put("day", businesstime.getDay() );
            businesstimesParam.put("open", businesstime.getOpen());
            businesstimesParam.put("close", businesstime.getClose());
            businesstimesParam.put("market_ID", marketId);

            jdbcInsert.execute(businesstimesParam);
        }
    }

    @Override //점포 휴무일 등록
    public void saveHolidays(Market market) {
        List<String> holidays = market.getHolidays();
        String holiday = "";
        for(String str : holidays) {
            holiday += "," + str;
        }
        long id = market.getId();
        jdbcTemplate.update("update market set holidays = ? where id = ?", holiday, id);

    }
}
