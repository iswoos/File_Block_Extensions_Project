package block.file_block_extensions_project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

public class CustomRequestDto {


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CustomRegisterRequestDto {

        @Size(max = 20, message = "최대입력 길이는 20자입니다.")
        private String customExtensionName;


    }
}
