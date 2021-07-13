package com.prova.provaesame.Dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.prova.provaesame.Dto.NastriDto;

import lombok.Data;

//classe di collegamento con la tabella
@Entity
@Table(name = "nastri")
@Data
public class NastriDao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "sezione")
	private Integer sezione;

	@Column(name = "note")
	private String note;
	
	// metodo per convertire un Dao in Dto
	public NastriDto convertToDto() {

		NastriDto dto = new NastriDto();
	 	
	 	dto.setId(this.getId());
	 	dto.setSezione(this.getSezione());
	 	dto.setNote(this.getNote());

		return dto;
	}
}
