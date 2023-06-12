package com.nhnacademy.mini_dooray.task_api.domain.member.repository;

import com.nhnacademy.mini_dooray.task_api.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Member.Pk> {
}
