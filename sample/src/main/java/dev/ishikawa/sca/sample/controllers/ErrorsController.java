package dev.ishikawa.sca.sample.controllers;

import com.google.gson.Gson;
import dev.ishikawa.sca.sample.domains.dto.ErrorDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class ErrorsController {
//    @ExceptionHandler(YMoneyFrozenException.class)
//    public ResponseEntity<String> handleYMoneyFrozenException(YMoneyFrozenException ex, HttpServletRequest req) {
//        LoggingUtil.setToRequest(req, ex.getResultInfo(), ex);
//        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), ex.getResultInfo(), buildMessage(ex));
//    }
//
//    @ExceptionHandler(YMoneyMigratorRuntimeException.class)
//    public ResponseEntity<String> handleYMoneyMigratorRuntimeException(YMoneyMigratorRuntimeException ex, HttpServletRequest req) {
//        ResultInfo resultInfo = Optional.ofNullable(ex.getResultInfo()).isPresent() ? ex.getResultInfo() : ResultInfoContants.BAD_REQUEST;
//        LoggingUtil.setToRequest(req, resultInfo, ex);
//        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), resultInfo, buildMessage(ex));
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnexpectedException(Exception ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    private ResponseEntity<String> buildResponse(
            HttpStatus statusCode,
            String errorMessage
    ) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Gson gson = new Gson();

        ErrorDto errorEntity = ErrorDto.builder()
                .status("F")
                .code("SOME_ERROR")
                .codeId("E00000000")
                .message(errorMessage)
                .build();

        return ResponseEntity
                .status(statusCode)
                .headers(headers)
                .body(gson.toJson(errorEntity));
    }
}
