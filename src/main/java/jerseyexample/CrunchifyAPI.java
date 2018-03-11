package jerseyexample;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.json.simple.JSONObject;


    @Path("api")
    public class CrunchifyAPI {

        @SuppressWarnings("unchecked")
        @GET
        @Path("/get")
        @Consumes(MediaType.TEXT_PLAIN)
        public String get(
                @DefaultValue("111") @QueryParam("user") Integer user,
                @Context UriInfo uriInfo
                ) {
            System.out.println("Data Received: " + uriInfo.getRequestUri().getQuery()
                    + " | " + user);
            JSONObject obj = new JSONObject();
            obj.put("auth", true);
            obj.put("user", user);
            String ret = JSONObject.toJSONString(obj);
            return ret;
        }	
    }
