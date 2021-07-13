package com.prova.provaesame.Dto;

import com.prova.provaesame.Dao.VelocitaDao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//classe che gestisce e trasferisce i dati estrapolati, serve per ridurre il numero di chiamate effettuate
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VelocitaDto {
	private Integer velocitaId;
	private Integer nastroId;
	private Float velocita;
	
	public VelocitaDao convertToDao() {

		VelocitaDao dao = new VelocitaDao();
	 	
	 	dao.setNastroId(this.getNastroId());
	 	dao.setVelocita(this.getVelocita());
	 	dao.setVelocitaId(this.getVelocitaId());

		return dao;
	}
}
