package edu.upc.eetac.dsa.yifeige.Car_api;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;



public class CarApplication extends ResourceConfig
{
	public CarApplication() 
	
	   {
		super();
		register(DeclarativeLinkingFeature.class);
		
		}
	

}
