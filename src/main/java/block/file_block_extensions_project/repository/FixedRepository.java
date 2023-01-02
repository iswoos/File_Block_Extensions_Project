package block.file_block_extensions_project.repository;

import block.file_block_extensions_project.domain.FixedExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FixedRepository extends JpaRepository<FixedExtension, Long> {

    Optional<FixedExtension> findByFixedExtensionName(String CustomExtensionName);


}
