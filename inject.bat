@echo off
setlocal

set "sourceFolder=%~dp0gradle\caches"

set "gradleHome=%GRADLE_USER_HOME%"

if defined gradleHome (
  set "destinationFolder=%gradleHome%\caches"
) else (
  set "destinationFolder=C:\Users\%USERNAME%\.gradle\caches"
)

if not exist "%destinationFolder%" (
  mkdir "%destinationFolder%"
)

xcopy /E /I /Q /Y "%sourceFolder%" "%destinationFolder%"

endlocal