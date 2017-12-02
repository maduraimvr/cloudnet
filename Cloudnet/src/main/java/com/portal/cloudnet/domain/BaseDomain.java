package com.portal.cloudnet.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 *<br><b>ç±»æ��è¿°:</b>
 *<pre>æ‰€ç¤ºPOçš„çˆ¶ç±»</pre>
 *@see
 *@since
 */
public class BaseDomain implements Serializable
{
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
