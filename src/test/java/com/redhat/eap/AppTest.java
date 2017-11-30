package com.redhat.eap;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void leakIt() throws Exception {
        Assert.assertEquals("count should be one", "{ 'count': '1' }", new App().leakIt());
    }

}