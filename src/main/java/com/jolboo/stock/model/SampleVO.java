package com.jolboo.stock.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sample")
@Getter
public class SampleVO {
    @Id
    private Integer sampleId;

    private String name;
}
