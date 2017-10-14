package jp.co.sacn.service.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.co.sacn.model.Group;
import jp.co.sacn.model.Member;

import org.slim3.datastore.Attribute;

import com.google.appengine.api.datastore.Key;


public class RegistEmployeeParams implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    // ユーザーID
    private String userId;

    // パスワード
    private String password;

    // 名
    private String fname;

    // 姓
    private String sname;

    // メールアドレス
    private String email;

    // 作成日
    private Date createdDate = new Date();

    // グループリスト
    private List<Group> groupList = new ArrayList<Group>();

    // メンバーリスト
    private List<Member> memberList = new ArrayList<Member>();

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

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname セットする fname
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return sname
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param sname セットする sname
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate セットする createdDate
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return groupList
	 */
	public List<Group> getGroupList() {
		return groupList;
	}

	/**
	 * @param groupList セットする groupList
	 */
	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}

	/**
	 * @return memberList
	 */
	public List<Member> getMemberList() {
		return memberList;
	}

	/**
	 * @param memberList セットする memberList
	 */
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}


}
