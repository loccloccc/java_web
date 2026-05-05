package re.cntt4.session15_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import re.cntt4.session15_demo.model.Animal;

import java.util.List;

public interface IAnimalRepository extends JpaRepository<Animal,Long> {

    // hanh dong + By + thuoc tinh + dieu kien
    List<Animal> findAllByNameContains(String search);

    @Query(""" 
        select a from Animal a where a.name like concat('%',:search,'%')
                or a.age = :search
        """ )
    List<Animal> searchAll(@Param("search") String search);

    // neu nhu lam chu nang them sua xoa bang query thi phai them 1 annotation la @Modifying
}
