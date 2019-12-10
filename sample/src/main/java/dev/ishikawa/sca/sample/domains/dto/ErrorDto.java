package dev.ishikawa.sca.sample.domains.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
public class ErrorDto {
    @NotNull
    String message;
    @NotNull
    String code;
    @NotNull
    String codeId;
    @NotNull
    String status;

}
