package org.acme.quickstart;


import javax.inject.Inject;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jboss.resteasy.annotations.jaxrs.PathParam;


@Path("/Present")
public class ChristmasPresentAlgorithm {

	@Inject
    GreetingService service;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public String greeting(@PathParam String name) {
        return service.greeting(name);
    	}
    
    @GET
    @Path("/productvalues")
    public String Produkte() {
    	String csvFileProdukte = "/Users/soeren.kleideiter/getting-started/src/main/java/org/acme/quickstart/Produkte.csv";
    	String line = "";
    	String cvsSplitBy =",";
    	
    	try (BufferedReader br = new BufferedReader(new FileReader(csvFileProdukte))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] ProduktValues = line.split(cvsSplitBy);

                System.out.println(ProduktValues);
                
            }
            String Produkte = "done";
            return Produkte;

        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
    }
    
    
    
    
    
    @Inject
    HelloVoice hello;
    @Inject
    AgeVoice yourAge;
    @Inject
    GenderVoice yourGender;
    @Inject
    Tag1Voice yourTag1;
    @Inject
    Tag2Voice yourTag2;
    @Inject
    Tag3Voice yourTag3;
    @Inject
    InstaVoice yourInsta;
    @Inject
    MainCatVoice yourMainCat; 
    
    @GET
    @Path("/query")
    public String MainInfos(
    		@QueryParam("name") String name,
    		@QueryParam("age") String age,
    		@QueryParam("gender") String gender,
    		@QueryParam("insta") String insta,
    		@QueryParam("tag1") String tag1,
    		@QueryParam("tag2") String tag2,
    		@QueryParam("tag3") String tag3,
    		@QueryParam("maincat") String maincat)
    		{ 
    	
    	return hello.getUserName(name) + yourAge.getUserAge(age) + yourGender.getUserGender(gender) + yourTag1.getUserTag1(tag1) + yourTag2.getUserTag2(tag2) + yourTag3.getUserTag3(tag3) + yourInsta.getUserInsta(insta) + yourMainCat.getUserMainCat(maincat);
        }
    
    
/* @Inject
    AgeVoice yourAge;
    
    @GET
    @Path("/query")
    public String getUserAge(
    		@QueryParam("age") String age) {
    	return yourAge.getUserAge(age);
    } */ 
}


    				