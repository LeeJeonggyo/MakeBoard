package com.ella.MakeBoard.repository;

import com.ella.MakeBoard.domain.MemberInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberInfoRepository extends JpaRepository<MemberInfoEntity, Long> {
    Optional<MemberInfoEntity> findById(String id);
}
