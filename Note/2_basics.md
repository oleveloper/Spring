# 스프링 웹 개발 기초
## 정적 컨텐츠 (Static Content)
스프링부트는 정적 컨텐츠 기능을 기본으로 제공한다. 
정적 컨텐츠를 사용하기 위해서는 resources/static 디렉토리 안에 html 파일을 하나 만들고, 그 파일을 html문법으로 작성한다. 
어떠한 프로그래밍을 할 수는 없다. 

##### 원리
1. 웹브라우저에서 localhost:8080/hello-static.html으로 들어가면
2. 내장 톰캣 서버가 요청을 받고, 그 요청을 스프링에 넘긴다. 
3. 스프링은 먼저 컨트롤러 쪽에서 hello-static이 있는지 확인한다.
4. 컨트롤러가 없으면 resources:static/hello-static.html을 찾는다.
5. 있으면 반환한다. 


## MVC와 템플릿 엔진

## API
