package cms;

public class CacheFactory {

    public Cache getCache(Strategy sType, int cap, int rt, int wt) {

        switch (sType) {

        case FIFO:
            return new FIFOCache(cap, rt, wt);

        default:
            return new FIFOCache(cap, rt, wt);
        }
    }
}
