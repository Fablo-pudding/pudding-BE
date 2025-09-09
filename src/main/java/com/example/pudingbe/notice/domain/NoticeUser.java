package com.example.pudingbe.notice.domain;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedDate;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity

public class NoticeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (columnDefinition = "VARCHAR(200)")
    private String title;

    @Column (columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    @NotNull
    private LocalDateTime updateDatetime;

    @CreatedDate
    @NotNull
    private LocalDateTime registerDatetime;

    @Column(length = 6)
    @NotNull
    private String registerEmployeeNo;

    @Column(length = 20)
    @NotNull
    private String updateEmployeeNo;
}
