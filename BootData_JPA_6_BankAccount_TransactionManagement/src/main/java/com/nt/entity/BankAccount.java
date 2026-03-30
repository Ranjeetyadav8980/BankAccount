package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
	@Id
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="gen1",initialValue = 1000000000,allocationSize = 1)
	private Long accno;
	
	@NonNull
	@Column(length=30)
    private String holderName;
    
	@NonNull
	@Column(length=30)
	private String addrs;
	
	@NonNull
	private double balace;
	
	@Version
	private Integer updationCount;
	
	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime createionTime;
	
	@UpdateTimestamp
	@Column(insertable = false, updatable = true)
	private LocalDateTime lastAccessTime;

	@Column(length=30)
	private String createBy;
	
	@Column(length=30)
	private String updateBy;
	
	private String active_SW="active";

	
	
}
