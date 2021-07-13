package com.prova.provaesame.Dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.prova.provaesame.Dto.VelocitaDto;

import lombok.Data;

//classe di collegamento con la tabella
@Entity
@Table(name = "velocita")
@Data
public class VelocitaDao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "velocita_id")
	private Integer velocitaId;
	
	@Column(name = "nastro_id")
	private Integer nastroId;

	@Column(name = "velocita")
	private Float velocita;
	
	// metodo per convertire un Dao in Dto
	public VelocitaDto convertToDto() {

		VelocitaDto dto = new VelocitaDto();
	 	
	 	dto.setVelocitaId(this.getVelocitaId());
	 	dto.setNastroId(this.getNastroId());
	 	dto.setVelocita(this.getVelocita());

		return dto;
	}
}
