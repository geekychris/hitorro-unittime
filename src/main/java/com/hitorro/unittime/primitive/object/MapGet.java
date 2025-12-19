package com.hitorro.unittime.primitive.object;

import com.hitorro.util.core.string.Fmt;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MapGet extends ObjectTimers {

    static Map<String, String> map = new HashMap();


    public MapGet() {
        super("get from apply");
        setIterations(50);

        for (int i = 0; i < 1000; i++) {
            map.put(Fmt.S("%s", i), Fmt.S("%s", i));
        }

    }

    public void test() throws Exception {
        String foo;
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");
        foo = map.get("555");

    }

    class TenFieldClass {


    }
}
