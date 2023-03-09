### 빌드 과정

#### maven -> gradle
1. gradle 설치
2. pom.xml 경로에서 gradle init
3. 의존성 수정(예시. gradle compile 을 implementation으로)
4. ./gradlew build 명령어 입력 후 성공 여부 확인
#### build
1. react 에 해당하는 디렉토리(frontent)로 접근, npm start 가 정상 작동한다면, npm install
2. npm run-script build, npm run eject 순차 실행(오류가 난다면 git 에 push 하지 않은 항목이 있는지 확인 후 진행)
3. frontend/config/path.js appBuild: resolveApp('build/static') 으로 수정
4. frontend/build 삭제
5. build.gradle 에 구문 추가   
def webappDir = "$projectDir/src/main/frontend"   
sourceSets {   
main {   
resources {   
srcDirs = ["$webappDir/build", "$projectDir/src/main/resources"]   
}   
}   
}   
processResources {   
dependsOn "buildReact"   
}   
task buildReact(type: Exec) {   
dependsOn "installReact"   
workingDir "$webappDir"   
inputs.dir "$webappDir"   
group = BasePlugin.BUILD_GROUP   
if (System.getProperty('os.name').toLowerCase(Locale.ROOT).contains('windows')) {   
commandLine "npm.cmd", "run-script", "build"   
} else {   
commandLine "npm", "run-script", "build"   
}   
}   
task installReact(type: Exec) {   
workingDir "$webappDir"   
inputs.dir "$webappDir"   
group = BasePlugin.BUILD_GROUP   
if (System.getProperty('os.name').toLowerCase(Locale.ROOT).contains('windows')) {   
commandLine "npm.cmd", "audit", "fix"   
commandLine 'npm.cmd', 'install'   
} else {   
commandLine "npm", "audit", "fix"   
commandLine 'npm', 'install'   
}   
}

6. gradle이 있는 위치에서(거의 최상위) ./gradlew clean build 실행
7. cd build/libs 로 접근, java -jar 생성된jar파일(혹은 war 파일 이름) 명령어 실행
8. 3000번 대가 아닌 8000번 대 포트를 통해 react 가 실행됨

#### war
1. builde.gradle 에 구문 추가   
apply plugin: 'war'   
bootWar {   
    archiveFileName = 'smhrdPortal.war'   
}   
2. 수정된 파일을 빌드 (./gradlew clean build)