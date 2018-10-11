package com.h2rd.refactoring.web;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.usermanagement.UserDao;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.h2rd.refactoring.usermanagement.User_Service;
import com.h2rd.refactoring.usermanagement.Validating_data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Path("/users")
@Repository
public class UserResource{

    public UserDao userDao;

    @Autowired
    private User_Service user_service = new User_Service();
    @POST
    @Path("add/")
    public Response addUser(@QueryParam("name") String name,
                            @QueryParam("email") String email,
                            @QueryParam("role") List<String> roles) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setRoles(roles);
        ArrayList<String> validations_defined = new Validating_data().validate_User(user);
        if (validations_defined.size() > 0) {
            return Response.status(Response.Status.FORBIDDEN).entity(validations_defined).build();
        }

        if (user_service.isUserExist(user)) {
            return Response.status(Response.Status.CONFLICT).entity("User '" + user.getEmail() + "' already exist.")
                    .build();
        }

        user_service.saveUser(user);
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("update/")
    public Response updateUser(@QueryParam("name") String name,
                               @QueryParam("email") String email,
                               @QueryParam("role") List<String> roles) {

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setRoles(roles);

        ArrayList<String> validations_defined = new Validating_data().validate_User(user);
        if (validations_defined.size() > 0) {
            return Response.status(Response.Status.FORBIDDEN).entity(validations_defined).build();
        }
        if (!user_service.isUserExist(user)) {
            return Response.status(Response.Status.CONFLICT).entity("User '" + user.getEmail() + "' already exist.")
                    .build();
        }

        user_service.updateUser(user);
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("delete/")
    public Response deleteUser(@QueryParam("name") String name,
                               @QueryParam("email") String email,
                               @QueryParam("role") List<String> roles) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setRoles(roles);

        ArrayList<String> validations_defined = new Validating_data().validate_User(user);
        if (validations_defined.size() > 0) {
            return Response.status(Response.Status.FORBIDDEN).entity(validations_defined).build();
        }
        if (user_service.isUserExist(user)) {
            return Response.status(Response.Status.CONFLICT).entity("User '" + user.getEmail() + "' already exist.")
                    .build();
        }

        userDao.deleteUser(user);
        return Response.ok().entity(user).build();
    }

    @GET
    @Path("find/")
    public Response getUsers() {

    	List<User> users = user_service.getUsers();
    	if (users == null) {
            return Response.status(Response.Status.FORBIDDEN).entity("User not found.").build();
    	}

        GenericEntity<List<User>> usersEntity = new GenericEntity<List<User>>(users) {};
        return Response.status(200).entity(usersEntity).build();
    }

    @GET
    @Path("search/")
    public Response findUser(@QueryParam("email") String email) {
        User user = user_service.findUserByEmail(email);
        if (user == null) {
            return Response.status(Response.Status.FORBIDDEN).entity("User not found.").build();
        }
        return Response.ok().entity(user).build();
    }
}
