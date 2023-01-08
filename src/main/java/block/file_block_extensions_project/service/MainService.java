package block.file_block_extensions_project.service;

import block.file_block_extensions_project.domain.CustomExtension;
import block.file_block_extensions_project.domain.FixedExtension;
import block.file_block_extensions_project.dto.response.MainResponseDto;
import block.file_block_extensions_project.repository.CustomRepository;
import block.file_block_extensions_project.repository.FixedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainService {

    private final FixedRepository fixedRepository;
    private final CustomRepository customRepository;

    public MainResponseDto allExtensions() {
        List<FixedExtension> allFixedExtensions = fixedRepository.findAll();
        List<CustomExtension> allCustomExtensions = customRepository.findAll();

        return new MainResponseDto(allFixedExtensions, allCustomExtensions);
    }
}
