## File_Block_Extensions_Project 관련 이슈정리 완료
https://github.com/iswoos/File_Block_Extensions_Project/issues

<br>

## File_Block_Extensions_Project
파일 확장자 차단 현황을 보여주는 웹페이지입니다.

<br>

## 💡프로젝트 시작 전, 이건 준수하면서 한번 해보자!
1. 역할과 책임을 분리하여, 추후 유지보수가 용이하게끔 설계!
2. 우선 의도한대로 동작되도록 설계하고, 추후 효율적으로 동작하게 재조정!
3. 누가 보더라도 이해하기 쉽게끔, 가독성있게 코드 설계!

<br>

## 프로젝트의 목적
어떤 파일들은 첨부시 보안에 문제가 될 수 있다.
특히 exe, sh 등의 실행파일이 존재할 경우 서버에 올려서 실행이 될 수 있는 위험이 있어 파일 확장자 차단을 해야한다. 

<br>

## 요구사항

![image](https://user-images.githubusercontent.com/102216495/210049184-33949b13-ff5a-4207-b6a8-434e5d984f30.png)

### 1. 고정 확장자 관련

> 1. 고정 확장자의 default는 unCheck 되어져 있어야 한다.
> 2. 고정 확장자를 check or uncheck할 경우, 이는 곧바로 DB에 저장된다. 
(새로 고침 시 유지해야함 OR 자동으로 새로고침 시켜 반영시키도록 처리)
> 3. 페이지를 불러올 때마다 DB에서 Select해오도록 작업 지정
> 4. 아래쪽 커스텀 확장자에는 표현되지 않도록 처리해야함

### 2. 추가 확장자 관련

> 1. 추가 확장자의 최대 입력 길이는 20자리 지정
> 2. 추가버튼 클릭 시 DB에 저장되며, 아래쪽 영역에 표현됨 
(새로 고침 시 유지해야함 OR 자동으로 새로고침 시켜 반영시키도록 처리)
> 3. 추가 확장자는 최대 200개까지 추가 가능하도록 고정
> 4. 추가 확장자 옆 X를 클릭 시, DB에서 삭제되도록 처리 
(새로 고침 시 유지해야함 OR 자동으로 새로고침 시켜 반영시키도록 처리)

### 3. 이외 고려사항

> 1. 추가 확장자에 고정 확장자명과 동일한 확장자명이 추가되지 않게 제한처리
> 2. 추가 확장자에 이미 있는 확장자명은 추가되지 않도록 제한처리
> 3. 추가 확장자에 영문 소문자만 입력되도록 제한처리
> 4. 추가 확장자를 ENTER입력으로 추가되지 않게끔 제한처리

### 4. 별도 처리사항
> 1. 테스트 코드 구현진행
> 2. postConstruct / PreDestroy 활용, 고정 확장자 개수 코드단에서 변경 용이하게끔 설정
> 3. 코드 리팩토링 진행
> 4. 서버전용 yml (application.yml), 개발전용 yml (application-local.yml) 작성 후 활용
> 5. Git Commit 메세지 컨벤션 전략 진행

## API 설계서
![img_3.png](img_3.png)
<br>

## DB 모델링
![img_4.png](img_4.png)

<br>

## 🔠 Git Commit 메시지 컨벤션 전략 🔠
   
```
  - ⭐Feat : 새로운 기능 추가
  - 🐛Fix : 버그 수정
  - 📝Docs : 문서 수정
  - 🎨Design: CSS 등 사용자 UI 디자인 변경
  - 🗃️Style : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
  - 🔨Refactor : 코드 리펙토링
  - 🤝Test : 테스트 코드, 리펙토링 테스트 코드 추가
  - 🧐!BREAKING CHANGE: 커다란 API 변경의 경우
  - 🚨!HOTFIX: 급하게 치명적인 버그를 고쳐야하는 경우
  - 🔧Rename: 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우
  - ➖Remove:파일을 삭제하는 작업만 수행한 경우
  - 📌Comment: 필요한 주석 추가 및 변경
  - 🎉Begin: 프로젝트 초기 설정
