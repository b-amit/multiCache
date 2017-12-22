package cms;

import java.util.List;

public class CacheRW {

    private List<Cache> caches;

    CacheRW( List<Cache> caches ){
        this.caches = caches;
    }

    public void write(String key, String val) {

        int tt = 0;

        for (Cache cache : caches) {

            Response resp = cache.readWrite(key, val);
            tt += resp.getTimetaken();

            if (!resp.isSuccess()) {
                break;
            }
        }

        System.out.println("Write time : " + tt);
    }

    public void read(String key) {

        int tt = 0;

        Cache found = null;
        Response resp = null;
        String valu = null;

        for (Cache cache : caches) {

            resp = cache.read(key);
            tt += resp.getTimetaken();

            if (resp.isSuccess()) {
                valu = resp.getValue();
                found = cache;
                break;
            }
        }

        if (found != null) {

            for (Cache cache : caches) {

                if (cache == found) {
                    break;
                }

                resp = cache.write(key, valu);
                tt += resp.getTimetaken();
            }

        }

        if (valu != null) {
            System.out.println("Value at " + key + " is " + valu);
        } else {
            System.out.println("Value for " + key + " not found");
        }
        System.out.println("Read time : " + tt);

    }

}
