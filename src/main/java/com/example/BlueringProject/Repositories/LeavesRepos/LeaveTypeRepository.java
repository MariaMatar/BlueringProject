package com.example.BlueringProject.Repositories.LeavesRepos;

import com.example.BlueringProject.Entities.LeavesEntities.LeaveTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveTypeRepository extends JpaRepository<LeaveTypeEntity, Integer> {
}