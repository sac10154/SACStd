package jp.co.sacn.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class OpeLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    // 操作番号
    private String opeSeq;

    // 操作区分
    private String opeKbn;

    // 操作日時(yyyy-MM-dd HH:mm:ss)
    private Date opeDate;

    // ユーザーID
    private String userId;

    // ユーザー名
    private String userName;

    // グループID
    private String groupId;

    // グループ名
    private String groupName;

    // 対象データ
    private String opeData;

    // IPアドレス
    private String ipAddress;

    // 操作画面
    private String screenId;

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
	 * @return opeSeq
	 */
	public String getOpeSeq() {
		return opeSeq;
	}

	/**
	 * @param opeSeq セットする opeSeq
	 */
	public void setOpeSeq(String opeSeq) {
		this.opeSeq = opeSeq;
	}

	/**
	 * @return opeKbn
	 */
	public String getOpeKbn() {
		return opeKbn;
	}

	/**
	 * @param opeKbn セットする opeKbn
	 */
	public void setOpeKbn(String opeKbn) {
		this.opeKbn = opeKbn;
	}

	/**
	 * @return opeDate
	 */
	public Date getOpeDate() {
		return opeDate;
	}

	/**
	 * @param opeDate セットする opeDate
	 */
	public void setOpeDate(Date opeDate) {
		this.opeDate = opeDate;
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
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName セットする userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId セットする groupId
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName セットする groupName
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return opeData
	 */
	public String getOpeData() {
		return opeData;
	}

	/**
	 * @param opeData セットする opeData
	 */
	public void setOpeData(String opeData) {
		this.opeData = opeData;
	}

	/**
	 * @return ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress セットする ipAddress
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @return screenId
	 */
	public String getScreenId() {
		return screenId;
	}

	/**
	 * @param screenId セットする screenId
	 */
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OpeLog other = (OpeLog) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
