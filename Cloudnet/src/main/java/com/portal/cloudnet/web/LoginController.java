package com.portal.cloudnet.web;

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
     */
	@RequestMapping("/doLogin")
	public ModelAndView login(HttpServletRequest request, User user) {
		User dbUser = userService.getUserByUserName(user.getUserName());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/login.jsp");
		if (dbUser == null) {
			mav.addObject("errorMsg", "ç”¨æˆ·å��ä¸�å­˜åœ¨");
		} else if (!dbUser.getPassword().equals(user.getPassword())) {
			mav.addObject("errorMsg", "ç”¨æˆ·å¯†ç �ä¸�æ­£ç¡®");
		} else if (dbUser.getLocked() == User.USER_LOCK) {
			mav.addObject("errorMsg", "ç”¨æˆ·å·²ç»�è¢«é”�å®šï¼Œä¸�èƒ½ç™»å½•ã€‚");
		} else {
			dbUser.setLastIp(request.getRemoteAddr());
			dbUser.setLastVisit(new Date());
			userService.loginSuccess(dbUser);
			setSessionUser(request,dbUser);
//			String toUrl = (String)request.getSession().getAttribute(CommonConstant.LOGIN_TO_URL);
//			request.getSession().removeAttribute(CommonConstant.LOGIN_TO_URL);
//			//å¦‚æžœå½“å‰�ä¼šè¯�ä¸­æ²¡æœ‰ä¿�å­˜ç™»å½•ä¹‹å‰�çš„è¯·æ±‚URLï¼Œåˆ™ç›´æŽ¥è·³è½¬åˆ°ä¸»é¡µ
//			if(StringUtils.isEmpty(toUrl)){
//				toUrl = "/index.html";
//			}
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
