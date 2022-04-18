> # 남궁성의 Spring framework 강좌 - 기본편
> Spring 입문자를 위한 최고의 강좌 - https://fastcampus.co.kr/dev_academy_nks        
> Spring framework 강좌 - 심화편(준비중)  
> Spring boot 강좌 - 기본편(준비중), 심화편(준비중)  
> email : seong.namkung@gmail.com    
> 수강생 전용 Q&A : https://cafe.naver.com/ArticleList.nhn?search.clubid=10286641&search.menuid=220&search.boardtype=L  
> 수강생 전용 단톡방 : https://open.kakao.com/o/gatZ4lCd  
> 에러 메시지 모음 : https://docs.google.com/spreadsheets/d/1BkldpYLe9-rivzBnTXpeq31bU9QMoL1rzkoDBrht9ss/edit?usp=sharing  
<br>

# Part1. Spring 시작하기
## 1. 개요    
  - ### Spring이란?  
    Spring makes it easy to create Java **enterprise** applications.  
    https://spring.io/  
    https://docs.spring.io/spring-framework/docs/current/reference/html/overview.html#spring-introduction  
  - ### Spring MVC란?  
    A Spring MVC is a framework to build web applications. It follows the MVC(Model-View-Controller) design pattern.
    https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html  
    <br>
    **[참고]** MVC패턴이란? https://developer.mozilla.org/ko/docs/Glossary/MVC  
<br>

## 2. 개발 도구 설치 & 설정  

1. VS Code 설치 - https://code.visualstudio.com/download  
  - 유용한 플러그인 - https://marketplace.visualstudio.com/VSCode  
  한글 팩 - https://marketplace.visualstudio.com/items?itemName=MS-CEINTL.vscode-language-pack-ko  
  open in browser - https://marketplace.visualstudio.com/items?itemName=techer.open-in-browser  
  Prettier - Code formatter - https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode  
  indent-rainbow - https://marketplace.visualstudio.com/items?itemName=oderwat.indent-rainbow  
  태그이름 자동변경 - https://marketplace.visualstudio.com/items?itemName=formulahendry.auto-rename-tag   

<br>

2. git 설치  
    [Windows] https://git-scm.com/download/win      
  
    [Mac] 먼저 terminal열고, 아래와 같이 입력하고 엔터치세요.   

           $ git
           
     'git'명령어는... 도구를 설치하시겠습니까?라고 묻는 창이 열리면 '설치'를 클릭.(몇분 소요) 설치 완료 후, 아래와 같이 입력후 엔터.
           
           $ git --version  
           git version 2.28.0  

    위와 같이 나오면 설치가 잘된 것입니다. 버전이 조금 달라도 괜찮습니다.  
    <br>
    <br>

3. JDK11 설치  
    [자바의 정석 - 무료강의] https://youtube.com/playlist?list=PLW2UjW795-f6xWA2_MUhEVgPauhGl3xIp  

    [Windows] https://download.java.net/java/ga/jdk11/openjdk-11_windows-x64_bin.zip

    [Mac] SDKMAN을 이용해서 openJDK설치

   - SDKMAN 설치 - https://sdkman.io/install  

   ```
    $ curl -s "https://get.sdkman.io" | bash
    $ source "$HOME/.sdkman/bin/sdkman-init.sh"    
   ```

   - SDKMAN 명령어  
   ```
    $ sdk version  <--- sdkman 버전출력  
    $ sdk list java  <-- 설치 가능 & 설치된 JDK목록  
    $ sdk install java 11.0.12.7.2-amzn <--- 지정된 JDK설치(원하는 종류와 버전 지정)  
    $ sdk default java 11.0.12.7.2-amzn <--- 사용할 java버전을 변경(모든 쉘에 적용)
    $ sdk use java 11.0.12.7.2-amzn <--- 사용할 java버전을 변경(현재 쉘에만 적용)  
    $ sdk current java <--- 현재 사용중인 java버전 출력  
    $ echo $JAVA_HOME  <--- JAVA_HOME으로 지정된 경로 출력
   ```
   **[참고]** openJDK버전별 다운로드 - https://jdk.java.net/archive/
<br>
<br>

4. Tomcat 9 설치 - https://tomcat.apache.org/download-92.cgi  
  [Windows] https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.52/bin/apache-tomcat-9.0.52-windows-x64.zip  
  [Mac] https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.52/bin/apache-tomcat-9.0.52.tar.gz 
        <br>
    다운로드 받은 파일을 설치하고자하는 디렉토리로 이동후 아래의 명령을 실행. 압축을 풀어서 사용자의 홈디렉토리(~)에 저장.  

    ```
        $ tar -xvf apache-tomcat-9.0.52.tar.gz -C ~  
    ```

   **[참고]** 버전별 비교 - https://tomcat.apache.org/whichversion.html  
   **[참고]** RFC(Request For Comments) - https://ko.wikipedia.org/wiki/RFC  
   **[참고]** JSR(Java Specification Request) - https://jcp.org/en/jsr/overview  
   **[참고]** JCP(Java Community Process) - https://jcp.org/en/procedures/overview  
              https://ko.wikipedia.org/wiki/%EC%9E%90%EB%B0%94_%EC%BB%A4%EB%AE%A4%EB%8B%88%ED%8B%B0_%ED%94%84%EB%A1%9C%EC%84%B8%EC%8A%A4  
  <br>
    
   **Tomcat의 실행과 종료**  
       [Windows]  


   ```
        > cd C:\apache-tomcat-9.0.50\bin
        > startup.bat  <--- tomcat실행  
        > shutdown.bat <--- tomcat종료  
   ```  
 <br>
 
   [Mac]
 
 ```
        $ cd ~/apache-tomcat-9.0.50/bin   <--- tomcat이 설치된 경로의 bin디렉토리로 이동
        $ ./startup.sh  <--- tomcat실행  
        $ ./shutdown.sh <--- tomcat종료   
   ```
  <br>  
  <br>  
  
