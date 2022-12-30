package block.file_block_extensions_project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CustomRequestDto {


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CustomRegisterRequestDto {

        private String customExtensionName;

    }
}
