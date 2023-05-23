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
        Long dayTotal = boardDao.getDayTotal();
        System.out.println("전날 총 등록된 게시글 수는 " + dayTotal + "개 입니다.");
    }
}
