package com.portal.cloudnet.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.remoting.soap.SoapFaultException;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.portal.cloudnet.constant.CommonConstant;
import com.portal.cloudnet.domain.User;

public class BaseController {
	protected static final String ERROR_MSG_KEY = "errorMsg";

	/**
	 * èŽ·å�–ä¿�å­˜åœ¨Sessionä¸­çš„ç”¨æˆ·å¯¹è±¡
	 * 
	 * @param request
	 * @return
	 */
	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(
				CommonConstant.USER_CONTEXT);
	}
   
	/**
	 * ä¿�å­˜ç”¨æˆ·å¯¹è±¡åˆ°Sessionä¸­
	 * @param request
	 * @param user
	 */
	protected void setSessionUser(HttpServletRequest request,User user) {
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT,
				user);
	}
	

	/**
	 * èŽ·å�–åŸºäºŽåº”ç”¨ç¨‹åº�çš„urlç»�å¯¹è·¯å¾„
	 * 
	 * @param request
	 * @param url
	 *         ä»¥"/"æ‰“å¤´çš„URLåœ°å�€
	 * @return åŸºäºŽåº”ç”¨ç¨‹åº�çš„urlç»�å¯¹è·¯å¾„
	 */
	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "urlä¸�èƒ½ä¸ºç©º");
		Assert.isTrue(url.startsWith("/"), "å¿…é¡»ä»¥/æ‰“å¤´");
		return request.getContextPath() + url;
	}
	
	
}
