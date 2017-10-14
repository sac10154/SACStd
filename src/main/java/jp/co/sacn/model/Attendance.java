
package jp.co.sacn.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model(schemaVersion = 1)
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    // ユーザーID
    private String userId;

    // 年月日(yyyy-mm-dd)
    private Date calendarDate;

    // 出社時間(hhmi)
    private String arrivalTime;

    // 退社時間(hhmi)
    private String quittingTime;

    // 休暇理由
    private String absenceReason;

    // 行先常駐先
    private String workingLocation;

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
	 * @return arrivalTime
	 */
	public String getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @return calendarDate
	 */
	public Date getCalendarDate() {
		return calendarDate;
	}

	/**
	 * @param calendarDate セットする calendarDate
	 */
	public void setCalendarDate(Date calendarDate) {
		this.calendarDate = calendarDate;
	}

	/**
	 * @param arrivalTime セットする arrivalTime
	 */
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return quittingTime
	 */
	public String getQuittingTime() {
		return quittingTime;
	}

	/**
	 * @param quittingTime セットする quittingTime
	 */
	public void setQuittingTime(String quittingTime) {
		this.quittingTime = quittingTime;
	}

	/**
	 * @return absenceReason
	 */
	public String getAbsenceReason() {
		return absenceReason;
	}

	/**
	 * @param absenceReason セットする absenceReason
	 */
	public void setAbsenceReason(String absenceReason) {
		this.absenceReason = absenceReason;
	}

	/**
	 * @return workingLocation
	 */
	public String getWorkingLocation() {
		return workingLocation;
	}

	/**
	 * @param workingLocation セットする workingLocation
	 */
	public void setWorkingLocation(String workingLocation) {
		this.workingLocation = workingLocation;
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
        Attendance other = (Attendance) obj;
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
