rem echo off
set ASCIIDOCDIR=.\tools\asciidoc-8.6.9\
set PLANTUMLDIR=.\tools\
set SPRINTDIR=%~dp0
set SRCDIR=./src/
set BINDIR=./bin/
set SRCDOCDIR=./srcdoc/
set DOCDIR=./doc/

set MAKETEST=1

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION des executables
@echo ///////////////////////////////////////////////////////
if "%MAKETEST%"=="1" (
  "%JAVA_HOME%\bin\javac" -cp . -d %BINDIR% @sourcefiles
)

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION des documentations
@echo ///////////////////////////////////////////////////////
"%JAVA_HOME%\bin\java" -jar %PLANTUMLDIR%plantuml.jar -Tpng -o %SRCDOCDIR%images %SRCDOCDIR%diag0.puml

python %ASCIIDOCDIR%asciidoc.py -a source-highlighter=pygments -o %SRCDOCDIR%doc.html %SRCDOCDIR%doc.txt
python %ASCIIDOCDIR%asciidoc.py -a source-highlighter=pygments -o %SRCDOCDIR%docU.html %SRCDOCDIR%docU.txt

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION des tests
@echo ///////////////////////////////////////////////////////
if "%MAKETEST%"=="1" (
  "%JAVA_HOME%\bin\javac" -cp .;./tools/junit.jar -d %BINDIR% @testfiles
)

@echo ///////////////////////////////////////////////////////
@echo // EXECUTION des tests
@echo ///////////////////////////////////////////////////////
if "%MAKETEST%"=="1" (
 cd %BINDIR%
 "%JAVA_HOME%\bin\java" -cp .;../tools/junit.jar HelloMondeTest
 "%JAVA_HOME%\bin\java" -cp .;../tools/junit.jar LibTest
 "%JAVA_HOME%\bin\java" -cp .;../tools/junit.jar LibCSVTest
 cd %SPRINTDIR%
)

pause