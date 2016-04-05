package org.braidner.libme.core.service;

import org.braidner.libme.core.CoreTestConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * @author KuznetsovNE/ 05.04.2016.
 */
public class AmazonServiceTest extends CoreTestConfig {
    private static final String TEST_FILE_KEY = "test_key";

    @Autowired
    private AmazonService amazonService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void upload() throws Exception {
        File file = new File("C:\\123.htm");
        assertTrue("Upload to aws failed", amazonService.upload(TEST_FILE_KEY, file));
        assertTrue("Delete from aws failed", amazonService.delete(TEST_FILE_KEY));
    }
}