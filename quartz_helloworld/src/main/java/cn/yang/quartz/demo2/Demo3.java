package cn.yang.quartz.demo2;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import cn.yang.quartz.job.MyJob;

public class Demo3 {
	 public static void main(String[] args) {

         try {
        	 // 利用工厂类创建定时器对象
             Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
             // 定义工作对象
             JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1","group1").build();
              
             // 定义触发器
             SimpleTrigger trigger = TriggerBuilder.newTrigger()
            		 .withIdentity("trigger1","group1").startNow()
            		 .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
            		 .build();
             
             scheduler.scheduleJob(job, trigger);
             
             // 开启定时任务
             scheduler.start();
            

         } catch (SchedulerException se) {
             se.printStackTrace();
         }
     }
}
