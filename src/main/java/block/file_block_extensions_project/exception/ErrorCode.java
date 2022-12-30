package block.file_block_extensions_project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    // 400 BAD_REQUEST 잘못된 요청

    // 401 UNAUTHORIZED 권한 없음

    // 403 FORBIDDEN 접근 실패

    // 404 NOT_FOUND 존재하지 않음
    CUSTOM_ID_FOUND(404, HttpStatus.NOT_FOUND, "존재하지 않는 확장 추가자입니다."),

    //500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러입니다.");

    private final int status;
    private final HttpStatus httpStatus;
    private final String message;
}
