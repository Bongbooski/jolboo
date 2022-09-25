package com.jolboo.stock.repository;


import com.jolboo.stock.model.OauthVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OauthRepository extends JpaRepository<OauthVO, Integer> {
    Optional<OauthVO> findByIssuedDate(String today);
}
