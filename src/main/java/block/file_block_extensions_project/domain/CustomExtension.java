package block.file_block_extensions_project.domain;

import block.file_block_extensions_project.domain.base.BaseEntity;
import block.file_block_extensions_project.dto.request.CustomRequestDto.CustomRegisterRequestDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomExtension extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custom_id")
    private Long id;

    @NotNull
    @Column(name = "custom_name")
    private String customExtensionName;

    public CustomExtension(CustomRegisterRequestDto customExtensionName) {
        this.customExtensionName = customExtensionName.getCustomExtensionName();
    }

    public CustomExtension(String customExtensionName) {
        this.customExtensionName = customExtensionName;
    }
}
