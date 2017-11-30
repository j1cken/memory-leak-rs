package com.redhat.eap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Hello world!
 */
@Path("/")
public class App {

    private static Map<MyLeakingObject, String> leakingMap = new HashMap<>();

    @GET
    @Path("/leakIt")
    @Produces(MediaType.APPLICATION_JSON)
    public String leakIt(@QueryParam("name") String name) {
        String uuid = UUID.randomUUID().toString();
        leakingMap.put(new MyLeakingObject(name), uuid);
        return "{ 'name':'" + name + "', 'uuid':'" + uuid + "' }";
    }

    @GET
    @Path("/size")
    public int size() {
        return leakingMap.size();
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
