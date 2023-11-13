@REM git auto commit and push

@echo off
setlocal

@REM Get current branch
for /f "tokens=*" %%G in ('git branch ^| findstr /C:"*"') do set "br=%%G"

echo Auto commit and push to branch: [%br:~2%]

@REM Add changes to git.
git add .

@REM Get current dir git config user name
for /f "usebackq tokens=*" %%A in (`git config user.name`) do set "name=%%A"

@REM Commit changes.
set "msg=auto commit and push by %name% on %date:~0,4%-%date:~5,2%-%date:~8,2% %time:~0,2%:%time:~3,2%:%time:~6,2%"

if "%~1" neq "" (
  set "msg=%~1"
)

git commit -m "%msg%"

@REM Push source and build repos.
git push -u origin %br:~2%

endlocal
