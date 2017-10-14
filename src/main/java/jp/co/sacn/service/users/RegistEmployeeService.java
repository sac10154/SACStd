package jp.co.sacn.service.users;

import java.text.ParseException;
import java.util.List;

import jp.co.sacn.dao.EmployeeDao;
import jp.co.sacn.dao.GroupDao;
import jp.co.sacn.dao.MemberDao;
import jp.co.sacn.model.Employee;
import jp.co.sacn.model.Group;
import jp.co.sacn.model.Member;

import org.slim3.util.BeanUtil;

public class RegistEmployeeService {

    private EmployeeDao employeeDao = new EmployeeDao();
    private GroupDao groupDao = new GroupDao();
    private MemberDao memberDao = new MemberDao();

    public Employee create(RegistEmployeeParams param) throws ParseException{
    	Employee employee = new Employee();
    	List<Group> groupList = param.getGroupList();
    	List<Member> memberList = param.getMemberList();
        BeanUtil.copy(param, employee);
       	employeeDao.create(employee);
       	if(!groupList.isEmpty()){
            groupDao.creates(groupList);
       	}
       	if(!memberList.isEmpty()){
       		memberDao.creates(memberList);
       	}

       	return employee;
    }

}
