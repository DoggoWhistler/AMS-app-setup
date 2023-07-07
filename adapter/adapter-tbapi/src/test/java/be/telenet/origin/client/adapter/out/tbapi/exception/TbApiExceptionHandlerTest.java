package be.telenet.origin.client.adapter.out.tbapi.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.client.exception.ResteasyWebApplicationException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TbApiExceptionHandlerTest {

    @Test
    void testTbApiExceptionToErrorMessageMapping() {
        ResteasyWebApplicationException test = new ResteasyWebApplicationException(new WebApplicationException("test error", 400) {
            @Override
            public Response getResponse() {
                return Response.status(404).entity("{\"code\":\"CBM-CUST-0003\",\"type\":\"LOGIC\",\"message\":\"Failed to find Billing Account with MSISDN 0469213586\"}").build();
            }
        });

        Response response = new TbApiExceptionHandler().toResponse(test);

        assertThat(response.getStatus()).isEqualTo(404);
        assertThat(response.getEntity().getClass()).isEqualTo(ErrorMessage.class);
        assertThat(((ErrorMessage) response.getEntity()).message()).isEqualTo("tb api error: {\"code\":\"CBM-CUST-0003\",\"type\":\"LOGIC\",\"message\":\"Failed to find Billing Account with MSISDN 0469213586\"}");
    }

}
