package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>{
	
	Optional<MemberEntity> findByEmail(String email);
	
}
