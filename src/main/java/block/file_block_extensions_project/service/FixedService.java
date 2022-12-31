package block.file_block_extensions_project.service;

import block.file_block_extensions_project.domain.FixedExtension;
import block.file_block_extensions_project.dto.response.FixedResponseDto;
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
@Transactional
public class FixedService {

    private final FixedRepository fixedRepository;

    @Transactional
    public FixedResponseDto.FixedCheckResponseDto fixedChecked(Long fixedId) {
        FixedExtension fixedExtension = fixedRepository.findById(fixedId).orElseThrow(
                () -> new CustomCommonException(ErrorCode.FIXED_ID_FOUND)
        );

        log.info(fixedExtension.getFixedExtensionName());
        log.info(fixedExtension.getIsChecked());
        log.info(fixedExtension.getIsChecked().getClass().getName());

        fixedExtension.changeChekced();

        log.info("업데이트 완료");

        return new FixedResponseDto.FixedCheckResponseDto(fixedExtension);
    }
}
