## [ SELECT, GROUP BY, HAVING, View, 서브쿼리 ]
### SELECT 
- RDB의 기본 정신은 ‘최대한 쉽게 만드는 것’.    
  즉, SELECT 구문에서 데이터를 ‘어떤 방법(HOW)’으로 선택할지는 DBMS에게 맡기면 된다.
  - 실제로 SELECT 구문에는 '어떤 방법으로' 데이터를 선택할지 쓰여 있지 않다.(절차 지향인 HOW는 DBMS에서 알아서 처리해줌)
- SELECT 구문은 ‘읽기 전용 함수’이다. (테이블에 변경이 일어나지 않음)     
  SELECT 구문은 ‘테이블(관계)’이라는 자료형을 리턴한다. 즉, 어떠한 경우에도 모두 2차원 표로 리턴하는 것이다.
### WHERE (관계부사인 '~라는 경우'를 의미한다.)
- WHERE구는 엑셀의 ‘필터 조건’과 동일하다. 연산자를 통해 조건을 만들 수 있다.
- WHERE구는 거대한 벤다이어그램이다. 
  - AND, OR을 통해 조건 연결 가능 (AND는 교집합, OR는 합집합)
- IN으로 OR 조건을 간단하게 작성할 수 있다.
  - 가령, 주소가 '서울시 또는 인천시 또는 부산시'인 사람을 선택하려면,
      - `WHERE address IN(’서울시’, ‘부산시’, ‘인천시’);`
- NULL 일 경우를 찾고 싶다면, `IS NULL` 을 사용한다. (반대는 `IS NOT NULL`)
### GROUP BY    

GROUP BY는 ‘테이블을 홀 케이크처럼 다룬다’는 뜻이다.   
GROUP BY(=케이크를 자르는 칼) 를 통해 케이크를 자르는 기준은 '필드'이다. 
- 참고로 `GROUP BY()` 는 키를 지정하지 않는다는 뜻으로, 테이블 전체를 하나의 조각으로 생각. (일부 DBMS에서 지원하지 않는다.)

Q. 주소별로 사람수를 계산하는 쿼리를 작성해주세요.
```sql
SELECT address, count(*)
FROM MEMBER
GROUP BY address;
```

### HAVING
WHERE 구가 '레코드'에 조건을 지정한다면, HAVING 구는 '집합'에 조건을 지정하는 기능을 말한다.    
(집합이란, GROUP BY 를 통해 나온 결과를 말한다.) 

Q. 살고 있는 사람수가 한 명 뿐인 주소 필드를 선택해주세요.(테이블명 : ADDRESS)
```sql
SELECT address, count(*)
FROM Address
GROUP BY address
HAVING COUNT(*) = 1;
```
### ORDER BY
레코드들은 딱히 정해진 규칙 없이 출력된다. 순서를 보장하기 위해서는 ORDER BY 가 필요하다.

Q. MEMBER 테이블에서 나이가 많은 순서로 레코드를 정렬해주세요. 나이가 같다면, 전화번호를 기준으로 오름차순 정렬해주세요.
```sql
SELECT * FROM Address
ORDER BY age DESC, phone_nbr ASC;
```

### 뷰(View), 서브쿼리
자주 사용하는 SELECT 구문을 텍스트 파일로 따로 저장할 방법이 없을까 ?    
데이터베이스 안에 SELECT 구문을 저장할 수 있도록 지원해주는 것이 바로 View 이다.
```sql
CREATE VIEW CountAddress (v_address, cnt)
AS
SELECT address, COUNT(*)
FROM Address
GROUP BY address;
```
만들어 준 View 는 다음과 같이 사용할 수 있다.
```sql
SELECT v_address, cnt
FROM CountAddress;
```
뷰의 특징은 다음과 같다.
- CREATE VIEW 를 통해 만든 뷰는 마치 일반적인 '테이블'처럼 SELECT 구문에서 사용할 수 있다. (`FROM CountAddress`)
- 뷰 대신 FROM 구에 직접 SELECT 구문을 지정할 수 있다.(이를 서브쿼리라고 한다.)   
  이후 SQL은 항상  서브쿼리부터 실행한다.    

서브쿼리는 '뷰'와 매우 비슷하다. '뷰'가 미리 SELECT 구문을 통해 테이블을 리턴받는다면, '서브쿼리'는 FROM 구에다가 직접 작성하는 것이다.
```sql
SELECT v_address, cnt
FROM(SELECT address AS v_address, COUNT(*) AS cnt
     FROM ADDRESS
     GROUP BY address) AS CountAddress;
```

Q. Address 테이블에 있는 사람 중, Address2 테이블에도 있는 사람 이름을 조회해주세요.
```sql
SELECT name FROM ADDRESS
WHERE name IN (SELECT name FROM ADDRESS2);
```
- 서로 다른 테이블에서 특정 필드를 기준으로 '매칭'하고 싶을 때 사용한다. IN쿼리와 서브쿼리를 사용한다는 것이 특징이다. 











 