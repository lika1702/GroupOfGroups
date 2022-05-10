package course.groupofgroups.service.Implementation;

import course.groupofgroups.model.City;
import course.groupofgroups.repository.CityRepository;
import course.groupofgroups.service.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> allCities() {
        return repository.findAll();
    }

    @Override
    public City findById(Long id) {
        return repository.findById(id).get();
    }

}
