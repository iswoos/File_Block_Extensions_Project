package block.file_block_extensions_project.service;

import block.file_block_extensions_project.domain.FixedExtension;
import block.file_block_extensions_project.dto.response.FixedResponseDto.FixedCheckResponseDto;
import block.file_block_extensions_project.exception.CustomCommonException;
import block.file_block_extensions_project.exception.ErrorCode;
import block.file_block_extensions_project.repository.FixedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FixedService {

    private final FixedRepository fixedRepository;

    @Transactional
    public FixedCheckResponseDto fixedChecked(Long fixedId) {
        FixedExtension fixedExtension = fixedRepository.findById(fixedId).orElseThrow(
                () -> new CustomCommonException(ErrorCode.FIXED_ID_FOUND)
        );

        log.info(fixedExtension.getFixedExtensionName());
        log.info(fixedExtension.getFixedExtensionType().getClass().getName());

        fixedExtension.changeChekced();

        log.info("업데이트 완료");

        return new FixedCheckResponseDto(fixedExtension);
    }
}
