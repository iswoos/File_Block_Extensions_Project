package block.file_block_extensions_project.domain;

import block.file_block_extensions_project.domain.base.BaseEntity;
import block.file_block_extensions_project.dto.request.CustomRequestDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomExtension extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "custom_id")
    private Long id;

    @NotNull
    @Column(name = "custom_name")
    private String customExtensionName;

    @NotNull
    @Column(name = "custom_deleted")
    private String isDeleted = "N";

    public CustomExtension(CustomRequestDto.CustomRegisterRequestDto customExtensionName) {
        this.customExtensionName = customExtensionName.getCustomExtensionName();
    }
}
