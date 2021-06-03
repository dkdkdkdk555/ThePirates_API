package com.pirates.api.repository;

import com.pirates.api.domain.Market;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcTemplateMarketRepository implements MarketRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateMarketRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Market market) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("Market").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", market.getName());
        parameters.put("owner", market.getOwner());
        parameters.put("description", market.getDescription());
        parameters.put("level", market.getLevel());
        parameters.put("address", market.getAddress());
        parameters.put("phone", market.getPhone());
        parameters.put("businessTimes", market.getBusinessTimes());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        market.setId(key.longValue());
    }
}
