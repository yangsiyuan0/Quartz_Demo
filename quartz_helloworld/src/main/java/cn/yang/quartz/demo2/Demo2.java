package cn.yang.quartz.demo2;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import cn.yang.quartz.job.MyJob;

public class Demo2 {
	 public static void main(String[] args) {

         try {
        	 // 利用工厂类创建定时器对象
             Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
             // 定义工作对象
             JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1","group1").build();
              
             // 定义触发器
             CronTrigger cronTrigger = TriggerBuilder.newTrigger()
            		 .withIdentity("trigger1","group1")
            		 .withSchedule(CronScheduleBuilder.cronSchedule("0 0/5 * * * ? "))
            		 .build();
             
             scheduler.scheduleJob(job, cronTrigger);
             
             // 开启定时任务
             scheduler.start();
            

         } catch (SchedulerException se) {
             se.printStackTrace();
         }
     }
}
