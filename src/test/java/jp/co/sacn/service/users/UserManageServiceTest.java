package jp.co.sacn.service.users;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UserManageServiceTest extends AppEngineTestCase {

    private UserManageService service = new UserManageService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
