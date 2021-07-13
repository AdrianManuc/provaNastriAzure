package com.prova.provaesame.Service;

import java.util.List;
import com.prova.provaesame.Dto.NastriDto;

//interfaccia che dichiara i metodi da implementare e che verranno utilizzati nelle API
public interface NastriService {

	List<NastriDto> fetchAll();

	boolean update(NastriDto dto);

	boolean create(NastriDto dto);
	
	NastriDto getById(int id);
}
