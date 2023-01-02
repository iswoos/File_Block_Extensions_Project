package block.file_block_extensions_project.dto.response;

import block.file_block_extensions_project.domain.CustomExtension;
import block.file_block_extensions_project.domain.FixedExtension;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MainResponseDto {

    private List<FixedExtension> allFixedExtensions;
    private List<CustomExtension> allCustomExtensions;
}
