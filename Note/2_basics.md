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
과거에는 Controller, View가 따로 분리되어있지 않았으나 View에 모든 코드를 작성했다 (Model one 방식). View는 화면을 그리는 데에 모든 역량을 집중한다. Controller나 Model은 비즈니스 로직과 관련이 있거나, 내부적인 것을 처리한다. 

## API
@ResponseBody : return으로서 http에서의 body부에 직접 내용을 넣겠다는 뜻. 
템플릿 엔진과의 차이는, API방식은 view 같은게 없고 return이 그대로 전달된다는 점이다. 템플릿 엔진은 View라는 템플릿 엔진을 조작하는 방식이다. 
