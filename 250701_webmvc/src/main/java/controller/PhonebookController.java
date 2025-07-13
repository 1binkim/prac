package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.PhonebookService;
import vo.Phonebook;

@Controller
@RequestMapping("/phonebook")
public class PhonebookController {
	@Autowired
	PhonebookService service;

	public PhonebookController() {
		System.out.println("phonebook controller!! /phonebook/");
	}

	public String save() {
		System.out.println("저장");
		return "save";
	}
	@RequestMapping("/insertform")
	public void insertform() {}

	public String insert(Phonebook phonebook) {
		System.out.println(phonebook);
		int result=service.save(phonebook);
		if(result>0) {
			return "redirect:/phonebook/list";
		} else {
			return "error";
		}

	}
	@RequestMapping("/list")
	public ModelAndView list() {
		List<Phonebook> list=service.list();
		ModelAndView mv=new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("list");
		return mv;
		
	}
	@RequestMapping("view")
	public ModelAndView view(@RequestParam(name="id")int id,ModelAndView mv){
		Phonebook pb =service.findById(id);
		mv.addObject("pb",pb);
		mv.setViewName("view");
		return mv;
	}
	@RequestMapping("updateform")
	public ModelAndView updateform(int id,ModelAndView mv) {
		mv.addObject("pb",service.findById(id));
		mv.setViewName("phonebook/updateform");
		return mv;
	}
	@RequestMapping("update")
	public String update(Phonebook phonebook) {
		
		int result=service.update(phonebook);
		if(result<1) {
			throw new CustomerException();
		}
		System.out.println("update성공");
		return "updateSuccess";
	}
	@RequestMapping("delete")
	public String delete(int id) {
		int result=service.delete(id);
		if(result<1) {
			throw new CustomerException();
		}
		return "deleteSuccess";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
