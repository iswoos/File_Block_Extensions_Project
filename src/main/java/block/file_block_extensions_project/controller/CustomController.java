package block.file_block_extensions_project.controller;

import block.file_block_extensions_project.dto.common.ResponseDto;
import block.file_block_extensions_project.dto.request.CustomRequestDto;
import block.file_block_extensions_project.dto.request.CustomRequestDto.CustomRegisterRequestDto;
import block.file_block_extensions_project.dto.response.CustomResponseDto;
import block.file_block_extensions_project.dto.response.CustomResponseDto.CustomRegisterResponseDto;
import block.file_block_extensions_project.service.CustomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static block.file_block_extensions_project.dto.response.CustomResponseDto.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/extensions")
public class CustomController {

    private final CustomService customService;

    // 커스텀 확장자 추가
    @PostMapping("/register")
    public ResponseDto<CustomRegisterResponseDto> customRegister(@RequestBody @Valid CustomRegisterRequestDto customRegisterRequestDto) {
        return ResponseDto.success(customService.customRegister(customRegisterRequestDto));
    }

    @DeleteMapping("/{customId}")
    public ResponseDto<CustomDeleteResponseDto> customDeleted(@PathVariable Long customId) {
        return ResponseDto.success(customService.customDeleted(customId));
    }

}
