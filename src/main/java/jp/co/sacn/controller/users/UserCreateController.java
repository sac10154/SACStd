package jp.co.sacn.controller.users;

import jp.co.sacn.service.users.RegistEmployeeParams;
import jp.co.sacn.service.users.RegistEmployeeService;
import jp.co.sacn.util.StringUtils;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.ApplicationMessage;
import org.slim3.util.BeanUtil;

public class UserCreateController extends Controller {

	/** 社員のService */
    private RegistEmployeeService service = new RegistEmployeeService();

    /** 社員のパラメータ */
    private RegistEmployeeParams param = new RegistEmployeeParams();

    @Override
    public Navigation run() throws Exception {
        BeanUtil.copy(request, param);
        if(StringUtils.isNull(param.getUserId())||
                StringUtils.isNull(param.getPassword())){
            errors.put("message", ApplicationMessage.get("error.users.invalid.input"));
            return forward(basePath);
        }
        service.create(param);

        return forward(basePath);
    }
}
