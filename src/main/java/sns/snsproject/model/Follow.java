package sns.snsproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 중간 테이블 생성됨.
    // fromUser가 toUser를 following 함.
    // toUser를 fromUser가 follower 함.

    @ManyToOne
    @JoinColumn(name="fromUserId")
    @JsonIgnoreProperties({"images"})
    private User fromUser;

    @ManyToOne
    @JoinColumn(name="toUserId")
    @JsonIgnoreProperties({"images"})
    private User toUser;

    @Transient
    private boolean followState;

    @CreationTimestamp
    private Timestamp createDate;
    @CreationTimestamp
    private Timestamp updateDate;
}