package cn.yang.quartz.demo1;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class Demo1 {
	 public static void main(String[] args) {

         try {
        	 // 利用工厂类创建定时器对象
             Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
             // 开启定时任务
             scheduler.start();
             // 关闭定时任务
             scheduler.shutdown();
         } catch (SchedulerException se) {
             se.printStackTrace();
         }
     }
}
