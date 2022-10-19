package study.datajpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString( of = {"id","username","age"}) // 객체를 찍을 때 이 출력으로, 연관관계는 이거 안하는게 좋음
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

//    protected Member() { -> @NoArgsConstructor(access = AccessLevel.PROTECTED)ㄹ로 생략 가능
//    }

    public Member(String username) {
        this.username = username;
    }

    public Member(String username,int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null){
            changeTeam(team);
        }
    }

    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }
}
