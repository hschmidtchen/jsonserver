package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private final String matlabRequets = "matlabUpdate";
	private boolean readyForUpdate = true;
	
	

    private static final String template = "Hello, %s!";



    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/matlabUpdate")
    public String MatlabUpdate(){
    	 return "Tobi ist super";
    }
}
