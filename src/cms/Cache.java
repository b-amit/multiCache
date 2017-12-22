package cms;

import java.util.Map;

public abstract class Cache {

    protected Map<String, String> data;
    protected final int CAPACITY;
    protected final int READ_TIME;
    protected final int WRITE_TIME;

    public Cache(int capa, int rt, int wt) {
        CAPACITY = capa;
        READ_TIME = rt;
        WRITE_TIME = wt;
    }

    abstract Response readWrite(String key, String value);

    abstract Response write(String key, String value);

    abstract Response read(String key);

}
