package io.seq.astro.utils.exception.ExceptionMapper;

import io.seq.astro.utils.exception.ErrorMessage;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstrainViolationEM implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(prepareMessage(e))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    private ErrorMessage prepareMessage(ConstraintViolationException exception) {
        StringBuilder message = new StringBuilder();
        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
            message.append(cv.getMessage()).append("\n");
        }
        return new ErrorMessage(message.toString(),exception.getMessage(),exception.getClass().getSimpleName());
    }
}
