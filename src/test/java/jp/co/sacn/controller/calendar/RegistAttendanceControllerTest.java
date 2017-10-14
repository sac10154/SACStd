package jp.co.sacn.controller.calendar;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

public class RegistAttendanceControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/calendar/RegistAttendance");
        RegistAttendanceController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
}
