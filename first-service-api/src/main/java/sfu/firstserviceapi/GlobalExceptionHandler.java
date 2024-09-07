package sfu.firstserviceapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sfu.firstserviceapi.dto.ErrorResponseDto;
import sfu.firstserviceapi.exception.CurrentBitcoinException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CurrentBitcoinException.class)
    public ResponseEntity<ErrorResponseDto> handleException() {
        return ResponseEntity
                .status(500)
                .body(ErrorResponseDto.builder()
                        .error("Something wrong")
                        .build());
    }
}
