package course.groupofgroups.service;

import course.groupofgroups.model.City;
import java.util.List;

public interface CityService {

    public List<City> allCities();

    public City findById(Long id);
}
