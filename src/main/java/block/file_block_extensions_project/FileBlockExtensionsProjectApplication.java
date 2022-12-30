package block.file_block_extensions_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FileBlockExtensionsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileBlockExtensionsProjectApplication.class, args);
    }

}
