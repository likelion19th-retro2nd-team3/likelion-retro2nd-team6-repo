# 멋사 19기 회고 2차 6조 리파지토리

스프링 부트를 **공부/실습**하기 위한 팀 레포지토리입니다.  
각자 매일 회고(`diary`)와 실습 코드(`labs`)를 추가하고, 간단한 스프링 부트/자바 실습도 함께 관리합니다.


---

## 🗓️ Diary 작성 규칙
- 파일명: `YYMMDD.md` (예: `251014.md`)
- 포맷(권장 템플릿):
```md
## YYYY-MM-DD (요일)

### 오늘 배운 내용 중 가장 기억에 남는 것

### 오늘 배운 내용 중 어려웠던 것

### 오늘 강의시간, 회고시간에 대한 느낀점
```

---

## 🧪 Labs 사용 규칙
- 파일/패키지는 자유롭게 만들되, **의미 있는 이름** 사용
  - 예) `StreamMapExample.java`, `HttpEchoServer.java`
- 실행 예시(IntelliJ): 해당 클래스 `main` 메서드 실행


---

## ✅ 커밋 규칙 (Conventional Commits 변형)
형식: `type(scope): message`

**type 목록**
- `feat`  : 새로운 기능
- `fix`   : 버그 수정
- `docs`  : 문서(README/diary 등) 변경
- `refactor` : 리팩터링(동작 변화 없음)
- `test`  : 테스트 코드 추가/수정
- `build` : 빌드 시스템/의존성 변경(gradle 등)
- `chore` : 그 외 잡일(포맷팅, 폴더 이동 등)
- `style` : 코드 스타일 변경(포매팅, 세미콜론 등)
- `ci`    : CI 설정 변경
- `revert`: 변경 되돌리기

**scope 예시**: `diary`, `labs`, `app`, `build`, `docs`

**예시 커밋 메시지**
```
docs(diary): 251013 회고 업로드 (이름)
feat(labs): Stream API map/filter 실습 추가
fix(app): DemoApplication 로깅 레벨 수정
build: spring-boot-starter-web 의존성 추가
chore: members 폴더 구조 정리
```


---

## 📄 .gitignore 권장 항목
루트 `.gitignore`에 아래 포함 권장:
```
.gradle/
build/
.idea/
*.iml
.DS_Store
```

---

## 🔁 기타
- 폴더/파일 이동 등 구조 변경 시 반드시 팀원에게 알립니다.
- 실습 중 생성되는 산출물(로그, 임시 파일)은 커밋하지 않습니다.