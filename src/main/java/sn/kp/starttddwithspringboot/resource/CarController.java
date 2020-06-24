package sn.kp.starttddwithspringboot.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sn.kp.starttddwithspringboot.domaine.Car;
import sn.kp.starttddwithspringboot.exception.CarNotFoundException;
import sn.kp.starttddwithspringboot.service.CarService;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars/{name}")
    public Car getCar(@PathVariable("name") String name){
        return  carService.getCarDetails(name);
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void CarNotFoundHandler(CarNotFoundException ex){

    }

}
