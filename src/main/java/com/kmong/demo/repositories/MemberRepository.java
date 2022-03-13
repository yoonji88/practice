package com.kmong.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.kmong.demo.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface MemberRepository extends JpaRepository<Member, String> { 
    public Optional<Member> findById(String id);
    public List<Member> findByName(String name);
    public List<Member> findByNameLike(String keyword);
}