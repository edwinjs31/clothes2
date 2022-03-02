package com.albares.clothes.api;

import com.albares.clothes.db.Product;
import com.albares.clothes.utils.*;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

@Path("/admin")

public class AdminService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProduct(Product product) throws NoSuchAlgorithmException {
        Response r = new Response();
        try {
            Db myDb = new Db();
            myDb.connect();
            product.insertProduct_DB(myDb);
            myDb.disconnect();
            r.setResponseCode(ResponseCode.OK);
        } catch (SQLException e) {
            r.setResponseCode(ResponseCode.ERROR);
        }
        return r;
    }

    @GET
    @Path("/brand/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductsBrand(@PathParam("id") int id) {
        Response r = new Response();
        try {
            Db myDb = new Db();
            myDb.connect();
            List<Product> products = Product.selectAllProductsBrand_DB(myDb, id);
            myDb.disconnect();

            r.setProducts(products);
            r.setResponseCode(ResponseCode.OK);
        } catch (SQLException e) {
            r.setResponseCode(ResponseCode.ERROR);
        }
        return r;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        Response r = new Response();
        try {
            Db myDb = new Db();
            myDb.connect();
            List<Product> products = Product.selectAllProducts_DB(myDb);
            myDb.disconnect();
            r.setProducts(products);

            r.setResponseCode(ResponseCode.OK);
        } catch (SQLException e) {
            r.setResponseCode(ResponseCode.ERROR);
        }
        return r;
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(Product product) {
        Response r = new Response();
        try {
            Db myDb = new Db();
            myDb.connect();
            product.editProduct_DB(myDb);
            myDb.disconnect();

            r.setResponseCode(ResponseCode.OK);
        } catch (SQLException e) {
            r.setResponseCode(ResponseCode.ERROR);
        }
        return r;
    }

}
