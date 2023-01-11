package block.file_block_extensions_project.controller.view;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UIController {

    // 해당 컨트롤러를 통해 페이지를 출력한 것을 조금 더 다른 방식으로 개선할 수 있지않겠는가? 라는 피드백을 주셨음.
    // 이 출력과정을 어떻게 바꿔볼지 공부가 필요함...!
    // 모든 확장자 조회
    @GetMapping
    public String allExtensions() { return "main.html"; }
}
