package com.example.managingtransactions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class BookingService {
    private static final Logger log = LoggerFactory.getLogger(BookingService.class);

    private final JdbcTemplate jdbcTemplate;

    public BookingService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void book(String... people) {
        for (String person : people) {
            log.info("Adding " + person + " to db");
            jdbcTemplate.update("insert into bookings(first_name) values(?)", person);
        }
    }

    public List<String> findAllBookings() {
        return jdbcTemplate.query("select first_name from bookings",
                (rs, rowNum) -> rs.getString("first_name"));
    }
}
