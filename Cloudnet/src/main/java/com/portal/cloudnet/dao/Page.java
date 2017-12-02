package com.portal.cloudnet.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * åˆ†é¡µå¯¹è±¡. åŒ…å�«å½“å‰�é¡µæ•°æ�®å�Šåˆ†é¡µä¿¡æ�¯å¦‚æ€»è®°å½•æ•°.
 *
 */
public class Page implements Serializable {

	private static int DEFAULT_PAGE_SIZE = 20;

	private int pageSize = DEFAULT_PAGE_SIZE; // æ¯�é¡µçš„è®°å½•æ•°

	private long start; // å½“å‰�é¡µç¬¬ä¸€æ�¡æ•°æ�®åœ¨Listä¸­çš„ä½�ç½®,ä»Ž0å¼€å§‹

	private List data; // å½“å‰�é¡µä¸­å­˜æ”¾çš„è®°å½•,ç±»åž‹ä¸€èˆ¬ä¸ºList

	private long totalCount; // æ€»è®°å½•æ•°

	/**
	 * æž„é€ æ–¹æ³•ï¼Œå�ªæž„é€ ç©ºé¡µ.
	 */
	public Page() {
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList());
	}

	/**
	 * é»˜è®¤æž„é€ æ–¹æ³•.
	 *
	 * @param start	 æœ¬é¡µæ•°æ�®åœ¨æ•°æ�®åº“ä¸­çš„èµ·å§‹ä½�ç½®
	 * @param totalSize æ•°æ�®åº“ä¸­æ€»è®°å½•æ�¡æ•°
	 * @param pageSize  æœ¬é¡µå®¹é‡�
	 * @param data	  æœ¬é¡µåŒ…å�«çš„æ•°æ�®
	 */
	public Page(long start, long totalSize, int pageSize, List data) {
		this.pageSize = pageSize;
		this.start = start;
		this.totalCount = totalSize;
		this.data = data;
	}

	/**
	 * å�–æ€»è®°å½•æ•°.
	 */
	public long getTotalCount() {
		return this.totalCount;
	}

	/**
	 * å�–æ€»é¡µæ•°.
	 */
	public long getTotalPageCount() {
		if (totalCount % pageSize == 0)
			return totalCount / pageSize;
		else
			return totalCount / pageSize + 1;
	}

	/**
	 * å�–æ¯�é¡µæ•°æ�®å®¹é‡�.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * å�–å½“å‰�é¡µä¸­çš„è®°å½•.
	 */
	public List getResult() {
		return data;
	}

	/**
	 * å�–è¯¥é¡µå½“å‰�é¡µç �,é¡µç �ä»Ž1å¼€å§‹.
	 */
	public long getCurrentPageNo() {
		return start / pageSize + 1;
	}

	/**
	 * è¯¥é¡µæ˜¯å�¦æœ‰ä¸‹ä¸€é¡µ.
	 */
	public boolean isHasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount();
	}

	/**
	 * è¯¥é¡µæ˜¯å�¦æœ‰ä¸Šä¸€é¡µ.
	 */
	public boolean isHasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}

	/**
	 * èŽ·å�–ä»»ä¸€é¡µç¬¬ä¸€æ�¡æ•°æ�®åœ¨æ•°æ�®é›†çš„ä½�ç½®ï¼Œæ¯�é¡µæ�¡æ•°ä½¿ç”¨é»˜è®¤å€¼.
	 *
	 * @see #getStartOfPage(int,int)
	 */
	protected static int getStartOfPage(int pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}

	/**
	 * èŽ·å�–ä»»ä¸€é¡µç¬¬ä¸€æ�¡æ•°æ�®åœ¨æ•°æ�®é›†çš„ä½�ç½®.
	 *
	 * @param pageNo   ä»Ž1å¼€å§‹çš„é¡µå�·
	 * @param pageSize æ¯�é¡µè®°å½•æ�¡æ•°
	 * @return è¯¥é¡µç¬¬ä¸€æ�¡æ•°æ�®
	 */
	public static int getStartOfPage(int pageNo, int pageSize) {
		return (pageNo - 1) * pageSize;
	}
}