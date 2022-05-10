package course.groupofgroups.service.Implementation;

import course.groupofgroups.model.Education;
import course.groupofgroups.repository.EducationRepository;
import course.groupofgroups.service.EducationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationRepository repository;

    @Override
    public List<Education> allEducations() {
        return repository.findAll();
    }

    @Override
    public Education findById(Long id) {
        return repository.findById(id).get();
    }

}
