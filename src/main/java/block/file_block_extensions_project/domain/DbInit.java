//package block.file_block_extensions_project.domain;
//
//
//import block.file_block_extensions_project.repository.FixedRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
//@Component
//public class DbInit {
//    @Autowired
//    private FixedRepository fixedRepository;
//
//    @PostConstruct
//    private void postConstruct() {
//        FixedExtension admin = new FixedExtension();
//        FixedExtension normalUser = new FixedExtension();
//        fixedRepository.save(admin, normalUser);
//    }
//
//}
