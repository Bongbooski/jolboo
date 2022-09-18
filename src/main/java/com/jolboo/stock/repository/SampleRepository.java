package com.jolboo.stock.repository;


import com.jolboo.stock.model.SampleVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<SampleVO, Integer> {
}
