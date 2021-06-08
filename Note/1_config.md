# 프로젝트 환경설정
## 프로젝트 생성
* 스프링부트 스타터 사이트에서 스프링 프로젝트 생성
  * https://start.spiring.io
* 프로젝트 선택 
  * Maven / Gradle : 필요한 라이브러리를 가져오고 빌드 라이프사이클을 관리하는 툴. 
  * 최근에는 주로 Gradle을 사용한다.
* Project Metadata
  * Artifact : 빌드 된 후의 결과물 (Project 이름)
* Dependencies
  * 어떤 라이브러리를 가져올지 정한다.
  * 이 프로젝트(hello-spring)에서 사용하는 것
    * Spring Web : 웹 프로젝트에서 사용
    * Thymeleaf : HTML을 만들어주는 템플릿 엔진 

* IDE에서 build.gradle을 선택한 후 Open한다.
* 프로젝트 구조
  * .idea : intelliJ가 사용하는 설정파일
  * gradle : gradle 관련 디렉토리
  * src 
    * main 
      *  java : 실제 패키지와 소스 파일
      *  resources : 자바 코드파일을 제외한 xml, properties, html 등
    * test : 테스트코드와 관련된 소스
  * build.gradle : gradle 설정 파일
  * setting.gradle
