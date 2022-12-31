package block.file_block_extensions_project.controller;

import block.file_block_extensions_project.dto.common.ResponseDto;
import block.file_block_extensions_project.dto.response.FixedResponseDto;
import block.file_block_extensions_project.repository.FixedRepository;
import block.file_block_extensions_project.service.FixedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/extensions")
public class FixedController {

    private final FixedService fixedService;

    @PatchMapping("/check/{fixedId}")
    public ResponseDto<FixedResponseDto.FixedCheckResponseDto> fixedChecked(@PathVariable Long fixedId) {
        return ResponseDto.success(fixedService.fixedChecked(fixedId));
    }
}
