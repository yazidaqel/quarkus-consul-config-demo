package org.acme.quarkus.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import javax.inject.Provider;

@Path("/hello")
public class HelloResource {


    @ConfigProperty(name = "testKey", defaultValue = "Not Yet configured")
    private Provider<String> testKey;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello from config: "+testKey.get();
    }
}