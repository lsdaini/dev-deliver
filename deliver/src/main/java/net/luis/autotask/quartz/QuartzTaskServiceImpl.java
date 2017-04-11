package net.luis.autotask.quartz;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @CreateTime：2017年3月28日 下午4:41:59
 * @Author sai.liu
 * @ProjectPackage：net.luis.autotask.quartz.QuartzTaskServiceImpl.java
 * @Description：
 */

public class QuartzTaskServiceImpl extends QuartzJobBean {
	
	protected void executeInternal(JobExecutionContext jec) throws JobExecutionException {
		
	}

	public void getQuartzTaskBean() {
		System.out.println("getQuartzTaskBean 调用的定时任务..."+new Date());
	}
}