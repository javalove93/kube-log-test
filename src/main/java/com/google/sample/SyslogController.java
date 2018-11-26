package com.google.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//	curl http://localhost:8888/sample/hello
@RestController
@RequestMapping(value = "/syslog")
public class SyslogController {
	private static final Logger LOG = LoggerFactory.getLogger(SyslogController.class);

	private int count = 0;
	
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String isRunning() {
        return "I'm Alive!";
    }

    @RequestMapping(value = "/udp", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String fileLogging() {
    	Thread[] worker = new Thread[100];
    	
    	long startTime = System.currentTimeMillis();
    	
		count = 0;
    	for(int i = 0; i < worker.length; i++) {
    		worker[i] = new Thread() {
    			public void run() {
    				for (int i = 0; i < 50000; i++) {
    					LOG.info("{} : sdklfadljkdsljkfdsljkfdlsjfjlksljfksadjklasjdkl", i);
    					count++;
    					
    					if(count % 10000 == 0) {
    						System.out.println("Count: " + count);
    					}
    				}
    			}
    		};
    		
    		worker[i].start();
    	}
    	
    	for(int i = 0; i < worker.length; i++) {
    		try {
				worker[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	long endTime = System.currentTimeMillis();
    	
        return "Elapsed: " + (endTime - startTime) + "\n";
    }


}
