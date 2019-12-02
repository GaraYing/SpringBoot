package com.gara.yz.sb_log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SbLogApplicationTests {

	private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Test
	public void testContextLoad(){

	}

	@Test
	public void test() throws Exception {
		logger.info("输出info");
		logger.debug("输出debug");
		logger.error("输出error");
	}


}
