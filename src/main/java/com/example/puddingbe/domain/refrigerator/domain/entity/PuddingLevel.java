package com.example.puddingbe.domain.refrigerator.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PuddingLevel{
    PUDDING_1("푸딩 1성"),
    PUDDING_2("푸딩 2성"),
    PUDDING_3("푸딩 3성");

    private final String name;
}
