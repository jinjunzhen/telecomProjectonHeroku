package com.example.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {
	
//	public List<Plan> findByPlanID(int id);
//	
//	public List<Plan> findByPhoneNum(int num);

}
