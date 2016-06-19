package hello;

public class MatlabUpdate {

	private final boolean success;
	private final long id;
	private final String data;

    public MatlabUpdate(long id, boolean success, String data) {
        this.id = id;
        this.success=success;
        this.data=data;
    }

    public long getId() {
        return id;
    }
    
    public boolean getSuccess() {
        return success;
    }
    
    public String getData(){
    	return data;
    }
}
