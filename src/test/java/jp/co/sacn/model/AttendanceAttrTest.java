package jp.co.sacn.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AttendanceAttrTest extends AppEngineTestCase {

    private AttendanceAttr model = new AttendanceAttr();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
