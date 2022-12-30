package block.file_block_extensions_project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CustomRequestDto {


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CustomRegisterRequestDto {

        @NotEmpty(message = "추가확장자 이름을 입력해주세요")
        @Length(max = 20)
        private String customExtensionName;

    }
}
