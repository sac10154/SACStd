package jp.co.sacn.controller.users;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BackControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/users/back");
        BackController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
//        assertThat(tester.getDestinationPath(), is(nullValue()));
        assertThat(tester.getDestinationPath(), is("/"));
    }
}
