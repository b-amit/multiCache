package cms;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class FIFOCache extends Cache {

    public FIFOCache(int capa, int rt, int wt) {
        super(capa, rt, wt);
        data = new LinkedHashMap<>(CAPACITY);
    }

    @Override
    public Response readWrite(String key, String value) {

        Response response = read(key);
        int totalTime = 0;

        boolean succ = response.isSuccess();

        totalTime += response.getTimetaken();

        Response resp;
        if (succ == false || !value.equals(response.getValue())) {

            resp = write(key, value);
            totalTime += resp.getTimetaken();
            resp = new Response(totalTime, null, true);
        } else {
            resp = new Response(totalTime, null, false);
        }

        return resp;
    }

    @Override
    public Response write(String key, String value) {

        if (data.size() == CAPACITY) {
            Iterator<String> it = data.keySet().iterator();
            String k;
            if (it.hasNext()) {
                k = it.next();
                data.remove(k);
            }
        }

        data.put(key, value);
        Response resp = new Response(WRITE_TIME, null, true);
        return resp;
    }

    @Override
    public Response read(String key) {

        String val = data.get(key);
        Response resp;

        if (val == null) {
            resp = new Response(READ_TIME, null, false);
        } else {
            resp = new Response(READ_TIME, val, true);
        }

        return resp;
    }

}
