package com.devpro.yuubook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController extends BaseController{

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		return "login";
	}
}
