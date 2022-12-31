package block.file_block_extensions_project.controller;

import block.file_block_extensions_project.repository.FixedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/extensions")
public class FixedController {

    private final FixedRepository fixedRepository;


}
