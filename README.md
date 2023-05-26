# Getting Started

## What is this?

This is a Minecraft Forge 1.7.10 development environment template for building on top of DragonAPI.

It is largely self-contained, meaning that once the repo is downloaded, 
no further internet connection should be required.

## Issues

Feel free to contribute errors and your ideas and proposals with issues.

## Rundown

After cloning the repo, you do not need an internet connection.
To test this, you can cut your internet connection from here on out.

### 1. Inject Cache

This template works by injecting the gradle cache at `GRADLE_USER_HOME` with with required dependencies.
For this, the script `inject` is provided in batch and bash form. This must only be done once.

### 2. Start IDEA

Start IDEA and open the repository.

### 3. Enable Gradle

..if the extension is not already active.

### 4. Configure Gradle

Go to `File | Settings | Build, Execution, Deployment | Build Tools | Gradle`.
There, set Gradle to use a Java 8 (1.8) JVM.

IDEA allows you to download a Java 8 JDK without leaving the IDE,
but one can also be obtained using a package manager or
by downloading a build from providers such as 
[OpenLogic](https://www.openlogic.com/openjdk-downloads)
or [Amazon](https://aws.amazon.com/de/corretto).

You must also point Gradle to its home.
To do this, under `Use Gradle from`, select `Specified location` and select the `gradle` folder in the repository.

Once done, click OK. Gradle should now sync the workspace.

### 5. Build the Example

Once Gradle is done syncing the workspace, open the Gradle window on the right side of the IDE,
and run the task `forge-1.7.10-offline-template | Tasks | build | build`.

Gradle should now build the jar and put it into the `build/libs` folder.

If you encounter any error here, retry the build. If it doesn't work the second try, feel free to open an issue.

### 6. Run the Live Client

To shorten the development lifecycle, a Minecraft instance can be started by running the task
`forge-1.7.10-offline-template | Tasks | forgegradle | runClient`.

This Minecraft instance loads any libraries that you compile and any mods you put in `run/mods`.

### Common Errors

> Cannot find symbol / Cannot resolve symbol

This indicates that the mod might have to be deobfuscated.

- Mods placed in `run/mods` are deobfuscated at runtime by CCC.
- To manually deobfuscate libraries and mods, the bundled BON2-deobfuscator can be used.

> Class not found

This indicates that a dependency is missing. Try to add the missing dependency.