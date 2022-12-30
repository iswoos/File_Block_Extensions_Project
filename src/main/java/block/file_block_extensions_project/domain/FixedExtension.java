package block.file_block_extensions_project.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FixedExtension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fixed_id")
    private Long id;

    @Column(name = "fixed_name")
    private String fixedExtensionName;

    @Column(name = "fixed_checked")
    private String isChecked = "N";
}
