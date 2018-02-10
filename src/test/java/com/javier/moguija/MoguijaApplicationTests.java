package com.javier.moguija;

import javax.persistence.EntityManager;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public abstract class MoguijaApplicationTests {

    @Autowired
    protected JdbcTemplate jdbcTemplate;
    @Autowired
    protected EntityManager entityManager;

}
