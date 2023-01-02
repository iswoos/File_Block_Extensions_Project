package block.file_block_extensions_project.repository;

import block.file_block_extensions_project.domain.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomRepository extends JpaRepository<CustomExtension, Long> {

//    Optional<CustomExtension> findByCustomExtensionName(String CustomExtensionName);

}
