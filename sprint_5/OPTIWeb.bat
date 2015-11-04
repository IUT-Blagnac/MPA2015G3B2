rem echo off
set SPRINTDIR=%~dp0
set SRCDIR=./src/
set BINDIR=./bin/
set ASCIIDOCDIR=.\tools\asciidoc-8.6.9\
set SRCDOCDIR=./OPTIweb/srcdoc/

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION de la librairie
@echo ///////////////////////////////////////////////////////
javac -cp %SRCDIR%;%BINDIR% -d %BINDIR% ./src/MakeOPTIweb.java
javac -cp %SRCDIR%;%BINDIR%;./tools/junit.jar -d %BINDIR% ./src/MOWTest.java

@echo ///////////////////////////////////////////////////////
@echo // EXECUTION des tests
@echo ///////////////////////////////////////////////////////
java -cp %BINDIR%;../tools/junit.jar MOWTest

@echo ///////////////////////////////////////////////////////
@echo // EXECUTION de l'application
@echo ///////////////////////////////////////////////////////
java -cp %BINDIR%;../tools/junit.jar MakeOPTIweb

pause

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION des documentations
@echo ///////////////////////////////////////////////////////

python %ASCIIDOCDIR%asciidoc.py -a iconsdir=../%ASCIIDOCDIR%/images/icons -o %SRCDOCDIR%docUtilisateur.html %SRCDOCDIR%docUtilisateur.txt

python %ASCIIDOCDIR%asciidoc.py -a iconsdir=../%ASCIIDOCDIR%/images/icons -o %SRCDOCDIR%docTechnique.html %SRCDOCDIR%docTechnique.txt

pause
