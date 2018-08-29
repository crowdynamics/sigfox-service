package test.crowdynamics.sigfox.dao;

import com.crowdynamics.sigfox.model.SigfoxMessagesEntity;
import com.crowdynamics.sigfox.repository.SigfoxMessageDAO;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = {DataAccessITTestContext.class})
public class DataAccessITTestRunner {

    @Autowired
    private SigfoxMessageDAO sigfoxMessageRepository;

    @Test
    public void contextStarts() {
        Assert.assertNotNull(sigfoxMessageRepository);
    }

    @Test
    public void testFindAll(){
        List<SigfoxMessagesEntity> sigfoxMessagesEntityList= sigfoxMessageRepository.findAll();

        Assert.assertNotNull(sigfoxMessagesEntityList);
        Assert.assertTrue(sigfoxMessagesEntityList.size()>0);
    }
}
