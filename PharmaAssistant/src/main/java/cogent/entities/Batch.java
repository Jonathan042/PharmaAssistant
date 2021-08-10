package cogent.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="batch")
//@Data
//@Getter
//@Setter
public class Batch {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private long id;
	@Column(name = "batch_code")
	private String batchCode;
	
	@ManyToOne
    @JoinColumn(name = "medicine", nullable = false)
	private Medicine medicine;
	@Column
	private long weight;
	@Column
	private double price;
	@Column
	private boolean refrigeration;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBatchCode() {
		return batchCode;
	}
	public void setBatchCode(String batchCode) {
		this.batchCode = batchCode;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isRefrigeration() {
		return refrigeration;
	}
	public void setRefrigeration(boolean refrigeration) {
		this.refrigeration = refrigeration;
	}
	
	
	
}
