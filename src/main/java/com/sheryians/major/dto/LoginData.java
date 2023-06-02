package com.sheryians.major.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginData {

    @NotBlank(message = "username canot be empty!!")
    @Size(min=3 ,max = 12, message = "username must be between 3 to 12 characters !!")
    private String userName;
    private String email;

}
