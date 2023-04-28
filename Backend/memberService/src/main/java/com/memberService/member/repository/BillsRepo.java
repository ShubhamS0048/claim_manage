package com.memberService.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.memberService.member.model.Bills;

@Repository
public interface BillsRepo extends JpaRepository<Bills, String> {

}