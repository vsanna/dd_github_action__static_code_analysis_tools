package dev.ishikawa.sca.sample.controllers.requests;

import lombok.Getter;
import javax.validation.constraints.NotNull;

@Getter
public class CreateUserRequest {
    @NotNull
    String name;

    @NotNull
    String phoneNumber;
}
