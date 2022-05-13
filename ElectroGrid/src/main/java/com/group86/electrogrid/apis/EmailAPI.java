package com.group86.electrogrid.apis;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.group86.electrogrid.models.Email;

import com.group86.electrogrid.repositories.EmailRepository;


@Path("/api/emailmg")
public class EmailAPI {
	
	@Autowired
   EmailRepository emailRepository;
	
	@GET
    @Path("/getemail/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Email getEmailById(@PathParam("id") Long id){
		Optional<Email> email = emailRepository.findById(id);
        if(email.isPresent()){
            return email.get();
            //String jsonString = JSON.toJSONString(user);
            //return Response.status(Response.Status.OK).entity(jsonString).build();
        }else{
            return null;
        }
	
	}
	
	@GET
    @Path("/getallemails")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Email> GetAllEmails(){
         return emailRepository.findAll();
    }
	
	
	@POST
    @Path("/create_email")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createEmail(Email email){
		emailRepository.save(email);
        printEmail(email);
        
        String ret = "Email ID : "+ Long.toString(email.getId()) + "<br>" +
                "Email : "+ email.getEmail() + "<br>" +
                "Password : "+ email.getPassword()  + email.getPassword();
               

        return ret;
	}
	
	@POST
    @Path("/update_email")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateEmail(Email email){

		emailRepository.save(email);
        printEmail(email);

        return getString(email)+ "<br>Updated" ;
    }
	
	 @GET
	 @Path("/deleteemail/{id}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public String deleteEmail(@PathParam("id") Long id) {
	        Optional<Email> email = emailRepository.findById(id);
	        if (email.isPresent()) {
	        	emailRepository.delete(email.get());
	            return getString(email.get())+ "<br> Deleted Successfully";
	        } else {
	            return "Email not exists with id : "+ id;
	        }
	    }
	 
	 public void printEmail(Email email){
	        System.out.println("Email ID : "+ email.getId());
	        System.out.println("Email : "+ email.getEmail());
	        System.out.println("Password : "+ email.getPassword());
	        
	    }
	 
	 public String getString(Email email){
	        return  "Email ID : "+ Long.toString(email.getId()) + "<br>" +
	                "Email : "+ email.getEmail() + "<br>" +
	                "Password : "+ email.getPassword()  + email.getPassword();
	                
	    }
	
	
	
}

