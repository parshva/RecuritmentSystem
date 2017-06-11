package com.recuriter.loginController;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.recuriter.loginModel.RecuritmentLogin;
import com.recuriter.loginService.RecuriterService;

@Controller
public class RecuriterController {

	private RecuriterService recuriterService;
	private static final Logger logger = LoggerFactory.getLogger(RecuriterController.class);

	@Autowired(required = true)
	@Qualifier(value = "recuriterService")
	public void setRecuriterService(RecuriterService ps) {
		this.recuriterService = ps;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String submit(Model model, HttpServletRequest request) {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		logger.info("Email is " + email);
		logger.info("Password is" + password);
		if (email != null && password != null) {
			RecuritmentLogin loginUserExist = recuriterService.getUserByEmail(email);
			if (loginUserExist != null && loginUserExist.getEmail() != null && loginUserExist.getPassword() != null
					&& loginUserExist.getEmail().equals(email) && loginUserExist.getPassword().equals(password)) {

				model.addAttribute("msg", "Login Succesfull");
				logger.info("Validated Succesfully");
				return "success";
			} else {
				model.addAttribute("msg", "Please enter correct username and password");
				logger.info("Username or Password incorrect");
				return "login";
			}
		} else {
			model.addAttribute("msg", "Username and Password not entered");
			logger.info("Username or Password not entered");
			return "login";
		}

	}

}
