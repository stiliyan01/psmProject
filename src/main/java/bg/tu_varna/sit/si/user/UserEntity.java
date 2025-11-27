package bg.tu_varna.sit.si.user;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class UserEntity extends PanacheEntity {

    @Column(name = "external_user_id", nullable = true)
    public String externalUserId;

    @Column(name = "first_name", nullable = false)
    public String firstName;

    @Column(name = "middle_name", nullable = false)
    public String middleName;

    @Column(name = "last_name", nullable = false)
    public String lastName;

    @Column(name = "age", nullable = false)
    public int age;

    @Column(name = "egn", nullable = false, unique = true, length = 10)
    private String egn;

    @Column(name = "email", nullable = false, unique = true)
    public String email;

    @Column(name = "address", nullable = false)
    public String address;

    //todo realtion to CityEntity
    @Column(name = "city_id", nullable = false)
    public int cityId;

    @Column(name = "is_active", nullable = false)
    public boolean isActive = true;

    @Column(name = "profile_image_id", nullable = true)
    public String profileImageId;

    @Column(name = "created_at")
    public LocalDateTime createdAt;

    @Column(name = "updated_at")
    public LocalDateTime updatedAt;


    public String getEgn() {
        return egn;
    }
    protected void setEgn(String egn) {
        this.egn = egn;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
