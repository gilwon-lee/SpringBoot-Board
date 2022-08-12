<!DOCTYPE html>
<%--
jsp를 이용하려면

1) build.gradle 폴더에
dependencies {
	implementation 'javax.servlet:jstl'
    implementation "org.apache.tomcat.embed:tomcat-embed-jasper"
} 를 추가

2) 톰캣과 같은 경로인
main/webapp/WEB-INF 폴더를 생성 한 후 그 안에 넣어 실행 한다.

3) controller return 파일을 설정 하기 위해
application.properties파일에
접두사,접미사 설정인
spring.mvc.view.prefix=/WEB-INF/
spring.mvc.view.suffix=.jsp
를 설정 해준다.
--%>


<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
  안녕하세요.
</body>
</html>