package block.file_block_extensions_project.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Slf4j
public class FixedExtension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fixed_id")
    private Long id;

    @Column(name = "fixed_name")
    private String fixedExtensionName;

    @Column(name = "fixed_checked")
    private String isChecked = "N";


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
