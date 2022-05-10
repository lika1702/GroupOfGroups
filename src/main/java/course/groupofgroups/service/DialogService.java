package course.groupofgroups.service;

import course.groupofgroups.model.Dialog;

public interface DialogService {

    public Dialog findById(Long id);

    public boolean add(Dialog user);
}
