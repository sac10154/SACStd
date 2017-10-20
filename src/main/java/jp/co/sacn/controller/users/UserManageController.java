package jp.co.sacn.controller.users;

import java.util.List;

import jp.co.sacn.common.GroupInfo;
import jp.co.sacn.service.users.UserManageParams;
import jp.co.sacn.service.users.UserManageResult;
import jp.co.sacn.service.users.UserManageService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class UserManageController extends Controller {

    private UserManageService service = new UserManageService();
    private UserManageParams param = new UserManageParams();
    private UserManageResult result = new UserManageResult();

    @Override
    public Navigation run() throws Exception {
    	List<GroupInfo> groupInfoList = service.select(param);
    	result.setGroupInfoList(groupInfoList);
    	requestScope("result",result);
    	return forward("userManage.jsp");
    }
}
