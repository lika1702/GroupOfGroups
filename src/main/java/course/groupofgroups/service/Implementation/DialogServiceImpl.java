package course.groupofgroups.service.Implementation;

import course.groupofgroups.model.Dialog;
import course.groupofgroups.repository.DialogRepository;
import course.groupofgroups.service.DialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DialogServiceImpl implements DialogService {

    @Autowired
    private DialogRepository repository;

    @Override
    public boolean add(Dialog dialog) {
        repository.save(dialog);
        return true;
    }

    @Override
    public Dialog findById(Long id) {
        return repository.findById(id).get();
    }

}
