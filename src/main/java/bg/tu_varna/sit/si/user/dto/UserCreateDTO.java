package bg.tu_varna.sit.si.user.dto;

import jakarta.validation.constraints.*;

public class UserCreateDTO {

    @NotBlank(message = "External user ID is required")
    public String externalUserId;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    public String firstName;

    @NotBlank(message = "Middle name is required")
    @Size(min = 2, max = 50, message = "Middle name must be between 2 and 50 characters")
    public String middleName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    public String lastName;

    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 120, message = "Age cannot exceed 120")
    public int age;

    @NotBlank(message = "EGN is required")
    @Size(min = 10, max = 10, message = "EGN must contain exactly 10 digits")
    @Pattern(regexp = "\\d{10}", message = "EGN must contain only digits")
    public String egn;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    public String email;

    @NotBlank(message = "Address is required")
    @Size(min = 5, max = 200, message = "Address must be between 5 and 200 characters")
    public String address;

    @Min(value = 1, message = "City ID must be a positive number")
    public int cityId;


    public String profileImageId;

    public UserCreateDTO() {}
}
