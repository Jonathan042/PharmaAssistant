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
@Data
@Getter
@Setter
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
	
}
