package com.prova.provaesame.Service;

import java.util.List;

import com.prova.provaesame.Dto.VelocitaDto;

//interfaccia che dichiara i metodi da implementare e che verranno utilizzati nelle API
public interface VelocitaService {

	List<VelocitaDto> fetchAll();

	boolean create(VelocitaDto dto);
	
	VelocitaDto getById(int id);
}
