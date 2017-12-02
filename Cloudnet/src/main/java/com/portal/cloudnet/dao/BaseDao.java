package com.portal.cloudnet.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.util.Assert;

public class BaseDao<T>{
	private Class<T> entityClass;
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * é€šè¿‡å��å°„èŽ·å�–å­�ç±»ç¡®å®šçš„æ³›åž‹ç±»
	 */
	public BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	/**
	 * æ ¹æ�®IDåŠ è½½POå®žä¾‹
	 * 
	 * @param id
	 * @return è¿”å›žç›¸åº”çš„æŒ�ä¹…åŒ–POå®žä¾‹
	 */
	public T load(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	/**
	 * æ ¹æ�®IDèŽ·å�–POå®žä¾‹
	 * 
	 * @param id
	 * @return è¿”å›žç›¸åº”çš„æŒ�ä¹…åŒ–POå®žä¾‹
	 */
	public T get(Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * èŽ·å�–POçš„æ‰€æœ‰å¯¹è±¡
	 * 
	 * @return
	 */
	public List<T> loadAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}
	
	/**
	 * ä¿�å­˜PO
	 * 
	 * @param entity
	 */
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}

	/**
	 * åˆ é™¤PO
	 * 
	 * @param entity
	 */
	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * æ›´æ”¹PO
	 * 
	 * @param entity
	 */
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * æ‰§è¡ŒHQLæŸ¥è¯¢
	 * 
	 * @param sql
	 * @return æŸ¥è¯¢ç»“æžœ
	 */
	public List find(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	/**
	 * æ‰§è¡Œå¸¦å�‚çš„HQLæŸ¥è¯¢
	 * 
	 * @param sql
	 * @param params
	 * @return æŸ¥è¯¢ç»“æžœ
	 */
	public List find(String hql, Object... params) {
		return this.getHibernateTemplate().find(hql,params);
	}
    
	/**
	 * å¯¹å»¶è¿ŸåŠ è½½çš„å®žä½“POæ‰§è¡Œåˆ�å§‹åŒ–
	 * @param entity
	 */
	public void initialize(Object entity) {
		this.getHibernateTemplate().initialize(entity);
	}
	
	
	/**
	 * åˆ†é¡µæŸ¥è¯¢å‡½æ•°ï¼Œä½¿ç”¨hql.
	 *
	 * @param pageNo é¡µå�·,ä»Ž1å¼€å§‹.
	 */
	public Page pagedQuery(String hql, int pageNo, int pageSize, Object... values) {
		Assert.hasText(hql);
		Assert.isTrue(pageNo >= 1, "pageNo should start from 1");
		// CountæŸ¥è¯¢
		String countQueryString = " select count (*) " + removeSelect(removeOrders(hql));
		List countlist = getHibernateTemplate().find(countQueryString, values);
		long totalCount = (Long) countlist.get(0);

		if (totalCount < 1)
			return new Page();
		// å®žé™…æŸ¥è¯¢è¿”å›žåˆ†é¡µå¯¹è±¡
		int startIndex = Page.getStartOfPage(pageNo, pageSize);
		Query query = createQuery(hql, values);
		List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();

		return new Page(startIndex, totalCount, pageSize, list);
	}

	/**
	 * åˆ›å»ºQueryå¯¹è±¡. å¯¹äºŽéœ€è¦�first,max,fetchsize,cache,cacheRegionç­‰è¯¸å¤šè®¾ç½®çš„å‡½æ•°,å�¯ä»¥åœ¨è¿”å›žQueryå�Žè‡ªè¡Œè®¾ç½®.
	 * ç•™æ„�å�¯ä»¥è¿žç»­è®¾ç½®,å¦‚ä¸‹ï¼š
	 * 
	 * dao.getQuery(hql).setMaxResult(100).setCacheable(true).list();
	 * 
	 * è°ƒç”¨æ–¹å¼�å¦‚ä¸‹ï¼š
	 * 
	 *        dao.createQuery(hql)
	 *        dao.createQuery(hql,arg0);
	 *        dao.createQuery(hql,arg0,arg1);
	 *        dao.createQuery(hql,new Object[arg0,arg1,arg2])
	 * 
	 *
	 * @param values å�¯å�˜å�‚æ•°.
	 */
	public Query createQuery(String hql, Object... values) {
		Assert.hasText(hql);
		Query query = getSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
	/**
	 * åŽ»é™¤hqlçš„select å­�å�¥ï¼Œæœªè€ƒè™‘unionçš„æƒ…å†µ,ç”¨äºŽpagedQuery.
	 *
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql : " + hql + " must has a keyword 'from'");
		return hql.substring(beginPos);
	}
	
	/**
	 * åŽ»é™¤hqlçš„orderby å­�å�¥ï¼Œç”¨äºŽpagedQuery.
	 *
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
    public  Session getSession() {
        return SessionFactoryUtils.getSession(hibernateTemplate.getSessionFactory(),true);
    }
	
}