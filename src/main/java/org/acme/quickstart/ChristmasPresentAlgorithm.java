package org.acme.quickstart;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.HashMap;
import java.util.Map.Entry;

//Path "/Present"
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
    //Path "/productvalues
    @GET
    @Path("/productvalues")
    public String Produkte() {
    	URL csvFileProdukte = this.getClass().getResource("/data/Produkte.csv");
    	String line = "";
    	String cvsSplitBy =",";
    	
    	HashMap<String, String> productvalues = new HashMap<String, String>();
    	 	
    	
    	try (BufferedReader br = new BufferedReader(new FileReader(csvFileProdukte.getPath())) {
    	int LineCount = 0;
    	String[] headerList = null;
            while ((line = br.readLine()) != null) {
            	if (LineCount == 0) {
            		headerList = line.split(cvsSplitBy);
            		LineCount++;
            	}
            	else { 
            	// use comma as separator
                String[] ProduktValues = line.split(cvsSplitBy);
                
                int index = 0;
                
                for(String produktValue: ProduktValues )
                {
                	String keyName = ProduktValues[0] + "_" + headerList[index];
                    productvalues.put(keyName, ProduktValues[index]);
                    index++;
                }
                
                             
                
               
            	}
            }
            System.out.println(productvalues);
            String CasioUhr = productvalues.get("Casio Uhr_0_10");
            System.out.println(CasioUhr);
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
    @Inject
    OsVoice yourOs;
    //Path "/query"
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    @Path("/query")
    
    public String MainInfos(
    		@DefaultValue("") @QueryParam("name") String name,
    		@DefaultValue("") @QueryParam("age") String age,
    		@DefaultValue("") @QueryParam("gender") String gender,
    		@DefaultValue("") @QueryParam("insta") String insta,
    		@DefaultValue("") @QueryParam("tag1") String tag1,
    		@DefaultValue("") @QueryParam("tag2") String tag2,
    		@DefaultValue("") @QueryParam("tag3") String tag3,
    		@DefaultValue("") @QueryParam("maincat") String maincat,
    		@DefaultValue("") @QueryParam("os") String os)
    		{ 
    	
    	//HASH TABLE FUNCTIONS//
    	String csvFileProdukte = "/Users/soeren.kleideiter/getting-started/src/main/java/org/acme/quickstart/Produkte.csv";
    	String line = "";
    	String cvsSplitBy =",";
    	
    	HashMap<String, String> productvalues = new HashMap<String, String>();
    	HashMap<String, Integer> ResultsTable = new HashMap<String, Integer>();
    	
    	
    	String ErrorMessage = "<br> <br> <br> <br> <br> If you've made mistakes, or typed something wrong, it would come up here: <br>";
    	String YourProduct = "<br> We recommend you the following product: ";
    	String MerryChristmas = "<br> <b> <i>Merry Christmas! </b> </i> 🎄";
    	
    	
    	try (BufferedReader br = new BufferedReader(new FileReader(csvFileProdukte))) {
    	int LineCount = 0;
    	String[] headerList = null;
            while ((line = br.readLine()) != null) {
            	if (LineCount == 0) {
            		headerList = line.split(cvsSplitBy);
            		LineCount++;
            	}
            	else { 
            	// use comma as separator
                String[] ProduktValues = line.split(cvsSplitBy);
                
                int index = 0;
                
                for(String produktValue: ProduktValues )
                {
                	String keyName = ProduktValues[0] + "_" + headerList[index];
                    productvalues.put(keyName, ProduktValues[index]);
                    ResultsTable.put(ProduktValues[0], 0);
                    index++;
                }
                
                             
                
               
            	}
            }
            //System.out.println(productvalues);
            //String CasioUhr = productvalues.get("Casio Uhr_0_10");
            // System.out.println(CasioUhr);
            //System.out.println(ResultsTable);
            
            //String maennlich = "Mann";
            
            //Gender in Tabelle
            if (gender.equals("men")) {
            	//System.out.println("Ja, er ist ein Mann");
            	ResultsTable.keySet().forEach(ProductName->{
                	String CompositeString = ProductName + "_Maennlich";
                	String SingleValue = productvalues.get(CompositeString);
                	int IntSingleValue = Integer.parseInt(SingleValue);
                	//System.out.println(CompositeString);
                	//System.out.println(SingleValue);
                	ResultsTable.put(ProductName, IntSingleValue);
            	});
            	
            }
            	else {
            		if (gender.equals("women")) {
            		//System.out.println("Ja, sie ist eine Frau");
            		ResultsTable.keySet().forEach(ProductName-> {
            			String CompositeString = ProductName + "_Weiblich";
            			String SingleValue = productvalues.get(CompositeString);
            			int IntSingleValue = Integer.parseInt(SingleValue);
            			ResultsTable.put(ProductName, IntSingleValue);
            			});
            		}
            		else { 
            			ErrorMessage += "<br> Ohh.. It's looks like you've made a mistake in your gender (gender=) input. Try 'women' or 'men'.";
            		}
            		
            }
            //HashMap check:
            			//System.out.println(ResultsTable);
            			/* if (!insta.equals(null)) {
            			System.out.println("Nada");
            			}
            			else { */
            if (insta.equals("oft")) {
        		//System.out.println("Du nutzt Insta häufig.");
        		ResultsTable.keySet().forEach(ProductName-> {
        			String CompositeString = ProductName + "_oft";
        			String SingleValue = productvalues.get(CompositeString);
        			int IntSingleValue = Integer.parseInt(SingleValue);
        			int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
        			ResultsTable.put(ProductName, CurrentValue);      			
        			});
        		
        		}
        		else {
        			if (insta.equals("selten")) {
        			//System.out.println("Du nutzt Insta selten.");
        		ResultsTable.keySet().forEach(ProductName-> {
            			String CompositeString = ProductName + "_selten";
            			String SingleValue = productvalues.get(CompositeString);
            			int IntSingleValue = Integer.parseInt(SingleValue);
            			int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
            			ResultsTable.put(ProductName, CurrentValue);
        				});
        			}
        			else {
        				ErrorMessage += "<br> Ohh.. It's looks like you've made a mistake in your insta (insta=) input. Try 'oft' or 'selten'.";
        			
        			}
        		// CHECK
        		// System.out.println(ResultsTable);
        			}	
           //Ab hier Main Category auf Amazon 
           if (maincat.equals("BuecherCat")) {
        	   ResultsTable.keySet().forEach(ProductName-> {
        		   String CompositeString = ProductName + "_BuecherCat";
        		   String SingleValue = productvalues.get(CompositeString);
        		   int IntSingleValue = Integer.parseInt(SingleValue);
        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
        		   ResultsTable.put(ProductName, CurrentValue);
        	   	   }); 
           }
           else {
        	   if (maincat.equals("Elektronik_FotoCat")) {
            	   ResultsTable.keySet().forEach(ProductName-> {
            		   String CompositeString = ProductName + "_Elektronik_FotoCat";
            		   String SingleValue = productvalues.get(CompositeString);
            		   int IntSingleValue = Integer.parseInt(SingleValue);
            		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
            		   ResultsTable.put(ProductName, CurrentValue);
            	   	   }); 
               }
        	   else {
        		   if (maincat.equals("Sport_FreizeitCat")) {
                	   ResultsTable.keySet().forEach(ProductName-> {
                		   String CompositeString = ProductName + "_Sport_FreizeitCat";
                		   String SingleValue = productvalues.get(CompositeString);
                		   int IntSingleValue = Integer.parseInt(SingleValue);
                		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                		   ResultsTable.put(ProductName, CurrentValue);
                	   	   }); 
                   }
        		   else { 
        			   if (maincat.equals("UhrenCat")) {
        	        	   ResultsTable.keySet().forEach(ProductName-> {
        	        		   String CompositeString = ProductName + "_UhrenCat";
        	        		   String SingleValue = productvalues.get(CompositeString);
        	        		   int IntSingleValue = Integer.parseInt(SingleValue);
        	        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
        	        		   ResultsTable.put(ProductName, CurrentValue);
        	        	   	   }); 
        	           }
        			   else {
        				   if (maincat.equals("Kueche_Haushalt_WohnenCat")) {
        		        	   ResultsTable.keySet().forEach(ProductName-> {
        		        		   String CompositeString = ProductName + "_Kueche_Haushalt_WohnenCat";
        		        		   String SingleValue = productvalues.get(CompositeString);
        		        		   int IntSingleValue = Integer.parseInt(SingleValue);
        		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
        		        		   ResultsTable.put(ProductName, CurrentValue);
        		        	   	   }); 
        		           }
        				   else {
        					   if (maincat.equals("MusikCat")) {
            		        	   ResultsTable.keySet().forEach(ProductName-> {
            		        		   String CompositeString = ProductName + "_MusikCat";
            		        		   String SingleValue = productvalues.get(CompositeString);
            		        		   int IntSingleValue = Integer.parseInt(SingleValue);
            		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
            		        		   ResultsTable.put(ProductName, CurrentValue);
            		        	   	   }); 
            		           }
        					   else {
        						   if (maincat.equals("SchmuckCat")) {
                		        	   ResultsTable.keySet().forEach(ProductName-> {
                		        		   String CompositeString = ProductName + "_SchmuckCat";
                		        		   String SingleValue = productvalues.get(CompositeString);
                		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                		        		   ResultsTable.put(ProductName, CurrentValue);
                		        	   	   }); 
        						   }
                		        	   else {
                		        		   ErrorMessage += "<br> Ohh.. It's looks like you've made a mistake in your Amazon Category (maincat=) input. Choose out of this list 'BuecherCat', 'Elektronik_FotoCat', 'Sport_FreizeitCat', 'UhrenCat', 'Kueche_HaushaltCat', 'MusikCat', or 'SchmuckCat' .";
                		        	   }
                		           }
        					   }
        				   }
        			   }
        	   		}
           		}
           //CHECK
           //System.out.println(ResultsTable);
           //Ab hier tag1
           if (tag1.equals("Technik")) {
        	   ResultsTable.keySet().forEach(ProductName-> {
        		   String CompositeString = ProductName + "_Technik";
        		   String SingleValue = productvalues.get(CompositeString);
        		   int IntSingleValue = Integer.parseInt(SingleValue);
        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
        		   ResultsTable.put(ProductName, CurrentValue);
        	   	   }); 
		   }
        	   else {
        		   if (tag1.equals("Musik")) {
		        	   ResultsTable.keySet().forEach(ProductName-> {
		        		   String CompositeString = ProductName + "_Musik";
		        		   String SingleValue = productvalues.get(CompositeString);
		        		   int IntSingleValue = Integer.parseInt(SingleValue);
		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
		        		   ResultsTable.put(ProductName, CurrentValue);
		        	   	   }); 
				   }
		        	   else {
		        		   if (tag1.equals("Spielzeug")) {
        		        	   ResultsTable.keySet().forEach(ProductName-> {
        		        		   String CompositeString = ProductName + "_Spielzeug";
        		        		   String SingleValue = productvalues.get(CompositeString);
        		        		   int IntSingleValue = Integer.parseInt(SingleValue);
        		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
        		        		   ResultsTable.put(ProductName, CurrentValue);
        		        	   	   }); 
						   }
        		        	   else {
        		        		   if (tag1.equals("Computerspiele")) {
                		        	   ResultsTable.keySet().forEach(ProductName-> {
                		        		   String CompositeString = ProductName + "_Computerspiele";
                		        		   String SingleValue = productvalues.get(CompositeString);
                		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                		        		   ResultsTable.put(ProductName, CurrentValue);
                		        	   	   }); 
        						   }
                		        	   else {
                		        		   if (tag1.equals("Buecher")) {
                        		        	   ResultsTable.keySet().forEach(ProductName-> {
                        		        		   String CompositeString = ProductName + "_Buecher";
                        		        		   String SingleValue = productvalues.get(CompositeString);
                        		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                        		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                        		        		   ResultsTable.put(ProductName, CurrentValue);
                        		        	   	   }); 
                						   }
                        		        	   else {
                        		        		   if (tag1.equals("Essen")) {
                                		        	   ResultsTable.keySet().forEach(ProductName-> {
                                		        		   String CompositeString = ProductName + "_Essen";
                                		        		   String SingleValue = productvalues.get(CompositeString);
                                		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                                		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                                		        		   ResultsTable.put(ProductName, CurrentValue);
                                		        	   	   }); 
                        						   }
                                		        	   else {
                                		        		   if (tag1.equals("Comedy")) {
                                        		        	   ResultsTable.keySet().forEach(ProductName-> {
                                        		        		   String CompositeString = ProductName + "_Comedy";
                                        		        		   String SingleValue = productvalues.get(CompositeString);
                                        		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                                        		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                                        		        		   ResultsTable.put(ProductName, CurrentValue);
                                        		        	   	   }); 
                                						   }
                                        		        	   else {
                                        		        		   if (tag1.equals("Fashion")) {
                                                		        	   ResultsTable.keySet().forEach(ProductName-> {
                                                		        		   String CompositeString = ProductName + "_Fashion";
                                                		        		   String SingleValue = productvalues.get(CompositeString);
                                                		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                                                		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                                                		        		   ResultsTable.put(ProductName, CurrentValue);
                                                		        	   	   }); 
                                        						   }
                                                		        	   else {
                                                		        		   ErrorMessage += "<br> Ohh.. It's looks like you've made a mistake in your Tag1 (tag1=) input. Choose out of this list 'Technik', 'Musik', 'Spielzeug', 'Computerspiele', 'Buecher', 'Essen', 'Comedy', or 'Fashion' .";
                                                		        	   }
                                        		        	   }
                                		        	   }
                        		        	   }
                		        	   }
        		        		   
        		        	   }
		        	   }
        	   }
           
           
           //CHECK
           //System.out.println(ResultsTable);
           //Ab hier tag2
           if (tag2.equals("Technik")) {
        	   ResultsTable.keySet().forEach(ProductName-> {
        		   String CompositeString = ProductName + "_Technik";
        		   String SingleValue = productvalues.get(CompositeString);
        		   int IntSingleValue = Integer.parseInt(SingleValue);
        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
        		   ResultsTable.put(ProductName, CurrentValue);
        	   	   }); 
		   }
        	   else {
        		   if (tag2.equals("Musik")) {
		        	   ResultsTable.keySet().forEach(ProductName-> {
		        		   String CompositeString = ProductName + "_Musik";
		        		   String SingleValue = productvalues.get(CompositeString);
		        		   int IntSingleValue = Integer.parseInt(SingleValue);
		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
		        		   ResultsTable.put(ProductName, CurrentValue);
		        	   	   }); 
				   }
		        	   else {
		        		   if (tag2.equals("Spielzeug")) {
        		        	   ResultsTable.keySet().forEach(ProductName-> {
        		        		   String CompositeString = ProductName + "_Spielzeug";
        		        		   String SingleValue = productvalues.get(CompositeString);
        		        		   int IntSingleValue = Integer.parseInt(SingleValue);
        		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
        		        		   ResultsTable.put(ProductName, CurrentValue);
        		        	   	   }); 
						   }
        		        	   else {
        		        		   if (tag2.equals("Computerspiele")) {
                		        	   ResultsTable.keySet().forEach(ProductName-> {
                		        		   String CompositeString = ProductName + "_Computerspiele";
                		        		   String SingleValue = productvalues.get(CompositeString);
                		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                		        		   ResultsTable.put(ProductName, CurrentValue);
                		        	   	   }); 
        						   }
                		        	   else {
                		        		   if (tag2.equals("Buecher")) {
                        		        	   ResultsTable.keySet().forEach(ProductName-> {
                        		        		   String CompositeString = ProductName + "_Buecher";
                        		        		   String SingleValue = productvalues.get(CompositeString);
                        		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                        		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                        		        		   ResultsTable.put(ProductName, CurrentValue);
                        		        	   	   }); 
                						   }
                        		        	   else {
                        		        		   if (tag2.equals("Essen")) {
                                		        	   ResultsTable.keySet().forEach(ProductName-> {
                                		        		   String CompositeString = ProductName + "_Essen";
                                		        		   String SingleValue = productvalues.get(CompositeString);
                                		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                                		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                                		        		   ResultsTable.put(ProductName, CurrentValue);
                                		        	   	   }); 
                        						   }
                                		        	   else {
                                		        		   if (tag2.equals("Comedy")) {
                                        		        	   ResultsTable.keySet().forEach(ProductName-> {
                                        		        		   String CompositeString = ProductName + "_Comedy";
                                        		        		   String SingleValue = productvalues.get(CompositeString);
                                        		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                                        		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                                        		        		   ResultsTable.put(ProductName, CurrentValue);
                                        		        	   	   }); 
                                						   }
                                        		        	   else {
                                        		        		   if (tag2.equals("Fashion")) {
                                                		        	   ResultsTable.keySet().forEach(ProductName-> {
                                                		        		   String CompositeString = ProductName + "_Fashion";
                                                		        		   String SingleValue = productvalues.get(CompositeString);
                                                		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                                                		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                                                		        		   ResultsTable.put(ProductName, CurrentValue);
                                                		        	   	   }); 
                                        						   }
                                                		        	   else {
                                                		        		   ErrorMessage += "<br> Ohh.. It's looks like you've made a mistake in your Tag2 (tag2=) input. Choose out of this list 'Technik', 'Musik', 'Spielzeug', 'Computerspiele', 'Buecher', 'Essen', 'Comedy', or 'Fashion'.";
                                                		        	   }
                                        		        	   }
                                		        	   }
                        		        	   }
                		        	   }
        		        		   
        		        	   }
		        	   }
        	   }
           //CHECK
           //System.out.println(ResultsTable);
           //Ab hier tag3
           if (tag3.equals("Technik")) {
        	   ResultsTable.keySet().forEach(ProductName-> {
        		   String CompositeString = ProductName + "_Technik";
        		   String SingleValue = productvalues.get(CompositeString);
        		   int IntSingleValue = Integer.parseInt(SingleValue);
        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
        		   ResultsTable.put(ProductName, CurrentValue);
        	   	   }); 
		   }
        	   else {
        		   if (tag3.equals("Musik")) {
		        	   ResultsTable.keySet().forEach(ProductName-> {
		        		   String CompositeString = ProductName + "_Musik";
		        		   String SingleValue = productvalues.get(CompositeString);
		        		   int IntSingleValue = Integer.parseInt(SingleValue);
		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
		        		   ResultsTable.put(ProductName, CurrentValue);
		        	   	   }); 
				   }
		        	   else {
		        		   if (tag3.equals("Spielzeug")) {
        		        	   ResultsTable.keySet().forEach(ProductName-> {
        		        		   String CompositeString = ProductName + "_Spielzeug";
        		        		   String SingleValue = productvalues.get(CompositeString);
        		        		   int IntSingleValue = Integer.parseInt(SingleValue);
        		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
        		        		   ResultsTable.put(ProductName, CurrentValue);
        		        	   	   }); 
						   }
        		        	   else {
        		        		   if (tag3.equals("Computerspiele")) {
                		        	   ResultsTable.keySet().forEach(ProductName-> {
                		        		   String CompositeString = ProductName + "_Computerspiele";
                		        		   String SingleValue = productvalues.get(CompositeString);
                		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                		        		   ResultsTable.put(ProductName, CurrentValue);
                		        	   	   }); 
        						   }
                		        	   else {
                		        		   if (tag3.equals("Buecher")) {
                        		        	   ResultsTable.keySet().forEach(ProductName-> {
                        		        		   String CompositeString = ProductName + "_Buecher";
                        		        		   String SingleValue = productvalues.get(CompositeString);
                        		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                        		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                        		        		   ResultsTable.put(ProductName, CurrentValue);
                        		        	   	   }); 
                						   }
                        		        	   else {
                        		        		   if (tag3.equals("Essen")) {
                                		        	   ResultsTable.keySet().forEach(ProductName-> {
                                		        		   String CompositeString = ProductName + "_Essen";
                                		        		   String SingleValue = productvalues.get(CompositeString);
                                		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                                		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                                		        		   ResultsTable.put(ProductName, CurrentValue);
                                		        	   	   }); 
                        						   }
                                		        	   else {
                                		        		   if (tag3.equals("Comedy")) {
                                        		        	   ResultsTable.keySet().forEach(ProductName-> {
                                        		        		   String CompositeString = ProductName + "_Comedy";
                                        		        		   String SingleValue = productvalues.get(CompositeString);
                                        		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                                        		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                                        		        		   ResultsTable.put(ProductName, CurrentValue);
                                        		        	   	   }); 
                                						   }
                                        		        	   else {
                                        		        		   if (tag3.equals("Fashion")) {
                                                		        	   ResultsTable.keySet().forEach(ProductName-> {
                                                		        		   String CompositeString = ProductName + "_Fashion";
                                                		        		   String SingleValue = productvalues.get(CompositeString);
                                                		        		   int IntSingleValue = Integer.parseInt(SingleValue);
                                                		        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                                                		        		   ResultsTable.put(ProductName, CurrentValue);
                                                		        	   	   }); 
                                        						   }
                                                		        	   else {
                                                		        		   ErrorMessage += "<br> Ohh.. It's looks like you've made a mistake in your Tag3 (tag3=) input. Choose out of this list 'Technik', 'Musik', 'Spielzeug', 'Computerspiele', 'Buecher', 'Essen', 'Comedy', or 'Fashion'.";
                                                		        	   }
                                        		        	   }
                                		        	   }
                        		        	   }
                		        	   }
        		        		   
        		        	   }
		        	   }
        	   }
           //CHECK
           //System.out.println(ResultsTable);
           if (os.equals("android")) {
        	   ResultsTable.keySet().forEach(ProductName-> {
        		   String CompositeString = ProductName + "_android";
        		   String SingleValue = productvalues.get(CompositeString);
        		   int IntSingleValue = Integer.parseInt(SingleValue);
        		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
        		   ResultsTable.put(ProductName, CurrentValue);
        	   	   }); 
		   }
        	   else {
        		   if (os.equals("apple")) {
                	   ResultsTable.keySet().forEach(ProductName-> {
                		   String CompositeString = ProductName + "_apple";
                		   String SingleValue = productvalues.get(CompositeString);
                		   int IntSingleValue = Integer.parseInt(SingleValue);
                		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                		   ResultsTable.put(ProductName, CurrentValue);
                	   	   }); 
        		   }
                	   else {
                		   ErrorMessage += "<br> Ohh.. It's looks like you've made a mistake in your Os (os=) input. Try 'apple' or 'android'.";
                	   }
        		   
        	   }
           //CHECK
           //Ab hier age 
           if (age != "") {
           if ( yourAge.getIntAge(age) <= 10) {
           	//System.out.println("Ich bin jünger als 11");
           	ResultsTable.keySet().forEach(ProductName-> {
     		   String CompositeString = ProductName + "_0_10";
     		   String SingleValue = productvalues.get(CompositeString);
     		   int IntSingleValue = Integer.parseInt(SingleValue);
     		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
     		   ResultsTable.put(ProductName, CurrentValue);
           	   });
           }
           else {
        	   if (yourAge.getIntAge(age) <= 20) {
                  	//System.out.println("Ich bin jünger als 21");
                   	ResultsTable.keySet().forEach(ProductName-> {
             		   String CompositeString = ProductName + "_11_20";
             		   String SingleValue = productvalues.get(CompositeString);
             		   int IntSingleValue = Integer.parseInt(SingleValue);
             		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
             		   ResultsTable.put(ProductName, CurrentValue);
                   	   });
        	   }
                   	else {
                   		if (yourAge.getIntAge(age) <= 40) {
                          	//System.out.println("Ich bin jünger als 41");
                           	ResultsTable.keySet().forEach(ProductName-> {
                     		   String CompositeString = ProductName + "_21_40";
                     		   String SingleValue = productvalues.get(CompositeString);
                     		   int IntSingleValue = Integer.parseInt(SingleValue);
                     		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                     		   ResultsTable.put(ProductName, CurrentValue);
                           	   });
                	   }
                   		else {
                   			if (yourAge.getIntAge(age) <= 60) {
                   				//System.out.println("Ich bin jünger als 61");
                   				ResultsTable.keySet().forEach(ProductName-> {
                   					String CompositeString = ProductName + "_41_60";
                   					String SingleValue = productvalues.get(CompositeString);
                   					int IntSingleValue = Integer.parseInt(SingleValue);
                   					int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                   					ResultsTable.put(ProductName, CurrentValue);
                   					});
                   			}
                   			else {
                   				if (yourAge.getIntAge(age) <= 80) {
                   						//System.out.println("Ich bin jünger als 81");
                   						ResultsTable.keySet().forEach(ProductName-> {
                   							String CompositeString = ProductName + "_61_80";
                   							String SingleValue = productvalues.get(CompositeString);
                   							int IntSingleValue = Integer.parseInt(SingleValue);
                   							int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                   							ResultsTable.put(ProductName, CurrentValue);
                   							});
                   				}
                   				else {
                   					if (yourAge.getIntAge(age) <= 100) {
                   	                  	//System.out.println("Ich bin jünger als 101");
                   	                   	ResultsTable.keySet().forEach(ProductName-> {
                   	             		   String CompositeString = ProductName + "_81_100";
                   	             		   String SingleValue = productvalues.get(CompositeString);
                   	             		   int IntSingleValue = Integer.parseInt(SingleValue);
                   	             		   int CurrentValue = ResultsTable.get(ProductName) + IntSingleValue;
                   	             		   ResultsTable.put(ProductName, CurrentValue);
                   	                   	   });
                   					}
                   	                   	else {
                   	                   		ErrorMessage += "<br> Ohh.. it seems like you are too old.";
                   	                   	}
                   	                   		
                   	                   	}
                   	        	   }
                   				}
                   		
                   	}
           }
                   	}
           else {
        	   ErrorMessage += "<br> Ohh.. you didn't type in your age.";
           }
            //System.out.println(ErrorMessage);
           }
    	
        	
        	
        	
			

    		
        catch (IOException e) {
            e.printStackTrace();
        }
             
             
    	//HASH TABLE FUNCTIONS
    	
    	// Adding the Values
    	
    	
    	
    	
    	/*int Zero = 0;
    	String ProduktValues = line.split(cvsSplitBy);
    	for(String DerProduktName: ProduktValues);
    	
    	ValueZero.put(ProduktValues, 0);
    	
    	System.out.println(ValueZero);
    	*/
    	
    	
    	
    	
    	
    	
        
    	
    	//RETURN VALUE
    	int currentHighestValue = 0;
    	String currentBestProduct = "";
    	for(Entry<String, Integer> entry:ResultsTable.entrySet()) {
	        if ( entry.getValue() > currentHighestValue) {
	        	currentHighestValue= entry.getValue();
	        	currentBestProduct = entry.getKey();
	        	}
    	}
    	String NoError = "";
    	if (ErrorMessage == "<br> <br> <br> <br> <br> If you've made mistakes, or typed something wrong, it would come up here: <br>") {
    			NoError += "<b> Well done! Everything is right. </b>";
    	}
    	
    	return hello.getUserName(name) + YourProduct + "<br>" + currentBestProduct + MerryChristmas + "<i>" + ErrorMessage + "</i>" + NoError /* + "</b> " + hello.getUserName(name) + yourAge.getUserAge(age) + /* yourGender.getUserGender(gender) + yourTag1.getUserTag1(tag1=) + yourTag2.getUserTag2(tag2) + yourTag3.getUserTag3(tag3) + yourInsta.getUserInsta(insta) + yourMainCat.getUserMainCat(maincat) + yourOs.getUserOs(os) + ResultsTable*/;
}
}


    				