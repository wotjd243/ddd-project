# ddd-project

## 프로젝트 주제
헌터들이 힌트를 통해 보물을 찾는 이야기

## 요구사항

에그리거트: 헌터, 보물(미션)
* 헌터
- [ ] ‘헌터’는 아이디, 비밀번호, 이름, 사진, 포인트, 총알을 가진다.
- [ ] ‘헌터’는 네이버api를 이용해 로그인, 회원가입을 진행한다.
- [ ] ‘헌터’의 총알 기본,최대 개수는 3개이다.
- [ ] ‘헌터’의 총알 리필 시간은 30분이다. (최대개수보다 작을때 리필이 적용된다.)
- [ ] ‘헌터’의 총알은 미션을 도전하면 사라진다.
- [ ] ‘헌터’는 가지고 있는 포인트가 100점이 모이면 총알을 하나 더 구매할 수 있다. 
- [ ] ‘헌터’는 미션을 풀면 '획득량에 따른 포인트' 및 힌트를 획득한다.
- [ ] ‘헌터’는 자신의 지도(힌트를 통해 좌표가 줄어든 지도.)를 볼 수 있다.
- [ ]  '헌터 아이디'는 영어 소문자로 시작하며 20자를 넘지 않고 영소문자,대문자,숫자로만 이루어져야한다.
- [ ]  '헌터 비밀번호' 는 20자를 넘지 않아야한다. 비크립트로 암호화 필요.
- [ ]  '헌터 이름'은 15자를 넘으면 안된다.
- [ ]   헌터 사진의 확장자는 그림 확장자만 가능 하게 해야 하고 유니크값으로 변환시켜야한다.


* 보물
- [ ] ‘보물'은 러닝타임, 좌표, QR 코드 경로, 보물의 이름, 보물의 상태 (대기,진행,완료), 미션의 개수를 가진다
- [ ] ‘러닝 타임’ 보물을 찾을 수 있는 유효 기간을 뜻한다.
- [ ] ‘러닝 타임'은 시작일자, 종료일자로 이루어져 있다.
- [ ]  보물이 생성될때 러닝타임의 시작일과 종료일은 생성 시간보다 같거나 늦으며, 시작일은 종료일보다 빠르다.
- [ ] ‘좌표’는 보물이 있는 위치를 나타낸다 (위도,경도)
- [ ] ‘QR코드'는 보물이 있는 위치에 있고 QR코드를 찍을 수 있다.
- [ ] ‘QR코드'를 찍으면 보물상자의 비밀번호를 알 수 있고 , 해당 보물의 상태가 완료로 변경된다.
- [ ] ‘QR 코드’는 암호화 된 경로, 해당 보물의 비밀번호를 가지고 있다.
- [ ]  '비밀번호'는  암호화 필요.
- [ ] ‘QR 코드 경로’는 생성한 QR코드 URL을 나타낸다.
- [ ] ‘보물의 상태 ’는 대기,진행,완료로 이루어져있다.
- [ ] ‘보물의 상태 ’대기는 시작일자가 아직 되지 않은 상태이다.
- [ ] ‘보물의 상태 ’진행은 현재 진행중인 보물이다.
- [ ] ‘보물의 상태 ’완료는 QR코드를 찍거나 종료일자가 되었을 때 이다.
- [ ]   미션의 개수 = 러닝타임 기간(일수)  - 러닝타임 기간(일수)/7 * 2; 
- [ ] '보물의 가짜 지점'은  난이도에 따른 힌트 * 힌트효과 EX) 브론즈 미션개수 (4개) * 브론즈힌트효과(2) = 8  + ....
- [ ]  '보물의 모든 지점'은 경도(Hardness)범위는 124 – 132, 위도(Latitude)범위는 33 – 43 안에 범주한다.

* 미션
// https://opentdb.com/api_config.php API 주소
- [ ] ‘미션’은 난이도가 4개가있다. (브론즈, 실버, 골드, 플래티넘), (1,2,3,4)
- [ ] ‘미션 난이도' 의  분포량은 (브론즈, 실버, 골드, 플래티넘)
총 미션개수 : count 
미션 난이도 : level
int count = 12;
        for(int i = 4; i > 0; i--) {
            for(int i2 =0; i2 <= i; i2++){

                switch (i2) {
                    case 0:
                        System.out.println("브론즈 미션 생성");
                        break;
                    case 1:
                        System.out.println("실버 미션 생성");
                        break;
                    case 2:
                        System.out.println("골드 미션 생성");
                        break;
                    case 3:
                        System.out.println("플래티넘 미션 생성");
                        break;
                }
                count--;

                if(count < 0){
                    break;
                }
            }
            if(count < 0){
                break;
            }
        }
