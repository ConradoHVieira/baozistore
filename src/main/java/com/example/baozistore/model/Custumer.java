package com.example.baozistore.model;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Custumer")
public class Custumer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", Nome=" + name + ", DataCriação=" + createdAt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Custumer other = (Custumer) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

}
