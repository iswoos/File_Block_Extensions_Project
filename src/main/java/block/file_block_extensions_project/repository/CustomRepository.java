package block.file_block_extensions_project.repository;

import block.file_block_extensions_project.domain.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRepository extends JpaRepository<CustomExtension, Long> {
}
