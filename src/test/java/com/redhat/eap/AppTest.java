package com.redhat.eap;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void size() throws Exception {
        App app = new App();
        for (int i = 0; i < 10; i++) {
            app.leakIt("testname");
        }
        Assert.assertEquals("size should be 1", 1, app.size());
    }

}