package bg.tu_varna.sit.si.user.dto;

import jakarta.validation.constraints.*;

public class UserUpdateDTO {
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name length must be between 2 and 50 characters")
    public String firstName;

    @Size(max = 50, message = "Middle name cannot exceed 50 characters")
    public String middleName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name length must be between 2 and 50 characters")
    public String lastName;

    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 120, message = "Age cannot exceed 120")
    public int age;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    public String email;

    @NotBlank(message = "Address is required")
    @Size(min = 5, max = 200, message = "Address length must be between 5 and 200 characters")
    public String address;

    @Positive(message = "City ID must be a positive number")
    public int cityId;

    @NotNull(message = "Profile image ID cannot be null")
    public String profileImageId;

    public boolean isActive;


    public UserUpdateDTO() {
    }
}
