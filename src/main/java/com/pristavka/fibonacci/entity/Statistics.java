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
public class Statistics {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "request_value")
    private Integer requestValue;

    @Column(name = "request_count")
    private Integer requestCount;
}

