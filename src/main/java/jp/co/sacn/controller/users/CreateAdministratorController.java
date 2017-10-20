package jp.co.sacn.controller.users;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jp.co.sacn.common.impl.GroupType;
import jp.co.sacn.controller.common.AbstractController;
import jp.co.sacn.model.Group;
import jp.co.sacn.model.Member;
import jp.co.sacn.service.users.RegistEmployeeParams;
import jp.co.sacn.service.users.RegistEmployeeService;

import org.slim3.controller.Navigation;

public class CreateAdministratorController extends AbstractController {

	/** 社員のService */
    private RegistEmployeeService service = new RegistEmployeeService();

    /** 社員のパラメータ */
    private RegistEmployeeParams param = new RegistEmployeeParams();

    @Override
    public Navigation run() throws Exception {
    	param.setUserId("admin");
    	param.setPassword("admin");
    	param.setEmail("");
    	param.setSname("管理者");
    	param.setFname("ユーザー");
        Calendar calendar = Calendar.getInstance();
        param.setCreatedDate(calendar.getTime());

        List<Group> groupList = new ArrayList<Group>();
        Group gp001 = new Group();
        Group gp002 = new Group();
        Group gp003 = new Group();
        Group gp004 = new Group();
        Group gp005 = new Group();

        gp001.setGroupId("Administrator");
        gp001.setGroupName("管理者");
        gp001.setGroupType(GroupType.ROLE.getCode());
        groupList.add(gp001);

        gp002.setGroupId("Bucho");
        gp002.setGroupName("部長");
        gp002.setGroupType(GroupType.ROLE.getCode());
        groupList.add(gp002);

        gp003.setGroupId("GroupLeader");
        gp003.setGroupName("グループリーダー");
        gp003.setGroupType(GroupType.ROLE.getCode());
        groupList.add(gp003);

        gp004.setGroupId("Leader");
        gp004.setGroupName("リーダー");
        gp004.setGroupType(GroupType.ROLE.getCode());
        groupList.add(gp004);

        gp005.setGroupId("GAdmin");
        gp005.setGroupName("管理者グループ");
        gp005.setGroupType(GroupType.GROUP.getCode());
        groupList.add(gp005);

        param.setGroupList(groupList);

        List<Member> memberList = new ArrayList<Member>();
        Member mb001 = new Member();
        Member mb002 = new Member();
//        Member mb003 = new Member();

        mb001.setMemberId("admin");
        mb001.setGroupId("Administrator");
        memberList.add(mb001);

        mb002.setMemberId("admin");
        mb002.setGroupId("GAdmin");
        memberList.add(mb002);

        param.setMemberList(memberList);

        service.create(param);
        requestScope("message","登録しました");
        return forward(getReferer());
    }
}
