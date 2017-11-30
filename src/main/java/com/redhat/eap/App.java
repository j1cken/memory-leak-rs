package com.redhat.eap;

import javax.ws.rs.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Hello world!
 */
@Path("/")
public class App {

    private static Map<MyLeakingObject, String> leakingMap = new HashMap<>();

    @Path("/leakIt")
    public String leakIt() {
        for (int i = 0; i < 10000; i++) {
            leakingMap.put(new MyLeakingObject("aname"), UUID.randomUUID().toString());
        }
        return "{ 'count': '" + leakingMap.size() + "' }";
    }

    private class MyLeakingObject {
        private String name;

        public MyLeakingObject(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