- [ ]‘미션'을 푸는 순서는 (브론즈 -> 실버 -> 골드 -> 플래티넘) 이다. 
- [ ]‘미션’의 힌트카운터 : (브론즈: 2개 실버 : 4개, 골드: 6개 , 플래티넘 : 10개)의 가짜 좌표를 지운다.
- [ ]  '획득량' = 난이도 * (randomInt(9) + 1)
- [ ]  ‘미션’을 러닝타임 시간안에 푸는데 성공하면 거기에 맞는 힌트를 제공한다.
- [ ]  ‘미션’을 푸는데 성공하면 다음 미션에 도전할 수 있다.




### 용어사전(유비쿼터스 언어)

| --- | --- | --- |
| 헌터 | hunter | 보물을 찾으러 떠나는 사냥꾼 |
| 헌터 아이디 | hunterId | 헌터의 아이디 |
| 헌터 비밀번호 | hunterPw | 헌터의 비밀번호 |
| 헌터 이름 | hunterName | 헌터의 이름 |
| 헌터 사진 경로 | hunterPicturePath | 헌터 사진의 경로 |
| 헌터 사진 명 | hunterPictureName | 헌터 사진의 파일명 |
| 총알 | hunterBullet | 헌터가 하루에 미션에 도전할 수 있는 기회 |

|  총알 리필 시간 |  bulletRefillTime  | 총알이 생성되기 까지 걸리는 시간  |
|  획득량 |  pointAmount  |  미션을 풀었을때 주어지는 포인트량   |
| 헌터 점수 | hunterPoint | 미션을 통해 획득 할 수 있는 점수 |
| 자신의 지도 |  myMap  |  좌표가 기록된 지도  |


| 보물 | treasure | 헌터 미션를 풀면 얻게 되는 보상 |
| 러닝타임 | runningTIme | 보물을 찾을 수 있는 유효기간. |
| 러닝타임의 시작일자  | startDate | 유효기간의 시작일자 |
| 러닝타임의 종료일자  | endDate | 유효기간의 종료일자 |
| 미션의 개수 | missionCount | 보물이 가지고 있는 미션의 개수를 뜻한다. |
| 보물의 가짜 지점 | fakePoint | 보물의 가짜 위치 |
| 좌표 | targetPoint | 보물의 위치를 뜻 한다. | 
| QR 코드 경로 | qrUrl | Qr코드를 통해서 접속하는 주소 |
| 좌표의 진짜 유무 | distinguish | 좌표가 진짜 보물의 위치인지 아닌지 판별해주는 역활을 한다. |


| 미션 | mission | 헌터가 힌트를 보기 위해 풀어야하는 과제 |
| 미션 난이도 | missionLevel | 해당 미션의 난이도 (종류는 쉬운순서대로 브론즈, 실버, 골드, 플래티넘) 이있다. |
| 미션 포인트 | missionPoint | 미션을 성공하면 미션포인트를 얻는다. |
| 미션 포인트범위 | missionPointRange | 미션포인트의 범위 (미션 난이도의 따라 다름) |
| 힌트 | hint | 보물 위치를 알려주는 아이템 |
| 힌트카운터 | hintCounter | 몇 개의 힌트를 줄지 알려준다 |

| ~의 아이디 | ~Id | 해당 도메인의 식별키 이름을 뜻한다. |
| ~의 이름 | ~Name | 해당 도메인의 이름을 뜻한다. |
| ~의 비밀번호 | ~Pw | 해당 도메인의 비밀번호를 뜻한다. |
| ~의 상태 | ~Status | 해당 도메인의 상태를 뜻한다. |


|  |  |  |


### **모델링**
- [ ] ‘헌터’는 고유한 아이디를 가지고 있다.
- [ ] ‘헌터’는 아이디, 비밀번호, 이름, 사진, 포인트, 총알을 가진다.
- [ ] ‘보물'은 고유한 아이디를 가지고 있다.
- [ ] ‘보물'은 러닝타임, 좌표, QR 코드 경로, 보물의 이름, 보물의 상태 (대기,진행,완료), 미션의 개수를 가진다.
- [ ] ‘미션’은 고유한 아이디를 가지고 있다.
- [ ] ‘미션’은 보물에 속하며 난이도를 가지고 있다.
 
 
 ## 도메인 계층 구현하기
 
