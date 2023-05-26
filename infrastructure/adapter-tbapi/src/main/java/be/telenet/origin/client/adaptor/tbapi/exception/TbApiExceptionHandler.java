package be.telenet.origin.client.adaptor.tbapi.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;

@Provider
@Slf4j
public class TbApiExceptionHandler implements ExceptionMapper<ResteasyWebApplicationException> {

    @Override
    public Response toResponse(ResteasyWebApplicationException e) {
        Response tbApiResonse = e.unwrap().getResponse();
        String tbApiError = tbApiResonse.readEntity(String.class);
        int status = tbApiResonse.getStatus();
        log.error("TBAPI http code {}: {}", status, tbApiError);
        return Response
                .status(status)
                .entity(new ErrorMessage(String.format("tb api error: %s", tbApiError), status))
                .build();
    }


}
