package block.file_block_extensions_project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    // 400 BAD_REQUEST 잘못된 요청
    EXIST_CUSTOM_NAME(400, HttpStatus.BAD_REQUEST, "이미 존재하는 추가 확장자 이름입니다."),

    OVER_CUSTOM_COUNT(400, HttpStatus.BAD_REQUEST, "추가 확장자 등록 개수 200개를 초과하였습니다."),

    EXIST_FIXED_NAME(400, HttpStatus.BAD_REQUEST, "고정 확장자에 이미 존재하는 확장자 이름입니다."),

    // 401 UNAUTHORIZED 권한 없음

    // 403 FORBIDDEN 접근 실패

    // 404 NOT_FOUND 존재하지 않음
    FIXED_ID_FOUND(404, HttpStatus.NOT_FOUND, "존재하지 않는 고정 확장자입니다."),

    CUSTOM_ID_FOUND(404, HttpStatus.NOT_FOUND, "존재하지 않는 추가 확장자입니다."),

    //500 INTERNAL SERVER ERROR
    INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러입니다.");

    private final int status;
    private final HttpStatus httpStatus;
    private final String message;
}
