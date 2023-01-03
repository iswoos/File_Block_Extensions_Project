package block.file_block_extensions_project.dto.response;

import block.file_block_extensions_project.domain.CustomExtension;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CustomResponseDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CustomRegisterResponseDto {

        private String customExtensionName;

        public CustomRegisterResponseDto(CustomExtension customExtension) {
            this.customExtensionName = customExtension.getCustomExtensionName();
        }
    }
}
