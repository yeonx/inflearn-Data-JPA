package study.datajpa.dto;

import lombok.Data;
import study.datajpa.entity.Member;

@Data // getter, setter 다 들어가 있어서 사용하면 안됨. toString 기능도 포함
public class MemberDto {

    private Long id;
    private String username;
    private String teamName;

    public MemberDto(Long id, String username, String teamName) {
        this.id = id;
        this.username = username;
        this.teamName = teamName;
    }

    public MemberDto(Member member){
        this.id = member.getId();
        this.username = member.getUsername();
    }
}
