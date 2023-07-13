package org.joonzis.mapper;


import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:WEB-INF/spring/root-context.xml")
public class TestMapperTests {

    @Setter(onMethod_= @Autowired)
    TestMapper mapper;

    @Test
    public void test() {
        log.info(mapper.TestSelect());
    }

}
