package com.prova.provaesame.Service;

import java.util.List;
import com.prova.provaesame.Dto.ConsumiDto;

// interfaccia che dichiara i metodi da implementare e che verranno utilizzati nelle API
public interface ConsumiService {

	List<ConsumiDto> fetchAll();

	boolean create(ConsumiDto dto);
	
	ConsumiDto getById(int id);
}
