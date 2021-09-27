package hellojpa;

import org.hibernate.type.LocalDateType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize = 1
)
/* TABLE 전략
* GeneratedValue의 strategy를 GenerationType.TABLE 로 한다.
* */
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1
//)
public class Member {

    public Member() {

    }

//    public Member(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id /* PK로 mapping */
    /* 이름을 주지 않으면 hibernate_sequence 라는 하이버네이트 기본 시퀀스를 사용하게 된다
    * generator를 사용하면 원하는 옵션을 주어 시퀀스를 사용할 수 있게 된다 */
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    /* 필드와 매핑할 테이블의 컬럼 이름. 객체는 username, DB column 이름은 name */
    @Column(name = "name")
    private String username;

    /* Integer와 가장 적절한 숫자 타입이 DB에 만들어진다 */
    private Integer age;

    /* EnumType.ORDINAL : enum 순서를 DB에 저장한다. ORDINAL은 데이터 오류가 발생하기 쉬우므로 사용하지 않도록 한다.
     * EnumType.STRING : enum 이름을 DB에 저장한다 */
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    /* date type. 타입에는 DATE, TIME, TIMESTAMP가 있어서 매핑 정보를 전달해주어야 한다
    * 과거 버전의 하이버네이트를 사용할 경우 아래와 같이 사용한다 */
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    /* LocalDate는 date, LocalDateTime은 timestamp 속성을 가지게 된다
    * 최신 버전의 하이버네이트를 사용할 경우 주로 아래와 같이 사용한다 */
    private LocalDate testLocalDate;
    private LocalDateType testLocalDateTime;

    /* 큰 컨텐츠 타입을 사용할 때 Lob을 사용한다
    * 타입이 String이면 clob으로 매핑되고 나머지는 blob으로 매핑된다 */
    @Lob
    private String description;

    /* etc : db와 관계 없이 메모리에서만 사용하고 싶을 때, Transient annotation을 사용한다. */
}
