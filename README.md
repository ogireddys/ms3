# ms3
ms3 demo project

# Environment
1) Mule 3.9
2) JDK 1.8
3) Java Algorithm avialable at location src/main/java/ms3project/FindMultiples.java

# Steps to install/run the project:

1) download/clone the project
2) open in anypoint studio
3) run ms3project.xml to deploy to mule standalone server
4) open GET REST call http://localhost:8081/findReplaceAll?input1=56&input2=100&order=natural
5) input1 & input2 query params represent lower and upper bound of the range
6) order=reverse sorts the list in desc order of keys. natural order by default
7) Alternately use local rest client UI available in project directory src/main/resources/rest_client.html.
   open in chrome/firefox
