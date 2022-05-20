package com.pristavka.fibonacci.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "request_value")
    private Integer requestValue;

    @Column(name = "response_value")
    private Integer responseValue;
}

