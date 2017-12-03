package com.portal.cloudnet.web;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.portal.cloudnet.constant.CommonConstant;
import com.portal.cloudnet.domain.User;
import com.portal.cloudnet.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

	@Autowired
	private UserService userService;
	
    /**
     * ç”¨æˆ·ç™»é™†
     * @param request
     * @param user
     * @return
     * @throws UnknownHostException 
     */
	@RequestMapping("/doLogin")
	public ModelAndView login(HttpServletRequest request, User user) throws UnknownHostException {
		User dbUser = userService.getUserByUserName(user.getUserName());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/login.jsp");
		if (dbUser == null) {
			mav.addObject("errorMsg", "database not found");
		} else if (!dbUser.getPassword().equals(user.getPassword())) {
			mav.addObject("errorMsg", "password incorrect");
		} else if (dbUser.getLocked() == User.USER_LOCK) {
			mav.addObject("errorMsg", "user locked");
		} else {
			InetAddress localhost = InetAddress.getLocalHost();
			String ipAddress=localhost.getHostAddress().trim();
			dbUser.setLastIp(ipAddress);
			dbUser.setLastVisit(new Date());
			userService.loginSuccess(dbUser);
			setSessionUser(request,dbUser);
			mav.setViewName("forward:/index.jsp");
		}
		return mav;
	}

	/**
	 * ç™»å½•æ³¨é”€
	 * @param session
	 * @return
	 */
	@RequestMapping("/doLogout")
	public String logout(HttpSession session) {
		session.removeAttribute(CommonConstant.USER_CONTEXT);
		return "forward:/index.jsp";
	}

}
