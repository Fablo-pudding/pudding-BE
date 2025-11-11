package com.example.puddingbe.domain.refrigerator.domain.entity;

import com.example.puddingbe.domain.refrigerator.exception.LessPuddingOne;
import com.example.puddingbe.domain.refrigerator.exception.LessPuddingTwo;
import com.example.puddingbe.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tbl_pudding")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Pudding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long pudding_1 = 0L;

    @Column(nullable = false)
    private Long pudding_2 = 0L;

    @Column(nullable = false)
    private Long pudding_3 = 0L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public void craft(){
        this.pudding_1++;
    }
    public void upgradeFor_2(){
        this.pudding_2++;
    }
    public void upgradeFor_3(){
        this.pudding_3++;
    }
    public void UsePuddingFor_2(){
        if(this.pudding_1 < 3){
            throw new LessPuddingOne();
        }
        this.pudding_1-=3;
    }
    public void UsePuddingFor_3(){
        if(this.pudding_2 < 3){
            throw new LessPuddingTwo();
        }
        this.pudding_2-=3;
    }
}
