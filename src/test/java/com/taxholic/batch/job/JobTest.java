package com.taxholic.batch.job;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.taxholic.batch.configuration.AnnotationConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AnnotationConfiguration.class})
public class JobTest {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	@Qualifier("job1")
	private Job job;
	
	
	@Test
	public void job() throws Exception {
		
		logger.debug("-------------------------------------------------------------------------------> start");
		
		
		JobParameters jobParameters = new JobParametersBuilder()
				.addDate("date",new Date())
				.addString("param","존나더워")
				.toJobParameters();
		
		jobLauncher.run(job, jobParameters);
		
		logger.debug("-------------------------------------------------------------------------------> end");
	}
	
}
