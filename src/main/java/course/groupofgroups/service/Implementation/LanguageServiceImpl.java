package course.groupofgroups.service.Implementation;

import course.groupofgroups.model.Language;
import course.groupofgroups.repository.LanguageRepository;
import course.groupofgroups.service.LanguageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository repository;

    @Override
    public List<Language> allLanguages() {
        return repository.findAll();
    }

    @Override
    public Language findById(Long id) {
        return repository.findById(id).get();
    }

}
