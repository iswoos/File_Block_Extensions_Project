package block.file_block_extensions_project.controller;


import block.file_block_extensions_project.dto.common.ResponseDto;
import block.file_block_extensions_project.dto.response.MainResponseDto;
import block.file_block_extensions_project.service.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/extensions")
public class MainController {

    private final MainService mainService;

    @GetMapping
    public ResponseDto<MainResponseDto> allExtensions(){
        return ResponseDto.success(mainService.allExtensions());
    }
}
