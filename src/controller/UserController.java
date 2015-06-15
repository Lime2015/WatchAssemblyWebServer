package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import service.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// orderListMain.do
	@RequestMapping(value = "saveUsers.do", method = RequestMethod.GET)
	public void saveUsers(String usersJSON, HttpServletResponse response, HttpServletRequest request) {
		
		usersJSON = request.getParameter("usersJSON");
		Gson gson = new GsonBuilder().create();
		
		
	}
	

	
}
