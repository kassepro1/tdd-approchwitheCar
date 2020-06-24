package sn.kp.starttddwithspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.kp.starttddwithspringboot.domaine.Car;
import sn.kp.starttddwithspringboot.repositories.CarRepository;
import sn.kp.starttddwithspringboot.service.CarService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {
  @Autowired
  private CarService carService;
  @Autowired
  private CarRepository carRepository;
    @Test
    public void caching(){
        given(carRepository.findByName(anyString())).willReturn(new Car("Prius","Hybrid"));

        carService.getCarDetails("Prius");
        carService.getCarDetails("Prius");

        verify(carRepository,times(1)).findByName("Prius");
    }
}
