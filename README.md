# freelec-springboot2-webservice [![Build Status](https://travis-ci.com/ohjiwon-201733026/freelec-springboot2-webservice.svg?branch=master)](https://travis-ci.com/ohjiwon-201733026/freelec-springboot2-webservice)


###프로젝트 소개  
> 게시판을 Spring Data JPA로 구현하고 테스트 코드를 Unit을 사용해 테스트 코드를 작성하였습니다. AWS EC2에 S3와 CodeDeploy를 사용해 애플리케이션을 배포하였습니다.
  
  <br><br>
###주요 기능  
> + 게시판 CRUD
> + JUnit으로 테스트 수행
> + TravisCI로 통합, 테스트
> + AWS EC2 서버에 배포   
  
  <br><br>
###사용 기술  
> + 개발 언어 : Java, JavaScript  
> + 프레임워크 : Spring Boot Gradle  
> + DB : AWS RDS, MariaDB  
> + 서버 : AWS EC2  
> + 기타 : gitHub,TravisCI   
  
<br><br>  
###상세 기능  
> 1. 게시판 CRUD
>     + 게시글 목록  
>     + 게시글 등록  
>     + 게시글 수정  
>     + 게시글 삭제 
> 2. 테스트 코드 작성  
>     + 게시물 등록  
>       MockMvc를 사용하여 post 메서드로 url에 전송하고 응답 상태가 200(success)인지 확인  
>     + findAll test
>     + 게시물 수정   
> 3. EC2 배포
>     + TravisCI와 Github 연동  
>     + 배포 전 jar 파일 등 배포에 필요한 파일들 압축하여 AWS S3 버킷으로 전달  
>     + deploy 쉘 스크립트 작성  
>     + 구동중인 애플리케이션 kill 하고 새 애플리케이션 배포하여 실행  
>     + nginX로 무중단 배포   
>     + 8081, 8082 포트 2개를 사용하여 서비스 중이 아닌 포트에 새 애플리케이션을 배포하고 포트를 전환시켜줌

<br>
<br>

![image](https://user-images.githubusercontent.com/62784947/131619998-3a2bfb6f-b2ed-4608-8f42-e1d9e71002ce.png)
