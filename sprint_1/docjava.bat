rem echo off
set SPRINTDIR=%~dp0
set SRCDIR=./src/
set BINDIR=./bin/

set RUNTEST=1

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION de la librairie
@echo ///////////////////////////////////////////////////////
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%OPTIlib.java
javac -cp .;%BINDIR%;./tools/junit.jar -d %BINDIR% %SRCDIR%OPTIlibTest.java

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION de l'IHM
@echo ///////////////////////////////////////////////////////
javac -cp .;%BINDIR% -d %BINDIR% %SRCDIR%OPTI.java

@echo ///////////////////////////////////////////////////////
@echo // EXECUTION des tests
@echo ///////////////////////////////////////////////////////
if "%RUNTEST%"=="1" (
 cd %BINDIR%
 java -cp .;../tools/junit.jar OPTIlibTest
 cd %SPRINTDIR%
)

pause