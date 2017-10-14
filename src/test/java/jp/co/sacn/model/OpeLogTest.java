package jp.co.sacn.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class OpeLogTest extends AppEngineTestCase {

    private OpeLog model = new OpeLog();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
