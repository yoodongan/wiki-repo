## [ 조건 분기 ]

### SQL과 조건 분기

- SQL은 절차적으로 기술하는 것이 아니므로, 조건 분기를 '문장' 단위로 하지 않는다.   
  SQL은 '식(CASE 식)' 단위로 조건 분기를 한다.
  - 이로 인해 SELECT, WHERE, GROUP BY, HAVING, ORDER BY 구와 같은 곳 어디에나 적을 수 있다. (CASE 식)
- SQL의 조건 분기의 가장 큰 특징은, `특정한 값(상수)`를 리턴한다는 것.     
  (일반적인 절차 지향형 언어의 조건 분기는 문장을 실행하고, 리턴하지는 않는다.)

Q. 시도의 이름을 큰 지역으로 구분하는 CASE 식을 작성해주세요.
```sql
SELECT name, address,
   CASE WHEN address = '서울시' THEN '경기'
        WHEN address = '인천시' THEN '경기'
        WHEN address = '부산시' THEN '영남'
        WHEN address = '속초시' THEN '관동'
        WHEN address = '서귀포시' THEN '호남'
        ELSE NULL END AS district
FROM Address;
```
- CASE 식은 '교환'이라 말할 수 있다. '서울시' -> '경기' 로 바뀌기 때문이다.
- ELSE NULL 의 의미는, CASE 구문에서 지정된 조건에 해당되지 않는 경우 district 컬럼 값에 NULL 을 넣어준다는 뜻이다.   
  END는 CASE 식의 끝을 나타내는 키워드이다.     
  district 는 컬럼명을 의미한다.

다음은 또 다른 CASE 식의 예제로, 마치 switch-case 문과 비슷하게 동작하는 것을 알 수 있다.
```sql
SELECT name, score,
    CASE WHEN score >= 90 THEN 'A'
        WHEN score >= 80 THEN 'B'
        WHEN score >= 70 THEN 'C'
        ELSE 'F' END AS grade
FROM Students;
```

## [ SQL의 집합 연산 ]

### UNION
두 개의 테이블을 합치기 위해서는, UNION 집합 연산이 필요하다.    
UNION의 특징은, `중복을 제거`한다는 것이다. (단, UNION ALL 을 사용하면 중복 제거하지 않음)
### INTERSECT
AND에 해당하며, 두 개의 테이블에 대한 '교집합'을 의미한다. 마찬가지로 중복은 제거.
### EXCEPT
두 개의 테이블에 대한 '차집합'을 의미한다. 차집합의 특징은 순서에 따라 결과가 달라진다는 것.(어디에서 어디를 제외하느냐에 따라 결과가 다름)
### 윈도우 함수
테이블을 자르는 것은 GROUP BY와 비슷할 수 있지만, '집약'을 하지 않는다. 즉, 중복된 레코드가 그대로 출력된다는 것을 의미한다.

예제는 다음과 같다.
```sql
SELECT address, COUNT(*) OVER(PARTITION BY address) 
FROM ADDRESS;
```
- 집약 함수인 `COUNT()` 뒤에 `OVER구` 를 작성하고, 내부에 자를 키를 지정하는 `PARTITION BY` 또는 `ORDER BY` 를 입력한다. 

Q. 윈도우 함수 전용 함수로 제공되는 RANK, ROW_NUMBER 도 있습니다.      
나이가 많은 순서대로 순위를 붙여 조회하는 쿼리를 작성해보세요.
```sql
SELECT name, age, RANK() OVER(ORDER BY age DESC) AS rank
FROM ADDRESS;
```

## [ 트랜잭션과 갱신 ]
> SQL의 갱신 작업은 기본적으로 세 종류로 분류된다.(삽입, 제거, 갱신)

`INSERT`로 데이터 삽입
```sql
INSERT INTO Address (name, phone_nbr, address, sex, age)
VALUES('인성', '080-3333-XXXX', '서울시', '남', 30),
('하진', '090-0000-XXXX', '서울시', '여', 21),
('준', '090-2984-XXXX', '서울시', '남', 45);
```
- NULL, 숫자는 따옴표로 감싸지 않는다. 

`DELETE`로 데이터 삭제
```sql
DELETE FROM Address
WHERE address = '인천시';
```
- 삭제 시 주의할 점은, 필드명을 넣으면 오류가 발생한다는 것이다.   
SELECT 에서 필드명을 계속 사용해서 조금 헷갈린다.

`UPDATE`로 데이터 갱신
```sql
UPDATE Address
SET phone_nbr = '080-5849-XXXX'
WHERE name = '김길동';
```
다음과 같이 SET 구에 여러 개의 필드를 입력하면, 한 번에 여러 개의 값을 변경할 수 있다.
```sql
UPDATE Address
SET phone_nbr = '010-4164-XXXX',
age = 20
WHERE name = '김길동';
```