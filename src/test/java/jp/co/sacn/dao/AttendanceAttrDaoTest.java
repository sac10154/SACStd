package jp.co.sacn.dao;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AttendanceAttrDaoTest extends AppEngineTestCase {

    private AttendanceAttrDao dao = new AttendanceAttrDao();

    @Test
    public void test() throws Exception {
        assertThat(dao, is(notNullValue()));
    }
}
