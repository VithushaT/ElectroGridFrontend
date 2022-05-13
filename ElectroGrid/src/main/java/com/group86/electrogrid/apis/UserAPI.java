package com.group86.electrogrid.apis;


import com.group86.electrogrid.models.User;
import com.group86.electrogrid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/api/usermg")
public class UserAPI {

    @Autowired
    UserRepository userRepository;


    @GET
    @Path("/getuser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
            //String jsonString = JSON.toJSONString(user);
            //return Response.status(Response.Status.OK).entity(jsonString).build();
        }else{
            return null;
        }

    }

    @GET
    @Path("/getallusers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> GetAllUsers(){
         return userRepository.findAll();
    }

    @POST
    @Path("/create_user")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUser(User user){

        userRepository.save(user);
        printUser(user);

        String ret = "User ID : "+ Long.toString(user.getId()) + "<br>" +
                "Username : "+ user.getUsername() + "<br>" +
                "Password : "+ user.getPassword()  + user.getPassword()  + "<br>" +
                "Email : "+ user.getEmail() ;

        return ret;
    }


    @POST
    @Path("/update_user")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateUser(User user){

        userRepository.save(user);
        printUser(user);

        return getString(user)+ "<br>Updated" ;
    }


    @GET
    @Path("/deleteuser/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteUser(@PathParam("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return getString(user.get())+ "<br> Deleted Successfully";
        } else {
            return "User not exists with id : "+ id;
        }
    }

    public void printUser(User user){
        System.out.println("User ID : "+ user.getId());
        System.out.println("Username : "+ user.getUsername());
        System.out.println("Password : "+ user.getPassword());
        System.out.println("Email : "+ user.getEmail());
    }

    public String getString(User user){
        return  "User ID : "+ Long.toString(user.getId()) + "<br>" +
                "Username : "+ user.getUsername() + "<br>" +
                "Password : "+ user.getPassword()  + user.getPassword()  + "<br>" +
                "Email : "+ user.getEmail() ;
    }


}
