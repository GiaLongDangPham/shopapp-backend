package com.project.shopapp.response;

import com.project.shopapp.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterResponse {
    private String message;
    private User user;

}
