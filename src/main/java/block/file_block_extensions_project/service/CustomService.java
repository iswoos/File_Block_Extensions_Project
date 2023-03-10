package block.file_block_extensions_project.service;

import block.file_block_extensions_project.domain.CustomExtension;
import block.file_block_extensions_project.dto.request.CustomRequestDto.CustomRegisterRequestDto;
import block.file_block_extensions_project.dto.response.CustomResponseDto;
import block.file_block_extensions_project.dto.response.CustomResponseDto.CustomRegisterResponseDto;
import block.file_block_extensions_project.exception.CustomCommonException;
import block.file_block_extensions_project.exception.ErrorCode;
import block.file_block_extensions_project.repository.CustomRepository;
import block.file_block_extensions_project.repository.FixedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static block.file_block_extensions_project.dto.response.CustomResponseDto.*;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomService {
    private final CustomRepository customRepository;
    private final FixedRepository fixedRepository;

    @Transactional
    public CustomRegisterResponseDto customRegister(CustomRegisterRequestDto customRegisterRequestDto) {
        if (customRepository.findByCustomExtensionName(customRegisterRequestDto.getCustomExtensionName()).isPresent()) {
            throw new CustomCommonException(ErrorCode.EXIST_CUSTOM_NAME);
        }

        else if (fixedRepository.findByFixedExtensionName(customRegisterRequestDto.getCustomExtensionName()).isPresent()) {
            throw new CustomCommonException(ErrorCode.EXIST_FIXED_NAME);
        }

        else if (customRepository.count() >= 200) {
            throw new CustomCommonException(ErrorCode.OVER_CUSTOM_COUNT);
        }

        else{
            CustomExtension customExtension = new CustomExtension(customRegisterRequestDto);
            customRepository.save(customExtension);
            return new CustomRegisterResponseDto(customExtension);
        }
    }

    @Transactional
    public CustomDeleteResponseDto customDeleted(Long customId) {
        CustomExtension customExtension = customRepository.findById(customId).orElseThrow(
                () -> new CustomCommonException(ErrorCode.CUSTOM_ID_FOUND)
        );

        customRepository.delete(customExtension);
        return new CustomDeleteResponseDto(customExtension);
    }
}
