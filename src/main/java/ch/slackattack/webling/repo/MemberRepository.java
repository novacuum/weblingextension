package ch.slackattack.webling.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE MEMBER", nativeQuery = true)
    void truncateTable();
}