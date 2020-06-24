package sn.kp.starttddwithspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sn.kp.starttddwithspringboot.domaine.Car;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car,Long> {
     Car findByName(String name);
}
