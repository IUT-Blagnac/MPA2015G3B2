rem echo off
set SPRINTDIR=%~dp0
set ASCIIDOCDIR=.\tools\asciidoc-8.6.9\
set PLANTUMLDIR=.\tools\
set SRCDOCDIR=./srcdoc/

@echo ///////////////////////////////////////////////////////
@echo // COMPILATION des documentations
@echo ///////////////////////////////////////////////////////
java -jar %PLANTUMLDIR%plantuml.jar -Tpng -o %SRCDOCDIR%images %SRCDOCDIR%diag0.puml

python %ASCIIDOCDIR%asciidoc.py -a iconsdir=../%ASCIIDOCDIR%/images/icons -o %SRCDOCDIR%docUtilisateur.html %SRCDOCDIR%docUtilisateur.txt

python %ASCIIDOCDIR%asciidoc.py -a iconsdir=../%ASCIIDOCDIR%/images/icons -o %SRCDOCDIR%docTechnique.html %SRCDOCDIR%docTechnique.txt

pause