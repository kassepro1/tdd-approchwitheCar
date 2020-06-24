package sn.kp.starttddwithspringboot.service;

import org.springframework.cache.annotation.Cacheable;
import sn.kp.starttddwithspringboot.domaine.Car;
import sn.kp.starttddwithspringboot.exception.CarNotFoundException;
import sn.kp.starttddwithspringboot.repositories.CarRepository;


public class CarService {

    private CarRepository carRepository;
    public CarService(CarRepository carRepository){

    }
   @Cacheable("cars")
    public Car getCarDetails(String name) {
        Car car = carRepository.findByName(name);
        if(car==null){
            throw new CarNotFoundException();
        }
        return car ;
    }


}
