package com.api;

import org.glassfish.jersey.server.ResourceConfig;


import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
public class JaxRsApplication extends ResourceConfig{

//	
//	@Inject
//	Employee emp;
//	@Inject 
//	EmployeeDAO dao;
    public JaxRsApplication() {
        packages("com.api");
        
        
        final ResourceConfig resourceConfig = new ResourceConfig();
//        resourceConfig.register(new CORSFilter());
//        final final URI uri = ...;
//        final HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(uri, resourceConfig);
    
}
//    
//    @PostConstruct
//    public void setUp() {
//        register(Ressources.class);
//        register(JsonMappingExceptionMapper.class);
//    }
}
