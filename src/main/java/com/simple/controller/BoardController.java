package com.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.BoardVO;
import com.simple.service.BoardServiceImpl;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired(required = false)
	@Qualifier("boardService")
	private BoardServiceImpl boardService;
	
	@RequestMapping("/boardRegister")
	public void boardRegister() {	
	}
	
	@RequestMapping("/boardForm")
	public String boardForm(BoardVO vo) {
		boardService.boardRegister(vo);
		return "board/boardResult";
	}

	@RequestMapping("/boardList")
	public String boardList(Model model) {
		model.addAttribute("list", boardService.getList());
		return "board/boardList";
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") int num,
							RedirectAttributes RA) {
		boardService.boardDelete(num);
		RA.addFlashAttribute("num",num); //번호를 리다이렉트된 화면에 전달
		return "redirect:/board/boardList";
	}
	
}
