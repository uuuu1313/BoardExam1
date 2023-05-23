package com.koreait.controllers.board;

import com.koreait.controllers.board.BoardForm;
import com.koreait.entities.Board;
import com.koreait.models.board.*;
import com.koreait.validators.BoardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardDao boardDao;
    private final BoardSaveService saveService;
    private final BoardListService listService;
    private final BoardDeleteService deleteService;
    private final BoardUpdateService updateService;

    private final BoardValidator validator;


    @GetMapping("/write")
    public String write(BoardForm boardForm, Model model){
        commonTitle(model, "#작성 페이지#");
        return "board/write";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardForm boardForm, Errors errors){

        System.out.println(boardForm);
        validator.validate(boardForm, errors);


        if (errors.hasErrors()){
            return "board/write";
        }

        saveService.save(boardForm);
        System.out.println(boardForm);
        return "redirect:/board/list"; // 작성 완료 후 목록으로 이동
    }

    @GetMapping("/list")
    public String list(Model model){
        commonTitle(model, "#게시글 리스트 페이지#");
        List<Board> items = listService.gets();
        model.addAttribute("items", items);

//        long total = boardDao.getTotal();
//        System.out.println("total = " + total);

        return "board/list";
    }

    @PostMapping("/list")
    public String listPs(@ModelAttribute BoardForm boardForm, Errors errors, Model model){

        System.out.println(boardForm);

        try {
            deleteService.delete(boardForm);
        } catch (RuntimeException e) {
            model.addAttribute("message", "존재하지 않는 게시글 입니다.");
            model.addAttribute("script", "alert('존재 않는 게시글!');history.back();");
            e.printStackTrace();
            return "commons/_script.html";
        }

        return "redirect:/board/list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model){
        commonTitle(model, "#게시글 보기,수정 페이지#");
        Board boardData = boardDao.get(id);

        model.addAttribute("boardForm", boardData);

        return "board/view";
    }

    @PostMapping("/view/{id}")
    public String viewPs(@PathVariable Long id, BoardForm boardForm, Errors errors, Model model){

        model.addAttribute("boardForm", boardForm);
        validator.validate(boardForm, errors);

        if (errors.hasErrors()){
            return "board/view";
        }

        updateService.update(boardForm);


        return "redirect:/board/list";
    }

    public void commonTitle(Model model, String title){
        model.addAttribute("pageTitle", title);
    }
}
