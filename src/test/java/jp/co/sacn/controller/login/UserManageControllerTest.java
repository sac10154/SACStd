package jp.co.sacn.controller.login;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

public class UserManageControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/login/userManage");
        UserManageController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
//        assertThat(tester.getDestinationPath(), is(nullValue()));
        assertThat(tester.getDestinationPath(), is("/users/"));
    }
}
