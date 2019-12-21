@echo off

set "CURRENT_DIR=%cd%"
set SERVER_NAME=TestService
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_151
set EXECUTABLE=%CURRENT_DIR%\bin\prunsrv.exe
set CLASSPATH=%CURRENT_DIR%\out\production\DaemonTest
set JVM=C:\Program Files\Java\jdk1.8.0_151\jre\bin\server\jvm.dll
set START_CLASS=com.company.Main

"%EXECUTABLE%" //IS//%SERVER_NAME% ^
--Classpath="%CLASSPATH%" ^
--Jvm="%JVM%" ^
--StartMode=jvm ^
--StopMode=jvm ^
--StartClass=%START_CLASS% ^
--StopClass=%START_CLASS% ^
--StartMethod=start ^
--StopMethod=stop ^
--StdOutput=%CURRENT_DIR%/stdout.log ^
--StdError=%CURRENT_DIR%/stderr.log ^
--Startup=auto