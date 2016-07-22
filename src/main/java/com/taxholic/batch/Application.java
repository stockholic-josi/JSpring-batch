package com.taxholic.batch;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
//       SpringApplication.run(Application.class, args);
    	
    	 SpringApplication app = new SpringApplication(Application.class);
         app.setWebEnvironment(false);
         ConfigurableApplicationContext ctx= app.run(args);
         JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
         JobParameters jobParameters = new JobParametersBuilder()
             .addDate("date", new Date())
             .addString("param", "vvvv")
             .toJobParameters();

         if(args.length > 0 ){
             jobLauncher.run(ctx.getBean(args[0],  Job.class), jobParameters);   
         } else {
             jobLauncher.run(ctx.getBean("job1",  Job.class), jobParameters);   

         } 
         
    	System.exit(0);

    }
}
