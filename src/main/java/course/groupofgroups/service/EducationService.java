package course.groupofgroups.service;

import course.groupofgroups.model.Education;
import java.util.List;

public interface EducationService {

    public List<Education> allEducations();

    public Education findById(Long id);
}
