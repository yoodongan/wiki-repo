# wiki-repo
> 공부한 내용을 기록하는 저장소입니다. 기록은 모두 Notion 에서 진행했습니다. 
> <br>링크 클릭 시 해당 Notion 페이지로 이동합니다.

## [ SQL ]
- - -
### SQL 레벨업
- [DBMS 아키텍처 개요, DBMS와 버퍼]()

### 
- [프로그래머스 SQL](https://hushed-bite-bb4.notion.site/SQL-Kit-2a759d87910b46d39fed44b892132083)

## [ Spring ]
- - -
### 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술
  - [프로젝트 환경설정](https://hushed-bite-bb4.notion.site/d56a0de87819409f821a33860613036d)
    - 프로젝트 환경 설정, 라이브러리와 스프링의 기본 동작 원리에 대해 알아본다.
  - [스프링 웹 개발 기초](https://hushed-bite-bb4.notion.site/2690306e2d62428f84df4abd906fe254)
    - MVC 구조를 통한 템플릿 엔진 랜더링, API 를 통해 데이터를 내려주는 방법에 대해 알아본다.
  - [회원 관리 예제 - 백엔드 개발](https://hushed-bite-bb4.notion.site/e03307fac62944f599cc3dd302c488d1)
    - 회원 관리 예제 비즈니스 요구 사항을 정리하고, 실제 개발을 진행해본다.
    - 컨트롤러, 서비스, 리포지터리 계층 별로 구성한다. (리포지터리는 인터페이스로 구현, 추후 변경 가능하도록 하기 위해서)
    - 테스트 코드를 통해 예외 로직 작성하는 법에 대해 실습해본다.
  - [스프링 빈과 의존관계](https://hushed-bite-bb4.notion.site/82cab91a2c36464483fb470878c15b8b)
    - 컴포넌트 스캔과 자동 의존관계 설정에 대해 알아본다.
    - 스프링 컨테이너의 싱글톤 빈 등록에 대해 알아본다.
    - 자바 코드로 직접 스프링 빈 등록하는 방법에 대해 알아본다.
    - 다양한 DI 방법에 대해 알아본다.(생성자 주입, 필드 주입, setter 주입)
  - [회원 관리 예제 - 웹 MVC 개발](https://hushed-bite-bb4.notion.site/MVC-0365389bc7654ed38cb007b3ab156385)
    - 회원 등록, 회원 조회 기능을 개발해본다.
  - [스프링 DB 접근 기술](https://hushed-bite-bb4.notion.site/DB-8581f58688f94c9ca5e1d8d64eb7b29d)
    - H2 db 를 통한 실습
    - 스프링 통합 테스(@SpringBootTest)
    - 스프링 JDBC Template 간략 소개, JPA 간략 소개
  - AOP(진행예정)

### 스프링 핵심 원리 - 기본편
- [객체 지향 설계와 스프링](https://hushed-bite-bb4.notion.site/a5150e5f039e46f7a0fca402e9349e3a)
  - 스프링 등장 배경 소개
  - 스프링의 IoC,DI는 객체 지향 프로그래밍의 '다형성'을 극대화하기 위해 필요하다.
  - 좋은 객체 지향 설계 원칙(SOLID)
- [스프링 핵심 원리 이해1 - 예제 만들기](https://hushed-bite-bb4.notion.site/1-ed958c4776e94c90843288eea9f2745c)
  - 회원, 주문, 할인 예제
  - 구현객체 변경이 용이하도록 인터페이스로 개발.(리포지터리, 할인 정책)
  - 클라이언트 코드가 인터페이스에 의존하도록 설계해야 하는 이유
- [스프링 핵심 원리 이해2 - 객체 지향 원리 적용](https://hushed-bite-bb4.notion.site/2-217f9761d35941b48482c26f075e901f)
  - OCP, DI 에 위배되는 기존 할인정책을 관심사 분리(AppConfig)를 통해 해결
    => 제어의 역전(IoC), 의존관계 주입(DI)에 대해 실습 코드로 학습한다.
  - ApplicationContext(스프링 컨테이너)를 통해 기존 코드 스프링으로 전환하기
- [스프링 컨테이너와 스프링 빈](https://hushed-bite-bb4.notion.site/61baf8b9bcf64e0d9a67602573b563a8)
  - 컨테이너에 등록된 모든 빈 조회해보기
  - 타입 조회 시 중복 빈이 조회되면, 이름을 통해서 구체적으로 조회하면 된다.
  - 상속관계에서는 자식 빈 타입까지 모두 끌고 나온다.(모두 조회한다.)
  - BeanFactory, ApplicationContext 에 대해 알아본다.
- [싱글톤 컨테이너](https://hushed-bite-bb4.notion.site/4851cf0fc1db488fbbdca43826e73f55)
  - 싱글톤 패턴을 적용해서 객체 생성하기 실습
  - 스프링 컨테이너에서 제공하는 싱글톤 기술을 체험해본다.
    - 스프링 빈은 반드시 무상태(Stateless)로 설계해야 한다!!(싱글톤은 객체 인스턴스를 하나만 생성해서 공유하기 때문에, 공유 필드를 사용할 때 매우 매우 조심해야 한다.)
  - @Configuration 을 통해 싱글톤을 보장하는 스프링 컨테이너에 대해 알아본다. 
- [컴포넌트 스캔](https://hushed-bite-bb4.notion.site/b1f7f7be894642c88c6daf3ba73896ed)
  - 컴포넌트 스캔과 의존관계 자동 주입에 대해 알아본다.
  - 필터를 통해 원하는 빈만 등록하는 방법에 대해 알아본다.
  - 빈 중복 등록 시 충돌 상황에 대해 알아본다.
- [의존관계 자동 주입](https://hushed-bite-bb4.notion.site/4df18613bece432f8d043a39dae4dbac)
  - 스프링 라이프 사이클(빈 등록 -> 의존 관계 주입)에 대해 알아본다.
  - 생성자 주입(빈 등록과 의존 관계 주입이 동시에 일어남)을 선택하라!
  - @Qualifier(추가 구분자), @Primary(우선 순위) 를 통해 빈 이름 중복 시 발생할 수 있는 문제를 해결해본다.
- [빈 생명주기 콜백](https://hushed-bite-bb4.notion.site/e84e7d11fda741f7a6b782835db5bc59)
- [빈 스코프](https://hushed-bite-bb4.notion.site/9874fce53e444146b4ffb5c50bd198fb)
  - 프로토타입 빈의 특징(요청할 때마다 새로 생성)에 대해 알아본다.
  - 싱글톤 안에서 프로토타입 빈을 사용할 때, 프로토타입 빈 기능을 수행하지 못하는 문제를 해결해본다.
    - ObjectProvider, Provider(순수 자바 기술)
    
### [자바 ORM 표준 JPA 프로그래밍 - 기본편](https://hushed-bite-bb4.notion.site/ORM-JPA-2b90738c42534637a8b66ae14732ea61)
### [스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술](https://hushed-bite-bb4.notion.site/MVC-1-2cb04880036946169dee14b4316d1681)
### [실전! 스프링 부트와 JPA 활용1](https://hushed-bite-bb4.notion.site/JPA-1-655884e3ef50478d8363163fe90a1ff1)
### [실전! 스프링 부트와 JPA 활용2](https://hushed-bite-bb4.notion.site/JPA-2-63dc4a4df6e642cc9dbeae69490c32f3)
### 실전! 스프링 데이터 JPA(진행 중)

## [ HTTP ]
- [모든 개발자를 위한 HTTP 웹 기본 지식](https://hushed-bite-bb4.notion.site/HTTP-2d99ce4e02524588a767f25d9d096d6a)

## [ 협업 ]
- [Do it! 지옥에서 온 문서 관리자 깃&깃허브 입문 (책)](https://hushed-bite-bb4.notion.site/Git-Github-6376140d1bbf4137a704b6c03531a69c) 

## [ Java ]
- [자바의 정석 - ch.14 람다와 스트림](https://hushed-bite-bb4.notion.site/Chapter14-fb8ee762f55e4465bfa8531112d4d27b)

## [ 알고리즘 ]
- [인프런 알고리즘 정리](https://hushed-bite-bb4.notion.site/InfLearn-53b9c430b789468f9b4ba05d5b2174bc)
- [프로그래머스, 백준 알고리즘 정리](https://hushed-bite-bb4.notion.site/4e502d1f80be4e4db253e888b33e4aaf?v=69cc9e7d7aae48c6a000fbb1cdd28d31)


---
### 참조(출처)
- [김영한의 스프링 부트와 JPA 실무 완전 정복 로드맵](https://www.inflearn.com/roadmaps/149)
- [자바(Java) 알고리즘 문제풀이 입문: 코딩테스트 대비](https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84)
- [Do it! 지옥에서 온 문서관리자 깃&깃허브 입문](https://product.kyobobook.co.kr/detail/S000001817950)
- [자바의 정석](https://product.kyobobook.co.kr/detail/S000001550352)
