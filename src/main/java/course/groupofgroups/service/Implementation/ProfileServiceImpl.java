package course.groupofgroups.service.Implementation;

import course.groupofgroups.model.Profile;
import course.groupofgroups.repository.ProfileRepository;
import course.groupofgroups.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository repository;

    @Override
    public Profile findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public long add(Profile profile) {
        repository.save(profile);
        return repository.findByPhone(profile.getPhone()).getId();
    }

    @Override
    public void edit(Profile profile) {
        repository.save(profile);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void setPhoto(String url, Long id) {
        repository.setPhotoById(url, id);
    }

}
