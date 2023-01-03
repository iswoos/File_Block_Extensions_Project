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

        fixedRepository.save(new FixedExtension("bat"));
        fixedRepository.save(new FixedExtension("cmd"));
        fixedRepository.save(new FixedExtension("com"));
        fixedRepository.save(new FixedExtension("cpl"));
        fixedRepository.save(new FixedExtension("exe"));
        fixedRepository.save(new FixedExtension("scr"));
        fixedRepository.save(new FixedExtension("js"));

    }

    @PreDestroy
    private void preDestroy(){
        fixedRepository.deleteAll();
    }
}
