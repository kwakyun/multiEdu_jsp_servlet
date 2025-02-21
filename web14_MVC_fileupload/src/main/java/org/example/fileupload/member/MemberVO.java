package org.example.fileupload.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MemberVO {
    private int num;
    private String id;
    private String pw;
    private String name;
    private String tel;
    private String imgName;
    
    
}
