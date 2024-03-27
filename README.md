# README #

###  Robot Symptom Screening Station ###

Based on Furhat Robotics tamplate. 
The robot engages people to interact in a conversation, and asks them questions to screen them for pre-diabetes. 
The interaction is assisted by a screen and supported in three languages.

At the end of the interaction, depending on the result of the screening, the robot can recommend the person to take the appropriate next steps,
such as getting in contact with a medical doctor/center for follow up.

### Setup ###
* In IntelliJ: Import the skill as a gradle project
* Make sure your Kotlin Compiler's Target JVM Version is 1.8.
* Run `npm install && npm run build` the first time and after each change to GUI (under the `assets/webTemplates/BASIC/` folder). 
**Note** : You need to be running node 12. You can use [nvm](https://github.com/nvm-sh/nvm#intro) to handle your node version easily.
* Run or debug the skill by right-clicking the `main`-function in `main.kt`
* Package a skills by running the gradle build target shadowJar. It will create a .skill file in the build/libs directory 
