package com.prova.provaesame.Dto;

import com.prova.provaesame.Dao.ConsumiDao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//classe che gestisce e trasferisce i dati estrapolati, serve per ridurre il numero di chiamate effettuate 
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumiDto {
	private Integer consumoId;
	private Integer nastroId;
	private Float consumo;
	
	public ConsumiDao convertToDao() {

		ConsumiDao dao = new ConsumiDao();
	 	
	 	dao.setConsumoId(this.getConsumoId());
	 	dao.setNastroId(this.getNastroId());
	 	dao.setConsumo(this.getConsumo());

		return dao;
	}
}
