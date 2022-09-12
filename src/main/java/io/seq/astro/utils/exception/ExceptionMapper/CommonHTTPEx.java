package io.seq.astro.utils.exception.ExceptionMapper;

import io.seq.astro.utils.exception.ErrorMessage;
import io.seq.astro.utils.exception.Exception.CommonHTTPException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CommonHTTPEx implements ExceptionMapper<CommonHTTPException> {


    private final String USER_NOT_FOUND = "User not found";

    @Override
    public Response toResponse(CommonHTTPException e) {

        if (e.getMessage().equalsIgnoreCase(USER_NOT_FOUND)) {
            return Response.status(Response.Status.NOT_FOUND).
                    entity(new ErrorMessage(e.getMessage(), false))
                    .build();
        } else {

            return Response.status(Response.Status.BAD_REQUEST).
                    entity(new ErrorMessage(e.getMessage(), false))
                    .build();
        }
    }
}
