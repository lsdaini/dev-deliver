package deliver;

import java.io.FileNotFoundException;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

/**
*@CreateTime：2017年4月7日 上午10:50:30
*@Author sai.liu
*@ProjectPackage：deliver.Log4jConfigurerRun.java
*@Description：
*/

public class Log4jConfigurerRun extends SpringJUnit4ClassRunner {
    public Log4jConfigurerRun(Class<?> clazz) throws InitializationError {
		super(clazz);
	}
	static {
        try {
          Log4jConfigurer.initLogging("classpath:properties/log4j.properties");
        } catch (FileNotFoundException ex) {
          System.out.println("Cannot Initialize, log4j File NotFound!");
        }
      }
}
