
package com.portal.cloudnet.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.portal.cloudnet.domain.User;
import com.portal.cloudnet.exception.UserExistException;
import com.portal.cloudnet.service.UserService;


@Controller                   
public class RegisterController extends BaseController {

	@Autowired
	private UserService userService;

	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(HttpServletRequest request,User user){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/index.jsp");
		try {
			userService.register(user);
		} catch (UserExistException e) {
			mav.addObject("errorMsg", "Registeration Failed");
			mav.setViewName("forward:/register.jsp");
		}
		setSessionUser(request,user);
		return mav;
	}
}
