package org.acme;

import jakarta.ws.rs.container.DynamicFeature;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Provider
public class MyDynamicFeature implements DynamicFeature {
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        if (resourceInfo.getResourceClass().isAnnotationPresent(RegisterRestClient.class)) {
            System.exit(999);
        }
    }
}
