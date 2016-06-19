package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static boolean requestState=false;
    private static String matlabResult="";
    private static String requestData="";

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	requestState=true;
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    @RequestMapping("/matlabupdaterequest")
    public MatlabUpdate matlabupdate() {
        return new MatlabUpdate(counter.incrementAndGet(),requestState,requestData);
    }
    
    @RequestMapping("/matlabpostresult")
    public MatlabResult matlabresult(@RequestParam(value="data", defaultValue="") String data) {
    	matlabResult=data;
    	requestData="";
    	requestState=false;
        return new MatlabResult(counter.incrementAndGet(),matlabResult);
    }
    
    @RequestMapping("/calculationrequest")
    public CalculationRequest calculationrequest(@RequestParam(value="data", defaultValue="") String data) {
    	requestData=data;
    	requestState=true;
    	
    	while(requestState){
    		try {
    		    Thread.sleep(100);                 //1000 milliseconds is one second.
    		} catch(InterruptedException ex) {
    		    Thread.currentThread().interrupt();
    		}
    	}
    	
        return new CalculationRequest(counter.incrementAndGet(), matlabResult);
    }
    
}