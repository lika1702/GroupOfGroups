package course.groupofgroups.converter;

import course.groupofgroups.model.Language;
import course.groupofgroups.repository.LanguageRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToLanguagesList implements Converter<String[], List<Language>> {

    @Autowired
    private LanguageRepository repository;

    @Override
    public List<Language> convert(String[] source) {
        List<Language> languages = new ArrayList<>();
        for (String language : source) {
            languages.add(repository.findByName(language));
        }
        return languages;
    }

}
