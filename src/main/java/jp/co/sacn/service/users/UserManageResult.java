package jp.co.sacn.service.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.co.sacn.common.GroupInfo;

import org.slim3.datastore.Attribute;

import com.google.appengine.api.datastore.Key;


public class UserManageResult implements Serializable  {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    // グループリスト
    private List<GroupInfo> groupInfoList = new ArrayList<GroupInfo>();


    /**
	 * @return groupInfoList
	 */
	public List<GroupInfo> getGroupInfoList() {
		return groupInfoList;
	}

	/**
	 * @param groupInfoList セットする groupInfoList
	 */
	public void setGroupInfoList(List<GroupInfo> groupInfoList) {
		this.groupInfoList = groupInfoList;
	}

//	/**
//     * 情報
//     *
//     * @author m.goto
//     *
//     */
//    static public class GroupInfo {
//
//        /** グループ */
//        private Group group;
//
//        /**  */
//        private List<Employee> employeeList = new ArrayList<Employee>();
//
//        /**
//         * @return group
//         */
//        public Group getGroup() {
//            return group;
//        }
//
//        /**
//         * @param group セットする group
//         */
//        public void setGroup(Group group) {
//            this.group = group;
//        }
//
//		/**
//		 * @return employeeList
//		 */
//		public List<Employee> getEmployeeList() {
//			return employeeList;
//		}
//
//		/**
//		 * @param employeeList セットする employeeList
//		 */
//		public void setEmployeeList(List<Employee> employeeList) {
//			this.employeeList = employeeList;
//		}
//
//
//    }
}
