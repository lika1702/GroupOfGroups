package course.groupofgroups.model;

public class RoleType {

    public final String USER = "USER";
    public final String ADMIN = "ADMIN";

    private static RoleType instance;

    private RoleType() {
    }

    public static RoleType getInstance() {
        if (instance == null) {
            instance = new RoleType();
        }
        return instance;
    }

}
