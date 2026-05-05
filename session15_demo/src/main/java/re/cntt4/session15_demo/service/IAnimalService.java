package re.cntt4.session15_demo.service;

import org.springframework.data.domain.Page;
import re.cntt4.session15_demo.model.Animal;

import java.util.List;

public interface IAnimalService {

    // hien thi
    Page<Animal> getAllAnimal(String search , Integer page , Integer size);
}
