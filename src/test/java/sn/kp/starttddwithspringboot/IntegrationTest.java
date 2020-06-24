package sn.kp.starttddwithspringboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import sn.kp.starttddwithspringboot.domaine.Car;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    @Autowired
    private TestRestTemplate testRestamplte;

    @Test
    public void getCar_retunCarDetails() {
        //arrange

        //action
        ResponseEntity<Car> response = testRestamplte.getForEntity("/cars/Prius", Car.class);
        //assertion
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("Prius");
        assertThat(response.getBody().getType()).isEqualTo("Hybrid");

    }
}
