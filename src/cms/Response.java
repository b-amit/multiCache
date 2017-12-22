package cms;

public class Response {

    private int timetaken;

    private String value;
    private boolean success;

    public Response(int tt, String val, boolean ss) {
        timetaken = tt;
        value = val;
        setSuccess(ss);
    }

    public int getTimetaken() {
        return timetaken;
    }

    public void setTimetaken(int timetaken) {
        this.timetaken = timetaken;
    }

    public void addTimetaken(int timetaken) {
        this.timetaken += timetaken;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
