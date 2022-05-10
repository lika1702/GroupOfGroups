package course.groupofgroups.service.Implementation;

import course.groupofgroups.model.SocialNetwork;
import course.groupofgroups.repository.SocialNetworkRepository;
import course.groupofgroups.service.SocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialNetworkServiceImpl implements SocialNetworkService {

    @Autowired
    private SocialNetworkRepository repository;

    @Override
    public SocialNetwork findById(Long id) {
        return repository.findById(id).get();
    }

}
