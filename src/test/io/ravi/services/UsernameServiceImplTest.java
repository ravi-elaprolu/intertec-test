package io.ravi.services;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:test-config.xml")
public class UsernameServiceImplTest {
    @Autowired
    UsernameService usernameService;

    @Autowired
    BlackListedService blackListedService;

    @Test
    public void shouldFailIfDuplicatedName() throws Exception {
        Result<Boolean, List<String>>  result0 = usernameService.checkUsernameAndSave("johnjohn");
        Assert.assertTrue(result0.getValue());

        Result<Boolean, List<String>>  result1 = usernameService.checkUsernameAndSave("johnjohn");
        Assert.assertFalse(result1.getValue());
        Assert.assertEquals(result1.getNames().size(),14);

    }

    @Test
    public void shouldFailIfBlacklistedName() throws Exception {
        Result<Boolean, List<String>>  result0 = usernameService.checkUsernameAndSave("cannabis");
        Assert.assertFalse(result0.getValue());
    }

}