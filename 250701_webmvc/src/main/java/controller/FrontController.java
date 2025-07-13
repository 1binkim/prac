package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import vo.Phonebook;

public class FrontController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("phonebook Controller");
		ModelAndView mv=new ModelAndView();
		//model은 전송할 데이터를 저장할 객체
		mv.addObject("data","1234");
		Phonebook pb=new Phonebook();
		pb.setId(1);
		pb.setName("감길동");
		pb.setEmail("eeije@gmail.com");
		pb.setHp("010-1111-111");
		pb.setMemo("친구");
		mv.addObject("phonebook",pb);
		mv.setViewName("view");
		return mv;
	}
}
