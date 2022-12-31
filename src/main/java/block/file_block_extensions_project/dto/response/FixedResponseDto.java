package block.file_block_extensions_project.dto.response;

import block.file_block_extensions_project.domain.FixedExtension;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FixedResponseDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FixedCheckResponseDto {

        private String fixedExtensionName;

        private String isChecked;

        public FixedCheckResponseDto(FixedExtension fixedExtension) {
            this.fixedExtensionName = fixedExtension.getFixedExtensionName();
            this.isChecked = fixedExtension.getIsChecked();
        }
    }



}
