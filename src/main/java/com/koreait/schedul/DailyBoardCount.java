package com.koreait.schedul;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;

@Component
@RequiredArgsConstructor
public class DailyBoardCount {


    private final JdbcTemplate jdbcTemplate;
    public void totalSave(long count){
        String sql = "INSERT INTO DAILYCOUNT (BOARDCOUNT) VALUES (?)";
        jdbcTemplate.update(con -> {
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setLong(1, count);

            return pstmt;
        });
    }
}
