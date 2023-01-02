package block.file_block_extensions_project.db;


import block.file_block_extensions_project.domain.FixedExtension;
import block.file_block_extensions_project.repository.FixedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@RequiredArgsConstructor
public class DbInit {
    private final FixedRepository fixedRepository;

    @PostConstruct
    private void postConstruct() {
        FixedExtension bat = new FixedExtension("bat");
        FixedExtension cmd = new FixedExtension("cmd");
        FixedExtension com = new FixedExtension("com");
        FixedExtension cpl = new FixedExtension("cpl");
        FixedExtension exe = new FixedExtension("exe");
        FixedExtension scr = new FixedExtension("scr");
        FixedExtension js = new FixedExtension("js");
        fixedRepository.save(bat);
        fixedRepository.save(cmd);
        fixedRepository.save(com);
        fixedRepository.save(cpl);
        fixedRepository.save(exe);
        fixedRepository.save(scr);
        fixedRepository.save(js);
    }

    @PreDestroy
    private void preDestroy(){
        fixedRepository.deleteAll();
    }
}
