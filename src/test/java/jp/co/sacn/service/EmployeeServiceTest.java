package jp.co.sacn.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

public class EmployeeServiceTest extends AppEngineTestCase {

    private EmployeeService service = new EmployeeService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
