package jp.co.sacn.controller.users;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UserManageControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/users/userManage");
        UserManageController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
}
