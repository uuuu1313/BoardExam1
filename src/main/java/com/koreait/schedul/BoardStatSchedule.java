package com.koreait.schedul;

import com.koreait.models.board.BoardDao;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardStatSchedule {

    private final BoardDao boardDao;

    @Scheduled(cron = "0 0 1 * * *")
    public void process(){
        Long datTotal = boardDao.getDayTotal();

    }
}
