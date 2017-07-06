package com.coderby.myapp.ex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coderby.myapp.ex.model.UserVO;
import com.coderby.myapp.ex.service.IUserService;

@Controller
@RequestMapping("/user")
public class userController {

	private static final Logger logger = LoggerFactory.getLogger(userController.class);

	@Autowired
	IUserService userService;

	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(){
		logger.info("insert");
		return "user/insertform";
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(UserVO user, Model model){
		try{
			userService.insertUser(user);
		}catch (Exception e){
			model.addAttribute("messsage", e.getMessage());
			return "user/error";
		}
		return "redirect:/";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "user/loginform";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String userId, String userPassword, Model model, HttpSession session){
		try {
			if(userService.checkPassword(userId, userPassword)){
				session.setMaxInactiveInterval(300); //5분간 아무것도 안하면 세션이 만료, 세션이 있는 데이터가 지워진다는 얘기임 
				session.setAttribute("userId", userId);
				System.out.println("aa");
				return "redirect:/user/view";
			} else {
				model.addAttribute("message", "아이디 또는 비밀번호가 잘못 입력됐습니다.");
				session.invalidate();
				return "user/loginform";
			}
		} catch (Exception e) {
			session.invalidate(); // 세션 무효처리
			model.addAttribute("message", e.getMessage());
			return "user/loginform";
		}
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String getUser(HttpSession session, Model model){
		String userId = (String)session.getAttribute("userId");
		if(userId == null || userId.equals("")){
			model.addAttribute("message", "로그인 사용자가 아닙니다.");
			return "user/loginform";
		}else{
			model.addAttribute("user", userService.selectUser(userId));
			return "user/view";
		}
	}
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateUser(HttpSession session, Model model) {
		String userId = (String)session.getAttribute("userId");
		if(userId == null || userId.equals("")){
			model.addAttribute("message", "로그인 사용자가 아닙니다.");
			return "user/loginform";
		}else{
			model.addAttribute("user", userService.selectUser(userId));
			return "user/updateform";
		}
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateUser(UserVO user, HttpSession session, Model model){
		String userId = (String)session.getAttribute("userId");
		if(userId == null || userId.equals("")) {
			model.addAttribute("message", ":로그인 사용자가 아닙니다.");
			return "user/loginform";
		}else{
			userService.updateUser(user);
			return "redirect:/user/view";
		}
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteUser(String userId, String userPassword) {
		return "user/deleteform";
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteUser(String userPassword, HttpSession session, Model model){
		String userId = (String)session.getAttribute("userId");
		if(userId==null || userId.equals("")){
			model.addAttribute("message", "로그인한 사용자가 아닙니다.");
			session.invalidate();
			return "user/loginform";
		}else{
			if(userService.checkPassword(userId,  userPassword)){
				userService.deleteUser(userId, userPassword);
				session.invalidate();
				return "redirect:/";
			}else {
				model.addAttribute("message", ":비밀번호가 다릅니다.");
				return "user/deleteform";
			}
		}
	}

	@RequestMapping(value="/list")
	public String list(Model model){
		List<UserVO> users = userService.selectAllUser();
		model.addAttribute("users", users);
		return "user/list";
	}
}