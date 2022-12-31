package block.file_block_extensions_project.service;

import block.file_block_extensions_project.domain.CustomExtension;
import block.file_block_extensions_project.dto.common.ResponseDto;
import block.file_block_extensions_project.dto.request.CustomRequestDto;
import block.file_block_extensions_project.dto.response.CustomResponseDto;
import block.file_block_extensions_project.exception.CustomCommonException;
import block.file_block_extensions_project.exception.ErrorCode;
import block.file_block_extensions_project.repository.CustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CustomService {

    private final CustomRepository customRepository;

    public CustomResponseDto.CustomRegisterResponseDto customRegister(CustomRequestDto.CustomRegisterRequestDto customRegisterRequestDto) {
        CustomExtension customExtension = new CustomExtension(customRegisterRequestDto);
        customRepository.save(customExtension);
        return new CustomResponseDto.CustomRegisterResponseDto(customExtension);
    }

    public CustomResponseDto.CustomRegisterResponseDto customDeleted(Long customId) {
        CustomExtension customExtension = customRepository.findById(customId).orElseThrow(
                () -> new CustomCommonException(ErrorCode.CUSTOM_ID_FOUND)
        );

        customRepository.delete(customExtension);
        return new CustomResponseDto.CustomRegisterResponseDto(customExtension);
    }
}
