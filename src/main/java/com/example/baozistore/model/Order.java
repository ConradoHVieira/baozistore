package com.example.baozistore.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "custumer_id")
	private Custumer custumerId;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product productId;
	private Integer quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Custumer getCustumerId() {
		return custumerId;
	}

	public void setCustumerId(Custumer custumerId) {
		this.custumerId = custumerId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(custumerId, id, productId, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(custumerId, other.custumerId) && Objects.equals(id, other.id)
				&& Objects.equals(productId, other.productId) && Objects.equals(quantity, other.quantity);
	}

	@Override
	public String toString() {
		return "" + "Pedido [id=" + id + ", ClienteID=" + custumerId + ", ProdutoID=" + productId + ", Quantidade="
				+ quantity + "]";
	}

}