5. STS, IntelliJ 설치   
- **STS 3.9.17**  
**Windows** - https://download.springsource.com/release/STS/3.9.17.RELEASE/dist/e4.20/spring-tool-suite-3.9.17.RELEASE-e4.20.0-win32-x86_64.zip  
**MacOS** - https://download.springsource.com/release/STS/3.9.17.RELEASE/dist/e4.20/spring-tool-suite-3.9.17.RELEASE-e4.20.0-macosx-cocoa-x86_64.dmg  
**MacOS M1** - https://www.jetbrains.com/idea/download/download-thanks.html?platform=macM1  
[참고] MocOS M1의 STS설치 및 설정 - https://codechobo.tistory.com/28

- **IntelliJ**   
**Windows** - https://www.jetbrains.com/idea/download/#section=windows  
**MacOS** - https://www.jetbrains.com/idea/download/#section=mac  
**MacOS M1** - https://www.jetbrains.com/idea/download/download-thanks.html?platform=macM1  

[참고] IntelliJ 학생 라이센스 - https://www.jetbrains.com/shop/eform/students  
<br>


[Mac] - 위의 파일을 다운받아서 압축을 풀고, STS설치 폴더 내의 STS.ini의 중간에 아래의 2줄을 추가
```
  -vm  
  jdk설치경로\bin  
```  
  <BR>
    
**[STS.ini] - Windows**    
-startup  
plugins/org.eclipse.equinox.launcher_1.6.200.v20210416-2027.jar  
--launcher.library  
plugins/org.eclipse.equinox.launcher.win32.win32.x86_64_1.2.200.v20210429-1609  
-product  
org.springsource.sts.ide  
--launcher.defaultAction  
openFile  
**-vm**  
**c:\jdk11\bin\javaw.exe**  
-vmargs  
-Dosgi.requiredJavaVersion=11  
-Dosgi.dataAreaRequiresExplicitInit=true  
-Xms256m  
-Xmx2048m  
--add-modules=ALL-SYSTEM  
-Dosgi.module.lock.timeout=10  
  
<br>
<br>  
  
**[STS.ini] - Mac**    
-startup  
plugins/org.eclipse.equinox.launcher_1.6.200.v20210416-2027.jar  
--launcher.library  
plugins/org.eclipse.equinox.launcher.win32.win32.x86_64_1.2.200.v20210429-1609  
-product  
org.springsource.sts.ide  
--launcher.defaultAction  
openFile  
**-vm**  
**/Users/seongnamkung/.sdkman/candidates/java/current/bin**  
-vmargs  
-Dosgi.requiredJavaVersion=11  
-Dosgi.dataAreaRequiresExplicitInit=true  
-Xms256m  
-Xmx2048m  
--add-modules=ALL-SYSTEM  
-Dosgi.module.lock.timeout=10  
<br>      
<br>
  
  ## 3. AWS에 서버 구축하기  
  1. AWS란?  
Amazon이 제공하는 cloud service.  
관리가 쉽고 빠르고 유연한 확장성이 장점. 보안. 필요할 때만 사용하고, 사용한 만큼만 비용지불  

2. AWS에 가입하기 - 최초 가입시 12개월 동안 프리티어 계정(무료계정) 사용가능  
https://aws.amazon.com/ko/free  
[주의] 무료 사용량을 초과하면 과금될 수 있음.  

3. Amazon EC2 - 크기 조정이 가능한 컴퓨팅 용량을 클라우드에서 제공하는 웹 서비스  
https://aws.amazon.com/ko/ec2/  

   Amazon S3 - 확장성, 가용성, 내구성을 가진 데이터 저장 공간(Simple Storage)을 제공.  
   Amazon RDS - 관계형 DB 관리 서비스. 관계형 DB(MySQL, Oracle 등)를 모니터링, 주기적 백업  
<br>  
  
**[참고]** 관련 용어  
```
  on-Premise : 서버를 직접 운영하는 방식    
  Serverless : 서버 작업을 서버내부가 아닌 클라우드 서비스로 처리   
  Region : 데이터 센터가 물리적으로 존재하는 곳.  
  CDN(Content Delivery Network) : 정적 리소스를 빠르게 제공할 수 있게 전세계의 캐시서버에 복제해주는 서비스.  
```

