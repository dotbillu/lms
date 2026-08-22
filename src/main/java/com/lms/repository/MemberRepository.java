package com.lms.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.lms.model.Member;

public class MemberRepository {
  Map<UUID, Member> member = new HashMap<>();

  public void add(Member member) {
    this.member.put(member.getId(), member);
  }

  public Member findById(UUID id) {
    return this.member.get(id);
  }

  public List<Member> findAll() {
    ArrayList<Member> allMembers = new ArrayList<>();
    for (Member member : this.member.values()) {
      allMembers.add(member);
    }
    return allMembers;
  }

  public void delete(UUID id) {
    this.member.remove(id);
  }
}
