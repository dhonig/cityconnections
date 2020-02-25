import com.dhonig.cityconnections.CityConnectionsApp;
import com.dhonig.cityconnections.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = CityConnectionsApp.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConnectionsControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void givenASmokeTest_returnsCorrectResponse() {
        String endpointUrl="http://localhost:" + port + "/hello/World";
        Message response = restTemplate.getForObject(endpointUrl,Message.class);
        assertEquals(response.getText(), "Hello World");
    }

    @Test
    public void givenBostonAndNewark_returnsYes(){

    }

    @Test
    public void givenBostonAndPhiladelphia_returnsYes(){

    }

    @Test
    public void givenPhiladelphiaAndAlbany_returnsNo(){

    }
}



