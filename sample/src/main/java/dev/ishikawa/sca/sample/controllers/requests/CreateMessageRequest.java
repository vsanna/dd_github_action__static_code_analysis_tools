package dev.ishikawa.sca.sample.controllers.requests;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateMessageRequest {
    @NotNull
    Long senderId;
    @NotNull
    Long receiverId;
    @NotNull
    String body;
}
