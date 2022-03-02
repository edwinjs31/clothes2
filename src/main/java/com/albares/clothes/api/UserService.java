package com.albares.clothes.api;

import com.albares.clothes.db.Product;
import com.albares.clothes.utils.*;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

@Path("/user")

public class UserService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response buyProduct(Product product) throws NoSuchAlgorithmException {
        Response r = new Response();
        try {
            Db myDb = new Db();
            myDb.connect();
            r.setResponseCode(product.buyProduct_DB(myDb));
            myDb.disconnect();

        } catch (SQLException e) {
            r.setResponseCode(ResponseCode.ERROR);
        }
        return r;
    }

    @GET
    @Path("/{gender}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsStock(@PathParam("gender") int gender) {
        Response r = new Response();
        try {
            Db myDb = new Db();
            myDb.connect();
            List<Product> products=Product.selectAllProductsGender_DB(myDb, gender);
            myDb.disconnect();
            
            r.setProducts(products);
            r.setResponseCode(ResponseCode.OK);
        } catch (SQLException e) {
            r.setResponseCode(ResponseCode.ERROR);
        }
        return r;
    }
}
