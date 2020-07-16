package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	
//	@RequestMapping("/sendBirth")
//	public String sendBirth(Quiz01VO Quiz01VO, Model model /* ModelAttribute("vo") Quiz01VO vo*/) {
//		model.addAttribute("Quiz01VO", Quiz01VO);
//		return "quiz/quiz01_ok";
//	}
	@RequestMapping("/sendBirth")
	public String sendBirth(Quiz01VO Quiz01VO, Model model /* ModelAttribute("vo") Quiz01VO vo*/) {
		model.addAttribute("Quiz01VO", Quiz01VO);
		return "quiz/quiz01_ok";
	}
	
	
	
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
//	@RequestMapping("/join")
//	public String join(@RequestParam("id") String id, 
//						@RequestParam("pw") String pw,
//						@RequestParam("name") String name,
//						@RequestParam("email") String email,
//						Model model) {
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);
//		model.addAttribute("name", name);
//		model.addAttribute("email", email);
//		return "quiz/quiz02_ok";
//	}
	
	@RequestMapping("/join")
	public String join(@ModelAttribute("id") String id,
						@ModelAttribute("pw") String pw,
						@ModelAttribute("name") String name,
						@ModelAttribute("email") String email) {
		return "quiz/quiz02_ok";
	}
	
	//화면 한번에 처리 가능
//	@RequestMapping({"/quiz01", "/quiz02", "/quiz03"})
//	public void quiz03() {
//	}
	
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	@RequestMapping("/join2")
	public String join2(@RequestParam("id") String id, 
						@RequestParam("pw") String pw,
						@RequestParam("pw_check") String pw_check,
						Model model, RedirectAttributes ra) {
		if(id.equals("")) {
			ra.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		} else if(!pw.equals(pw_check)){
			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		} else {
			model.addAttribute("id", id);
			return "quiz/quiz03_ok";
		}
	}
	
}
