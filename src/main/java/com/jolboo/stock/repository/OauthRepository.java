package com.jolboo.stock.repository;

import com.jolboo.stock.model.OauthVO;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthRepository extends JpaRepository<OauthVO, Integer> {
    Optional<OauthVO> findByIssuedDate(String today);
}
