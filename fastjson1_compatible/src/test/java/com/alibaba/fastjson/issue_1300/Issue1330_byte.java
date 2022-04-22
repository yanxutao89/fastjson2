package com.alibaba.fastjson.issue_1300;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by wenshao on 30/07/2017.
 */
public class Issue1330_byte {
    @Test
    public void test_for_issue() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":\"ABC\"}", Model.class);
        } catch (JSONException e) {
            error = e;
        }
        assertNotNull(error);
//        assertTrue(error.getMessage().indexOf("parseByte error, field : value") != -1);
    }

    @Test
    public void test_for_issue_1() throws Exception {
        Exception error = null;
        try {
            JSON.parseObject("{\"value\":[]}", Model.class);
        } catch (JSONException e) {
            error = e;
        }
        assertNotNull(error);
//        assertTrue(error.getMessage().indexOf("parseByte error, field : value") != -1);
    }

    @Test
    public void test_for_issue_2() throws Exception {
        JSON.parseObject("{\"value\":{}}", Model.class);
    }

    public static class Model {
        public byte value;
    }
}
