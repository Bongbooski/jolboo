package com.jolboo.stock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "oauth")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OauthVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oauthId;
    private String issuedDate;
    private String accessToken;
    private OffsetDateTime expiredDatetime;
}
