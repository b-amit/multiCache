package cms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CMS {

    public static void main(String[] args) {

        Strategy stgy = Strategy.FIFO;
        Scanner sin = new Scanner(System.in);
        CacheFactory cf = new CacheFactory();

        int noOfCache = sin.nextInt();
        List<Cache> caches = new ArrayList<>(noOfCache);

        InputData[] input = new InputData[noOfCache];

        for (int i = 0; i < noOfCache; i++) {
            InputData indata = new InputData();
            indata.CAPACITY = sin.nextInt();
            input[i] = indata;
        }

        for (int i = 0; i < noOfCache; i++) {
            input[i].READ_TIME = sin.nextInt();
        }

        for (int i = 0; i < noOfCache; i++) {
            input[i].WRITE_TIME = sin.nextInt();
        }

        for (int i = 0; i < noOfCache; i++) {
            InputData ind = input[i];
            caches.add(cf.getCache(stgy, ind.CAPACITY, ind.READ_TIME, ind.WRITE_TIME));
        }

        CacheRW crw = new CacheRW(caches);

        while (true) {
            String op = sin.next();

            if (op.equalsIgnoreCase(Operation.WRITE.name())) {

                String key = sin.next();
                String val = sin.next();

                crw.write(key, val);

            } else if (op.equalsIgnoreCase(Operation.READ.name())) {

                String key = sin.next();
                crw.read(key);
            }
        }

    }

}
