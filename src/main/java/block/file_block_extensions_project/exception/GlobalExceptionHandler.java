package block.file_block_extensions_project.exception;

import block.file_block_extensions_project.dto.common.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomCommonException.class)
    public ResponseEntity<ResponseDto<Object>> customCommonException(CustomCommonException e) {
        return new ResponseEntity<>(ResponseDto.fail(e.getStatus(), e.getHttpStatus(), e.getMessage()), e.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto<Object>> exception(Exception e) {
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(ResponseDto.fail(
                errorCode.getStatus(), errorCode.getHttpStatus(), errorCode.getMessage()),
                errorCode.getHttpStatus());
    }

    /**
     * @valid  유효성체크에 통과하지 못하면  MethodArgumentNotValidException 이 발생한다.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object processValidationError(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    }
}
