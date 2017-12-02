package com.portal.cloudnet.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.portal.cloudnet.domain.User;

/**
 * Userå¯¹è±¡Dao
 */
@Repository
public class UserDao extends BaseDao<User> {
	private final String GET_USER_BY_USERNAME = "from User u where u.userName = ?";
	
	private final String QUERY_USER_BY_USERNAME = "from User u where u.userName like ?";
	
    /**
     * æ ¹æ�®ç”¨æˆ·å��æŸ¥è¯¢Userå¯¹è±¡
     * @param userName ç”¨æˆ·å��
     * @return å¯¹åº”userNameçš„Userå¯¹è±¡ï¼Œå¦‚æžœä¸�å­˜åœ¨ï¼Œè¿”å›žnullã€‚
     */
	public User getUserByUserName(String userName){
	    List<User> users = (List<User>)getHibernateTemplate().find(GET_USER_BY_USERNAME,userName);
	    if (users.size() == 0) {
			return null;
		}else{
			return users.get(0);
		}
    }
	
	/**
	 * æ ¹æ�®ç”¨æˆ·å��ä¸ºæ¨¡ç³ŠæŸ¥è¯¢æ�¡ä»¶ï¼ŒæŸ¥è¯¢å‡ºæ‰€æœ‰å‰�ç¼€åŒ¹é…�çš„Userå¯¹è±¡
	 * @param userName ç”¨æˆ·å��æŸ¥è¯¢æ�¡ä»¶
	 * @return ç”¨æˆ·å��å‰�ç¼€åŒ¹é…�çš„æ‰€æœ‰Userå¯¹è±¡
	 */
	public List<User> queryUserByUserName(String userName){
	    return (List<User>)getHibernateTemplate().find(QUERY_USER_BY_USERNAME,userName+"%");
	}

}
