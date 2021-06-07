package com.redhat;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.Body;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/accounts-transactions-resteasy")
public class BankResource {
//mvnw compile quarkus:dev

	public static final Logger logger = Logger.getLogger(BankResource.class.toString());
	
	public BankResource() {
		accountscollection.add(new BankAccount("Mr Harry", "123456789", "London", new BigDecimal(123456.66), "Premium"));
		accountscollection.add(new BankAccount("Mr James", "1234567890", "USA", new BigDecimal(12345688.66), "Standard"));
	}
	
	private Set<BankAccount> accountscollection = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

	
    @GET
    @Path("/getdefaultcurrency/")
    @Produces(MediaType.TEXT_PLAIN)
    public String getdefaultcurrency() {
        return "The default currency is USD";
    }
	
    
    @GET
    @Path("/getallaccounts/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getallaccounts() {
        return Response.ok(accountscollection.toArray()).build();
    }

    @GET
    @Path("/getsingleaccount/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getsingleaccount() {
        return Response.ok(accountscollection.iterator().next()).build();
    }

    
    
    @POST
    @Path("/checkaccountbalance/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkaccountbalance(BankAccount accountparam) {
    	
    	logger.warning("**Inside the check account balance operation, account number is " + accountparam.getAccountNumber());
    	
    	int accountnumber = Integer.valueOf(accountparam.getAccountNumber());
    	
    	if(accountnumber == 0) {
    		return Response.status(Response.Status.UNAUTHORIZED).header("Invalid Account Number", "" + accountnumber).build();
    	}
    	
    	Iterator<BankAccount> accounts = accountscollection.iterator();
    	int i=0;
    	
    	while((accounts.hasNext()) && (i < 50)) {
    		i++;
    		BankAccount account = accounts.next();
    		if (String.valueOf(accountnumber).equals(account.getAccountNumber())) {
    			return Response.ok(account).build();
    		}
    	}
    	
    	return Response.status(Response.Status.UNAUTHORIZED).header("Invalid Account Number", "" + accountnumber).build();
    	
    }
    

    
    @POST
    @Path("/addcustomer/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addcustomer(BankAccount account) {
    	
    	logger.warning("**adding customer with name ,  " + account.getName());
    	accountscollection.add(account);
    	return Response.ok(account).build();
    	
    }

    
    @POST
    @Path("/changeofaddress/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response changeofaddress(BankAccount accountparam) {
    	
    	logger.warning("**changing address of customer with name ,  " + accountparam.getName());
    	Iterator<BankAccount> accounts = accountscollection.iterator();
    	while (accounts.hasNext()) {
    		BankAccount account = accounts.next();
    		if(accountparam.getAccountNumber().equalsIgnoreCase(account.getAccountNumber())) {
    			
    			accountscollection.remove(account);
    			
    			accountscollection.add(accountparam);
    			
    			return Response.ok(accountparam).build();
    		}
    	}
    	return Response.status(Response.Status.UNAUTHORIZED).header("Invalid Account Number", "" + accountparam.getAccountNumber()).build();
    	
    }
    
    
}
