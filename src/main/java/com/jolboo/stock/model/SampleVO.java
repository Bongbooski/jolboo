package com.jolboo.stock.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "sample")
@Getter
public class SampleVO {
  @Id private Integer sampleId;

  private String name;
}
