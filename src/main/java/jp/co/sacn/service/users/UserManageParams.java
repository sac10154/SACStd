package jp.co.sacn.service.users;

import java.io.Serializable;

import org.slim3.datastore.Attribute;

import com.google.appengine.api.datastore.Key;


public class UserManageParams implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    // ユーザーID
    private String userId;

    /**
	 * @return key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * @param key セットする key
	 */
	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}


}
