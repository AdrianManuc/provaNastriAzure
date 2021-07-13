package com.prova.provaesame.Dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.prova.provaesame.Dto.ConsumiDto;

import lombok.Data;

// classe di collegamento con la tabella
@Entity
@Table(name = "consumo")
@Data
public class ConsumiDao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "consumo_id")
	private Integer consumoId;
	
	@Column(name = "nastro_id")
	private Integer nastroId;

	@Column(name = "consumo")
	private Float consumo;
	
	// metodo per convertire un Dao in Dto
	public ConsumiDto convertToDto() {

		ConsumiDto dto = new ConsumiDto();
	 	
	 	dto.setConsumoId(this.getConsumoId());
	 	dto.setNastroId(this.getNastroId());
	 	dto.setConsumo(this.getConsumo());

		return dto;
	}
}
