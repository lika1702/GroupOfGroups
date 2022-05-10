package course.groupofgroups.service;

import course.groupofgroups.model.Language;
import java.util.List;

public interface LanguageService {

    public List<Language> allLanguages();

    public Language findById(Long id);
}
