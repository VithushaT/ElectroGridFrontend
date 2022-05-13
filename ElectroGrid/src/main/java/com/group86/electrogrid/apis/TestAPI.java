package com.group86.electrogrid.apis;



import org.springframework.stereotype.Component;
import com.group86.electrogrid.gmail.GmailQuickstart;


import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.ListLabelsResponse;
import com.google.api.services.gmail.model.Label;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Path("/api/test")
public class TestAPI {

    /*private static final JsonFactory JSON_FACTORY = null;*/
	@GET
    @Path("/hello")
    public String hello(){
        return  "Hello From Server";
    }

    @GET
    @Path("/time")
    public String time(){
        String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
        return timeStamp;
    }

    @GET
    @Path("/echo/{input1}/{input2}")
    public String echo(@PathParam("input1") String input1 , @PathParam("input2") String input2 ){
        return "You have typed -> <br>1."+ input1 + "<br>2." + input2;
    }
    /*
    public void gmailTest(){
    	  System.out.println("Gmail test");

    	  List<String> SCOPES = new ArrayList<String>(GmailScopes.all());
    	  // List<String> SCOPES = GmailScopes.all();
    	  InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Program Name-12345678.json");

    	  try {
    	  if(resourceAsStream != null) {
    	    NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

    	    System.out.println("Reading credential file");
    	    GoogleCredential credential = GoogleCredential.fromStream(resourceAsStream);
    	    System.out.println("Creating scopes");
    	    credential = credential.createScoped(SCOPES);

    	    System.out.println("building gmail api service");
    	    Gmail gmailService = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName("ept-mailer").build();
    	    String user = "deusrex@mygenericdomain.com";

    	    System.out.println("calling gmail api");
    	    ListLabelsResponse listResponse = gmailService.users().labels().list(user).execute();
    	    System.out.println("call did not error");
    	    List<Label> labels = listResponse.getLabels();
    	    if (labels.isEmpty()) {
    	      System.out.println("No labels found.");
    	    } else {
    	      System.out.println("Labels:");
    	      for (Label label : labels) {
    	        System.out.printf("- %s\n", label.getName());
    	      }
    	    }
    	  }
    	  }
    	  catch (Exception ex) {
    		  System.out.println(ex.getMessage());
    	  }
    	  */
    
    
    
	@GET
    @Path("/sg")
    public String gmail(){
		GmailQuickstart gmailQuickstart = new GmailQuickstart();
        return gmailQuickstart.sendTestMail("it20158668@my.sliit.lk","Electrogid","Your bill is 500 LKR");
    }
    	  



}
