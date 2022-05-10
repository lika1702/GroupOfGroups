package course.groupofgroups.service;

import course.groupofgroups.model.Profile;

public interface ProfileService {

    public Profile findById(Long id);

    public long add(Profile profile);

    public void edit(Profile profile);

    public void setPhoto(String url, Long id);

    public void delete(Long id);
}
