package bg.tu_varna.sit.si.user.dto;

import bg.tu_varna.sit.si.user.UserEntity;

public class UserListDTO {
    public String external_user_id;
    public String firstName;
    public String middleName;
    public String lastName;
    public String email;
    public int age;

    public UserListDTO() {}

    public UserListDTO(UserEntity user) {
        this.external_user_id = user.externalUserId;
        this.firstName = user.firstName;
        this.middleName = user.middleName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.age = user.age;
    }
}
