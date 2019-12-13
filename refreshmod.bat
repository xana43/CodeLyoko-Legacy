
SET mine=G:\mmc-stable-win32\MultiMC\instances\1.12.21\.minecraft\mods
XCOPY %CD%\build\libs\*.* %mine% /Y /EXCLUDE:%CD%\exclude.txt
pause