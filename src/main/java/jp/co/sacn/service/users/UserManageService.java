package jp.co.sacn.service.users;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sacn.common.GroupInfo;
import jp.co.sacn.common.impl.GroupType;
import jp.co.sacn.dao.EmployeeDao;
import jp.co.sacn.dao.GroupDao;
import jp.co.sacn.dao.MemberDao;
import jp.co.sacn.model.Employee;
import jp.co.sacn.model.Group;
import jp.co.sacn.model.Member;


public class UserManageService {

	private EmployeeDao employeeDao = new EmployeeDao();
    private GroupDao groupDao = new GroupDao();
    private MemberDao memberDao = new MemberDao();

    public List<GroupInfo> select(UserManageParams param) throws ParseException{
    	List<GroupInfo> groupInfoList = new ArrayList<GroupInfo>();
    	List<Group> groupList = groupDao.selectList(GroupType.GROUP.getCode());
    	for(Group group : groupList){
    		GroupInfo gpInfo = new GroupInfo();
    		gpInfo.setGroup(group);
    		List<Member> memberList = memberDao.selectMemberList(group.getGroupId());
    		List<String> userIdList = new ArrayList<String>();
    		for(Member member : memberList){
    			userIdList.add(member.getMemberId());
        	}
			List<Employee> employeeList = employeeDao.selects(userIdList.toArray(new String[userIdList.size()]));
    		gpInfo.setEmployeeList(employeeList);
    		groupInfoList.add(gpInfo);
    	}

       	return groupInfoList;
    }


}
