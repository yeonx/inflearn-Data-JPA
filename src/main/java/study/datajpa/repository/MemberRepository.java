package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // username 과 age가 and조건으로 묶이고 GreaterThan 파라미터 조건보다 크면 -> 알아서 알아 듣는다. -> 문법 틀리면 안된다.
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    List<Member> findTop3HelloBy();

//    @Query(name = "Member.findByUsername") //이거 없어도 잘 작동함. <> 속의 Member 쩜 find
    List<Member> findByUsername(@Param("username") String username);

    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);
// 동적 쿼리는 쿼리 dsl : 유지 보수가 좋음
}
