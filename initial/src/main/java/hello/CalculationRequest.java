package hello;

public class CalculationRequest {
	private final long id;
	private final String data;

    public CalculationRequest(long id, String data) {
        this.id = id;
        this.data=data;
    }

    public long getId() {
        return id;
    }
    
    public String getData(){
    	return data;
    }
}
