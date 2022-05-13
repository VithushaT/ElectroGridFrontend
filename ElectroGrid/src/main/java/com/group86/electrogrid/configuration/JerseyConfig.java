package com.group86.electrogrid.configuration;

import com.group86.electrogrid.apis.EmailAPI;
import com.group86.electrogrid.apis.TestAPI;
import com.group86.electrogrid.apis.UserAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig  extends ResourceConfig {
    public JerseyConfig(){
        register(TestAPI.class);
        register(UserAPI.class);
        register(EmailAPI.class);
    }
}
