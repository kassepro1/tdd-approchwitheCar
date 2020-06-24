package sn.kp.starttddwithspringboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import sn.kp.starttddwithspringboot.domaine.Car;
import sn.kp.starttddwithspringboot.repositories.CarRepository;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private TestEntityManager testEntityManager;
     @Test
    public void findByName_returnsCar(){
        Car savedCar = testEntityManager.persistFlushFind(new Car("Prius","Hybrid"));
        Car car = carRepository.findByName("Prius");
        assertThat(savedCar.getName()).isEqualTo(car.getName());
        assertThat(savedCar.getType()).isEqualTo(car.getType());
    }
}
