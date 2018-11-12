# Spring Boot Test
![spring Boot Version](https://img.shields.io/badge/SpringBoot-1.5.10%20RELEASE-green.svg)
![jdk version](https://img.shields.io/badge/jdk-8-red.svg)
- Dependencies
    - lombok
    - JPA
    - H2
---
## JPA
- **JPA Annotation**
    - **@Entity**
        - 테이블과 링크될 클래스임을 나타냄
    - **@Id**
        - 해당 테이블의 PK필드를 나타낸다. 
    - **@GeneratedValue**
        - PK 생성규칙을 나타냄
        - 기본값은 AUTO, 자동증가하는 정수형 값이 된다.
    - **@Column**
        - 테이블의 컬럼을 나타내면, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 된다.
        - 기본값 외에 추가로 변경이 필요한 옵션이 있을경우 사용.
        - 문자열의 경우 기본 사이즈를 늘리고 싶거나 타입을 변경할 때 사용.
    - **@GetMapping("/")**
        - @RequestMapping(value="/", method="RequestMethod.GET")과 동일함.
- **JPA Auditing**
    - **@MappedSuperclass**
        - JPA Entity 클래스들이 BaseTimeEntity을 상속할 경울 필드들도 컬럼으로 인식하도록함.
    - **@EntityListeneres(AuditingEntityListener.class)**
        - BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
    - **@CreateDate**
        - Entity가 생성되어 저장될 때 시간이 자동 저장된다.
    - **@LastModifiedDate**
        - 조회한 Entity의 값을 변경할 때 시간이 자동저장.

---

## Lombok Annotation 
- [Lombok 주의할 점](http://kwonnam.pe.kr/wiki/java/lombok/pitfall)
- **@NoArgsConstructor**
    - 기본생성자 자동추가
    - **access = AccessLevel.PROTECTED** 접근권한을 **protected** 로 제한
- **@Getter**
    - 클래스내 모든 필드의 Getter 메소드 생성
- **@Builder**
    - 해당 클래스의 빌더배턴 클래스를 생성
    - 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함.
