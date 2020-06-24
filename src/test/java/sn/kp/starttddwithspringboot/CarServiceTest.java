package sn.kp.starttddwithspringboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;
import sn.kp.starttddwithspringboot.domaine.Car;
import sn.kp.starttddwithspringboot.exception.CarNotFoundException;
import sn.kp.starttddwithspringboot.repositories.CarRepository;
import sn.kp.starttddwithspringboot.service.CarService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)

public class CarServiceTest {
    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp(){
        carService = new CarService(carRepository);
    }

    @Test
    public void getCarDetails_returnsCarInfo(){
        given(carRepository.findByName("Prius")).willReturn(new Car("Prius","Hybrid"));
        Car car = carService.getCarDetails("Prius");
        assertThat(car.getName()).isEqualTo("Prius");
        assertThat(car.getType()).isEqualTo("Hybrid");
    }

    @Test(expected = CarNotFoundException.class)
    public void getCarDetails_whenCarNotFound(){
     given(carRepository.findByName("Prius")).willReturn(null);
     carService.getCarDetails("Prius");
    }

}
