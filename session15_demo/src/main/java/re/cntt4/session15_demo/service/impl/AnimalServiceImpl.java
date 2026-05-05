package re.cntt4.session15_demo.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import re.cntt4.session15_demo.model.Animal;
import re.cntt4.session15_demo.repository.IAnimalRepository;
import re.cntt4.session15_demo.service.IAnimalService;


import java.util.List;


@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements IAnimalService {
    private final IAnimalRepository iAnimalRepository;

    @Override
    public Page<Animal> getAllAnimal(String search , Integer page , Integer size) {
        Pageable pageable = PageRequest.of(page,size);

        // de phan trang thi can phai nhan ve 1 danh sach

//        if (search.isEmpty()){
            return iAnimalRepository.findAll(pageable);
//        }
//        return iAnimalRepository.searchAll(search);
    }
}
