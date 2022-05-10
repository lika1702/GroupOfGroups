package course.groupofgroups.service;

import course.groupofgroups.model.Interest;
import java.util.List;

public interface InterestService {

    public List<Interest> allInterests();

    public Interest findById(Long id);
}
