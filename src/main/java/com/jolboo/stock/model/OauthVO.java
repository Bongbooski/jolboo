package com.jolboo.stock.model;

import java.time.OffsetDateTime;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
