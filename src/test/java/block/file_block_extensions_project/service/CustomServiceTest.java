package block.file_block_extensions_project.service;


import block.file_block_extensions_project.domain.CustomExtension;
import block.file_block_extensions_project.domain.FixedExtension;
import block.file_block_extensions_project.dto.request.CustomRequestDto;
import block.file_block_extensions_project.exception.CustomCommonException;
import block.file_block_extensions_project.repository.CustomRepository;
import block.file_block_extensions_project.repository.FixedRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("local")
@SpringBootTest
@Transactional
class CustomServiceTest {

    @Autowired
    private CustomService customService;
    @Autowired
    private CustomRepository customRepository;

    @Autowired
    private FixedRepository fixedRepository;

    @BeforeEach
    public void beforeEach() {
        customRepository.deleteAll();
        fixedRepository.deleteAll();
    }

    @AfterEach
    public void afterEach() {
        customRepository.deleteAll();
        fixedRepository.deleteAll();
    }


    @Test
    @DisplayName("추가 확장자는 200개 이상 기재할 수 없도록 제한한다. ")
    void customMaxRegister() throws Exception{
        //given
        for (int i = 1; i <= 200; i++) {
            customRepository.save(new CustomExtension("test"));
        }

        //when
        CustomCommonException exception = Assertions.assertThrows(CustomCommonException.class, () -> {
            customService.customRegister(new CustomRequestDto.CustomRegisterRequestDto("xxxx"));
        });
        //then
        Assertions.assertEquals("추가 확장자 등록 개수 200개를 초과하였습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("추가 확장자는 동일한 확장자명 등록을 제한한다.")
    void customExistRegister() {
        //given
        customRepository.save(new CustomExtension("testcustom"));

        //when
        CustomCommonException exception = Assertions.assertThrows(CustomCommonException.class, () -> {
            customService.customRegister(new CustomRequestDto.CustomRegisterRequestDto("testcustom"));
        });

        //then
        Assertions.assertEquals("이미 존재하는 추가 확장자 이름입니다.", exception.getMessage());
    }

    @Test
    @DisplayName("추가 확장자로 고장 확장자명에 있는 걸 추가하는 것을 제한한다.")
    void customLengthMaxRegister() {
        //given
        fixedRepository.save(new FixedExtension("bat"));

        //when
        CustomCommonException exception = Assertions.assertThrows(CustomCommonException.class, () -> {
            customService.customRegister(new CustomRequestDto.CustomRegisterRequestDto("bat"));
        });

        //then
        Assertions.assertEquals("고정 확장자에 이미 존재하는 확장자 이름입니다.", exception.getMessage());
    }
}