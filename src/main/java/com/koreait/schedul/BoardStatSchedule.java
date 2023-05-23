package com.koreait.schedul;

import com.koreait.models.board.BoardDao;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardStatSchedule {

    private final BoardDao boardDao;
    private final DailyBoardCount dailyBoardCount;

    @Scheduled(cron = "0 0 1 * * *") // 새벽 1시마다 실행됨
    public long process(){
        long total = boardDao.getDayTotal();
        System.out.println("다시 체크 저장 갯수 = " + total);

        dailyBoardCount.totalSave(total);

        return total;
    }
}
