package jp.co.sacn.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.co.sacn.model.Employee;
import jp.co.sacn.model.Group;


public class GroupInfo implements Serializable  {

    private static final long serialVersionUID = 1L;

    /** グループ */
    private Group group;

    /**  */
    private List<Employee> employeeList = new ArrayList<Employee>();

    /**
     * @return group
     */
    public Group getGroup() {
    	return group;
    }

    /**
     * @param group セットする group
     */
    public void setGroup(Group group) {
    	this.group = group;
    }

    /**
     * @return employeeList
     */
    public List<Employee> getEmployeeList() {
    	return employeeList;
    }

    /**
     * @param employeeList セットする employeeList
     */
    public void setEmployeeList(List<Employee> employeeList) {
    	this.employeeList = employeeList;
    }

}
