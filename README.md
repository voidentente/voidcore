# Important

## Getting Started

### Java

JDK 8 is required.

The JDK can be prepared in `project structure/platform settings/sdks` and 
set in `settings/build, execution, deployment/build tools/gradle` (if Gradle plugin is used),
`project structure/project settings/project`, and `project structure/project settings/modules`.

JDK 8 should be available through your package manager or, on Windows,
be available for download at https://www.openlogic.com/openjdk-downloads.

Otherwise, the environment variable `JAVA_HOME` can also be set.

### Gradle

Gradle is bundled with this repository in `gradle/wrapper/gradle-4.4-bin.zip`.

Gradle should use `gradle/` as its home.

This is because `caches/` was manually repaired following a number of links being broken from age.

If this breaks at any point, feel free to manually set `GRADLE_USER_HOME`.

### BON2

CodeChickenCore/CodeChickenLib deobfuscates any mod in `run/mods` at runtime.

Mods that are used as libraries, however, might need to be deobfuscated manually to function, such as DragonAPI.

For this, `util/BON-DEOBFUSCATOR-2.2.3-all.jar` can be used, which provides a GUI for deobfuscation.

### Setting Up

If correctly configured, when opening this repository in IntelliJ IDEA, the gradle plugin should initialize the workspace.

Then, to set up the development environment, run the task `setupDecompWorkspace`.

### Issues

Feel free to share any issue, proposal, or remark with me.