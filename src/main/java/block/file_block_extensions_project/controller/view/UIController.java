package block.file_block_extensions_project.controller.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UIController {

    // 모든 확장자 조회
    @GetMapping
    public String allExtensions() { return "main.html"; }
}
