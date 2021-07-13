package com.prova.provaesame.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.prova.provaesame.Dao.ConsumiDao;
import com.prova.provaesame.Dto.ConsumiDto;
import com.prova.provaesame.Repository.ConsumiRepository;
import com.prova.provaesame.Service.ConsumiService;

// implementazione dei servizi dichiarati nel service (per questo si utilizza implements)
@Service
public class ConsumiServiceImpl implements ConsumiService{

	@Lazy
	@Autowired
	ConsumiRepository consumiRepository;
	
	@Override
	public List<ConsumiDto> fetchAll() {
		//faccio un get all dalla repository e poi converto in dto
		List<ConsumiDao> list = consumiRepository.findAll();
		List<ConsumiDto> listDto = new ArrayList<ConsumiDto>();
		for (ConsumiDao u : list) {
			listDto.add(u.convertToDto());
		}

		return listDto;
	}

	@Override
	public boolean create(ConsumiDto dto) {
		// passo il dto dal body e lo converto in dao, per poi effettuare l'insert grazie al save
		try {
			ConsumiDao dao = dto.convertToDao();
			consumiRepository.save(dao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public ConsumiDto getById(int id) {
		// trovo l'id corrispondente e lo trasformo in dto
		return consumiRepository.getById(id).convertToDto();
	}

}
