package course.groupofgroups.converter;

import course.groupofgroups.model.Interest;
import course.groupofgroups.repository.InterestRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToInterestsList implements Converter<String[], List<Interest>> {

    @Autowired
    private InterestRepository repository;

    @Override
    public List<Interest> convert(String[] source) {
        List<Interest> interests = new ArrayList<>();
        for (String interest : source) {
            interests.add(repository.findById(Long.parseLong(interest)).get());
        }
        return interests;
    }

}
