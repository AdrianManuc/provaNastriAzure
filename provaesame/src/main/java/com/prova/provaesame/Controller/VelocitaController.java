package com.prova.provaesame.Controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.provaesame.Dto.BaseResponseDto;
import com.prova.provaesame.Dto.VelocitaDto;
import com.prova.provaesame.Service.VelocitaService;

//classe controller in cui vengono implementate e configurate le API
@RestController
@RequestMapping(value = "api/velocita")
public class VelocitaController {
	private static final Logger logger = LoggerFactory.getLogger(VelocitaController.class);

	@Autowired
	VelocitaService velocitaService;

	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<VelocitaDto>> fetchAll() {

		logger.info("****** FETCH *******");

		BaseResponseDto<List<VelocitaDto>> response = new BaseResponseDto<>();
		response.setTimestamp(new Date());

		List<VelocitaDto> velocita = velocitaService.fetchAll();

		// controllo che ci siano dati da mostrare
		if (velocita.isEmpty()) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
			response.setMessage("Null");
		} else {
			response.setResponse(velocita);
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Servizio elaborato correttamente");
		}

		return response;
	}
	
	// GET BY ID
		@GetMapping(produces = "application/json", path = "/{idVelocita}")
		public BaseResponseDto<VelocitaDto> readById(@PathVariable int idVelocita) {
			BaseResponseDto<VelocitaDto> response = new BaseResponseDto<>();

			VelocitaDto velocita = velocitaService.getById(idVelocita);

			response.setTimestamp(new Date());
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
			response.setResponse(velocita);

			return response;
		}

	@PostMapping(produces = "application/json")
	public BaseResponseDto<VelocitaDto> createVelocita(@RequestBody VelocitaDto velocita) {

		logger.info("****** CREATE *******");
		BaseResponseDto<VelocitaDto> response = new BaseResponseDto<>();
		response.setTimestamp(new Date());

		// controllo che la relazione con il nastro ci sia e che la velocità sia corretta
		if (velocita.getNastroId() != null && velocita.getVelocita() >= 0 && velocitaService.create(velocita)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Persona aggiunta correttamente");
		}
		else if (velocita.getNastroId() == null) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("La relazione non può essere nulla");
		}
		else {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Velocita non aggiunta");
		}

		return response;
	}

}
