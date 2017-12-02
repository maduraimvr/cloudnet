package com.portal.cloudnet.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.cloudnet.dao.LoginLogDao;
import com.portal.cloudnet.dao.UserDao;
import com.portal.cloudnet.domain.LoginLog;
import com.portal.cloudnet.domain.User;
import com.portal.cloudnet.exception.UserExistException;


@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;

	
	/**
	 * æ³¨å†Œä¸€ä¸ªæ–°ç”¨æˆ·,å¦‚æžœç”¨æˆ·å��å·²ç»�å­˜åœ¨æ­¤æŠ›å‡ºUserExistExceptionçš„å¼‚å¸¸
	 * @param user 
	 */
	public void register(User user) throws UserExistException{
		User u = this.getUserByUserName(user.getUserName());
		if(u != null){
		    throw new UserExistException("UserExistException");
		}else{
		    user.setCredit(100);
            user.setUserType(1);
            userDao.save(user);
		}
	}
	
	/**
     * æ›´æ–°ç”¨æˆ·
     * @param user 
     */
    public void update(User user){
        userDao.update(user);
    }
	

	   /**
     * æ ¹æ�®ç”¨æˆ·å��/å¯†ç �æŸ¥è¯¢ Userå¯¹è±¡
     * @param userName ç”¨æˆ·å��
     * @return User
     */
    public User getUserByUserName(String userName){
        return userDao.getUserByUserName(userName);
    }
	
	
	/**
	 * æ ¹æ�®userIdåŠ è½½Userå¯¹è±¡
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId){
		return userDao.get(userId);
	}
	
	/**
	 * å°†ç”¨æˆ·é”�å®šï¼Œé”�å®šçš„ç”¨æˆ·ä¸�èƒ½å¤Ÿç™»å½•
	 * @param userName é”�å®šç›®æ ‡ç”¨æˆ·çš„ç”¨æˆ·å��
	 */
	public void lockUser(String userName){
		User user = userDao.getUserByUserName(userName);
		user.setLocked(User.USER_LOCK);
	    userDao.update(user);
	}
	
	/**
	 * è§£é™¤ç”¨æˆ·çš„é”�å®š
	 * @param userName è§£é™¤é”�å®šç›®æ ‡ç”¨æˆ·çš„ç”¨æˆ·å��
	 */
	public void unlockUser(String userName){
		User user = userDao.getUserByUserName(userName);
		user.setLocked(User.USER_UNLOCK);
		userDao.update(user);
	}
	
	
	/**
	 * æ ¹æ�®ç”¨æˆ·å��ä¸ºæ�¡ä»¶ï¼Œæ‰§è¡Œæ¨¡ç³ŠæŸ¥è¯¢æ“�ä½œ 
	 * @param userName æŸ¥è¯¢ç”¨æˆ·å��
	 * @return æ‰€æœ‰ç”¨æˆ·å��å‰�å¯¼åŒ¹é…�çš„userNameçš„ç”¨æˆ·
	 */
	public List<User> queryUserByUserName(String userName){
		return userDao.queryUserByUserName(userName);
	}
	
	/**
	 * èŽ·å�–æ‰€æœ‰ç”¨æˆ·
	 * @return æ‰€æœ‰ç”¨æˆ·
	 */
	public List<User> getAllUsers(){
		return userDao.loadAll();
	}
	
	/**
	 * ç™»é™†æˆ�åŠŸ
	 * @param user
	 */
	public void loginSuccess(User user) {
		user.setCredit( 5 + user.getCredit());
		LoginLog loginLog = new LoginLog();
		loginLog.setUser(user);
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(new Date());
        userDao.update(user);
//        loginLogDao.save(loginLog);
	}	
	
}
