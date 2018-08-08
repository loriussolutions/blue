package com.lorius.revenues.blue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {

	/**
	 * Request mapping for user
	 */
	@RequestMapping(value = { "/account", "/account/index" }, method = RequestMethod.GET)
	public ModelAndView getAccount() {
		ModelAndView mv = new ModelAndView("/account/index");
		// mv.addObject("usersModel", userService.findAll());
		System.out.println("done");
		return mv;
	}
}
