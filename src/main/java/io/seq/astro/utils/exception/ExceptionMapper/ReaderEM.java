package io.seq.astro.utils.exception.ExceptionMapper;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import io.seq.astro.utils.exception.ErrorMessage;
import org.jboss.resteasy.spi.ReaderException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ReaderEM implements ExceptionMapper<ReaderException> {

    @Override
    public Response toResponse(ReaderException e) {

        if (e.getCause() instanceof JsonParseException || e.getCause() instanceof JsonMappingException) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorMessage("Error parsing/mapping json, Please check the request", e.getMessage(), e.getClass().getSimpleName())).type(MediaType.APPLICATION_JSON).build();
        }
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorMessage("unknown Reader error occurred", e.getMessage(), e.getClass().getSimpleName())).type(MediaType.APPLICATION_JSON).build();
    }
}
