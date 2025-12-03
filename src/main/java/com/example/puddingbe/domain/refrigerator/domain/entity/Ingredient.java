package com.example.puddingbe.domain.refrigerator.domain.entity;

import com.example.puddingbe.domain.refrigerator.exception.LessIngredientException;
import com.example.puddingbe.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tbl_ingredient")
@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long milk = 0L;

    @Column(nullable = false)
    private Long sugar = 0L;

    @Column(nullable = false)
    private Long egg = 0L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    public void useForPudding(){
        if(this.egg < 2 || this.sugar < 2 || this.milk < 1){
            throw new LessIngredientException();
        }
        this.egg -= 2;
        this.sugar -= 2;
        this.milk -= 1;
    }

    public void addMilk(){
        this.milk += 1;
    }
    public void addSugar(){
        this.sugar += 1;
    }
    public void addEgg(){
        this.egg += 1;
    }

}
