package io.seq.astro.utils.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import io.seq.astro.utils.constants.ResourceConstants;
import org.apache.commons.io.IOUtils;
import org.jboss.logging.MDC;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.UUID;

@Provider
public class LogFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private final ObjectMapper objectMapper;


    @Inject
    public LogFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void filter(ContainerRequestContext reqContext) throws IOException {

        Log.info("Received " + reqContext.getMethod() + " request @ " + reqContext.getUriInfo().getRequestUri());

        reqContext.setProperty(ResourceConstants.START_TIME_KEY, System.currentTimeMillis());
        // validations

        if (reqContext.getHeaders().get(ResourceConstants.TRANSACTION_ID_KEY) != null) {
            MDC.put(ResourceConstants.TRANSACTION_ID_KEY, reqContext.getHeaders().get(ResourceConstants.TRANSACTION_ID_KEY).toString().replaceAll("\\[", "").replaceAll("]", ""));
        } else {
            Log.warn("TransactionId is not provided in the headers , hence using internally generated transactionId");
            MDC.put(ResourceConstants.TRANSACTION_ID_KEY, UUID.randomUUID().toString());
            Log.info("Generated TransactionId : " + MDC.get(ResourceConstants.TRANSACTION_ID_KEY));
        }

        // body
        if (reqContext.hasEntity()) {
            Log.info("Request body : " + IOUtils.toString(reqContext.getEntityStream()));
        }
    }

    @Override
    public void filter(ContainerRequestContext reqContext, ContainerResponseContext resContext) throws IOException {
        Log.info("Sending back response with status code : " + resContext.getStatus());
        Log.info("Time taken to process transaction - "
                + MDC.get(ResourceConstants.TRANSACTION_ID_KEY)
                + " : "
                + calcInterval((long) reqContext.getProperty(ResourceConstants.START_TIME_KEY))
                + " ms");
        if (resContext.hasEntity()) {
            Log.info("Response body : " + objectMapper.writeValueAsString(resContext.getEntity()));
        }
    }

    private String calcInterval(Long startTime) {
        return String.valueOf(System.currentTimeMillis() - startTime);
    }

}
