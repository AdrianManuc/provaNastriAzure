package com.prova.provaesame.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.prova.provaesame.Dao.VelocitaDao;
import com.prova.provaesame.Dto.VelocitaDto;
import com.prova.provaesame.Repository.VelocitaRepository;
import com.prova.provaesame.Service.VelocitaService;

// implementazione dei servizi dichiarati nel service (per questo si utilizza implements)
@Service
public class VelocitaServiceImpl implements VelocitaService{

	@Lazy
	@Autowired
	VelocitaRepository velocitaRepository;
	
	@Override
	public List<VelocitaDto> fetchAll() {
		//faccio un get all dalla repository e poi converto in dto
		List<VelocitaDao> list = velocitaRepository.findAll();
		List<VelocitaDto> listDto = new ArrayList<VelocitaDto>();
		for (VelocitaDao u : list) {
			listDto.add(u.convertToDto());
		}

		return listDto;
	}

	@Override
	public boolean create(VelocitaDto dto) {
		// passo il dto dal body e lo converto in dao, per poi effettuare l'insert grazie al save
		try {
			VelocitaDao dao = dto.convertToDao();
			velocitaRepository.save(dao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public VelocitaDto getById(int id) {
		// trovo l'id corrispondente e lo trasformo in dto
		return velocitaRepository.getById(id).convertToDto();
	}

}
