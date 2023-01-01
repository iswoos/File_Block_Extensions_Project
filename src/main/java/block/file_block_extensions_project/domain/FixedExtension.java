package block.file_block_extensions_project.domain;

import block.file_block_extensions_project.domain.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class FixedExtension extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fixed_id")
    private Long id;

    @NotNull
    @Column(name = "fixed_name")
    private String fixedExtensionName;
    @NotNull
    @Column(name = "fixed_checked")
    private String isChecked = "N";


    public FixedExtension(String fixedExtensionName) {
        this.fixedExtensionName = fixedExtensionName;;
    }

    public void changeChekced() {
        log.info("업데이트 중");
        if (this.isChecked.equals("N")) {
            log.info("N 스트링이 맞다!");
            this.isChecked = "Y";
        } else {
            this.isChecked = "N";
        }
    }
}
