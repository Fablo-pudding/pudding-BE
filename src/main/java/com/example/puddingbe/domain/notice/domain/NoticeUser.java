package com.example.puddingbe.domain.notice.domain;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;

@Table(name = "tbl_notice")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Setter

public class NoticeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (columnDefinition = "VARCHAR(200)")
    private String title;

    @Column (columnDefinition = "TEXT")
    private String content;

    @UpdateTimestamp
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
