package com.prova.provaesame.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.prova.provaesame.Dao.NastriDao;
import com.prova.provaesame.Dto.NastriDto;
import com.prova.provaesame.Repository.NastriRepository;
import com.prova.provaesame.Service.NastriService;

//implementazione dei servizi dichiarati nel service (per questo si utilizza implements)
@Service
public class NastriServiceImpl implements NastriService{

	@Lazy
	@Autowired
	NastriRepository nastriRepository;
	
	@Override
	public List<NastriDto> fetchAll() {
		//faccio un get all dalla repository e poi converto in dto
		List<NastriDao> list = nastriRepository.findAll();
		List<NastriDto> listDto = new ArrayList<NastriDto>();
		for (NastriDao u : list) {
			listDto.add(u.convertToDto());
		}

		return listDto;
	}

	// so che l'update non è richiesto, mi serve solo per le mie prove su postman...
	@Override
	public boolean update(NastriDto dto) {
		//controllo che l'id esista
		if (nastriRepository.existsById(dto.getId())) {
			try {
				// passo al save il dto (ricavato dal body, inviato dall'utente) convertito in dao
				NastriDao dao = dto.convertToDao();
				nastriRepository.save(dao);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean create(NastriDto dto) {
		// passo il dto dal body e lo converto in dao, per poi effettuare l'insert grazie al save
		try {
			NastriDao dao = dto.convertToDao();
			nastriRepository.save(dao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public NastriDto getById(int id) {
		// trovo l'id corrispondente e lo trasformo in dto
		return nastriRepository.getById(id).convertToDto();
	}

}
