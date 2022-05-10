package course.groupofgroups.service.Implementation;

import course.groupofgroups.model.Interest;
import course.groupofgroups.repository.InterestRepository;
import course.groupofgroups.service.InterestService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private InterestRepository repository;

    @Override
    public List<Interest> allInterests() {
        return repository.findAll();
    }

    @Override
    public Interest findById(Long id) {
        return repository.findById(id).get();
    }

}
