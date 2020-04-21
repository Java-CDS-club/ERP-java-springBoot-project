package com.example.demo.model.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Gerer implements Serializable{
	

	
	    @Id
	    @ManyToOne
	    @JoinColumn
	    private Employer employer;

	    @Id
	    @ManyToOne
	    @JoinColumn
	    private Operation operation;

	    private Date dateD;
	    private Date dateF;

	 

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Gerer)) return false;
	        Gerer that = (Gerer) o;
	        return Objects.equals(employer.getName(), that.employer.getName()) &&
	                Objects.equals(operation.getLib(), that.operation.getLib()) &&
	                Objects.equals(dateD, that.dateD) && Objects.equals(dateF, that.dateF);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(employer.getName(), operation.getLib(), dateD, dateF);
	    }
	}

