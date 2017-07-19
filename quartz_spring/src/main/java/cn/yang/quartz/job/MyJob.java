package cn.yang.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.yang.quartz.service.QuartzService;

public class MyJob extends QuartzJobBean{

	@Autowired
	QuartzService quartzService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		quartzService.sayHello();
	}
	


}
