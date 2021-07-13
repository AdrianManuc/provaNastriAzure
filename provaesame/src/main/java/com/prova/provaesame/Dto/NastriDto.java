package com.prova.provaesame.Dto;

import com.prova.provaesame.Dao.NastriDao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//classe che gestisce e trasferisce i dati estrapolati, serve per ridurre il numero di chiamate effettuate
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NastriDto {
	private Integer id;
	private Integer sezione;
	private String note;
	
	public NastriDao convertToDao() {

		NastriDao dao = new NastriDao();
	 	
	 	dao.setId(this.getId());
	 	dao.setSezione(this.getSezione());
	 	dao.setNote(this.getNote());;

		return dao;
	}
}
