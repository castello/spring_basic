> # 남궁성의 Spring framework 강좌 - 기본편
> Spring입문자를 위한 최고의 강좌  @fastcampus.co.kr                    

## Part1. Spring 시작하기
### 1. 개요

### 2. 설치 & 설정
- git 설치 - https://git-scm.com/downloads 
- SDKMAN을 이용한 JDK1.8 설치 - https://sdkman.io/install  
  $ curl -s "https://get.sdkman.io" | bash <--- sdkman 설치   
  $ source "$HOME/.sdkman/bin/sdkman-init.sh" <--- sdkman 설정
  
  $ sdk version  <--- sdkman 버전출력  
  $ sdk java list  <-- 설치 가능 & 설치된 JDK목록  
  $ sdk install Identifier <--- 지정된 JDK설치(Identifier대신 8.292.10.1-amzn와 같이 원하는 종류와 버전 지정)  
  $ sdk java current <--- 현재 사용중인 java버전  
  $ sdk use java 버전 <--- 현재 사용중인 java버전을 지정된 버젼으로 변경  
  $ echo $JAVA_HOME <--- JAVA_HOME으로 지정된 경로 출력  
  $ sdk uninstall java 버전  <--- 지정된 버전의 자바를 uninstall  

  
  [참고] SDKMAN없이 JDK직접 설치 - [\[YouTube\] 자바 개발도구 JDK 설치 방법](https://youtu.be/Q1AGokud_x4)

- Tomcat 9 설치 - https://tomcat.apache.org/download-90.cgi  
  버전별 비교 - https://tomcat.apache.org/whichversion.html
  
- STS, IntelliJ 설치    
1. **STS 3.9.17**  
**Windows** - https://download.springsource.com/release/STS/3.9.17.RELEASE/dist/e4.20/spring-tool-suite-3.9.17.RELEASE-e4.20.0-win32-x86_64.zip  
**MacOS** - https://download.springsource.com/release/STS/3.9.17.RELEASE/dist/e4.20/spring-tool-suite-3.9.17.RELEASE-e4.20.0-macosx-cocoa-x86_64.dmg  
**Linux** - https://download.springsource.com/release/STS/3.9.17.RELEASE/dist/e4.20/spring-tool-suite-3.9.17.RELEASE-e4.20.0-linux-gtk-x86_64.tar.gz  

2. **IntelliJ**   
**Windows** - https://www.jetbrains.com/idea/download/#section=windows  
**MacOS** - https://www.jetbrains.com/idea/download/#section=mac  
**Linux** - https://www.jetbrains.com/idea/download/#section=linux  

- VS Code 설치 - https://code.visualstudio.com/download
