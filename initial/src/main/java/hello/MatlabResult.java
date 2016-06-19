package hello;

public class MatlabResult {

	private final long id;
	private final String data;

    public MatlabResult(long id, String data) {
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
