package bg.tu_varna.sit.si.user.dto;

import bg.tu_varna.sit.si.user.UserEntity;

public class UserDetailDTO {
    public String externalUserId;
    public String firstName;
    public String middleName;
    public String lastName;
    public int age;
    public String egn;
    public String email;
    public String address;
    public int cityId;
    public boolean isActive;
    public String profileImageId;
    public String createdAt;
    public String updatedAt;

    public UserDetailDTO() {}

    public UserDetailDTO(UserEntity user) {
        this.externalUserId = user.externalUserId;
        this.firstName = user.firstName;
        this.middleName = user.middleName;
        this.lastName = user.lastName;
        this.age = user.age;
        this.egn = user.getEgn();
        this.email = user.email;
        this.address = user.address;
        this.cityId = user.cityId;
        this.isActive = user.isActive;
        this.profileImageId = user.profileImageId;

        this.createdAt =
                user.createdAt != null ? user.createdAt.toString() : null;

        this.updatedAt =
                user.updatedAt != null ? user.updatedAt.toString() : null;
    }
}
