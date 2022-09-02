# PlayerInteraction

## Description
플레이어가 다른 플레이어에게 쉬프트 + 우클릭을 했을경우  
플레이어에게 명령어를 실행시키게끔 해주는 플러그인입니다.  

### Use Spigot Version :
1.18.2

### Test Spigot Version :
1.18.2

## Install Guide
1. 릴리즈된 최신 파일을 다운로드합니다.
2. 다운로드한 .jar 파일을 서버의 플러그인 폴더에 저장합니다.
3. 플러그인 폴더에 저장한 뒤에 서버를 오픈해주세요.

## Feature

### 쉬프트+우클릭 명령어 기능
config.yml 양식

```
#쉬프트+우클릭 명령어에서 쉬프트+우클릭을 사용한 플레이어의 닉네임을 불러오려면 %player%를 통해 불러올 수 있습니다.
# 사용 예시:
# shift_right_click_command: "msg %player% Hello, %player%!"
#쉬프트+우클릭 기능을 사용할 월드 이름 리스트를 enable_world에 입력해 주세요.

shift_right_click_command: ""
enable_world:
- "world"
```  

config 사용 예제
```
# 오버월드, 네더월드, 엔드월드에서 플레이어에게 쉬프트+우클릭하면 서버에서 강제퇴장 시키고 싶을때.

shift_right_click_command: "kick %player%"
enable_world:
  - "world"
  - "nether_world"
  - "end_world"
```