package com.prova.provaesame.Controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.provaesame.Dto.BaseResponseDto;
import com.prova.provaesame.Dto.NastriDto;
import com.prova.provaesame.Service.NastriService;

//classe controller in cui vengono implementate e configurate le API
@RestController
@RequestMapping(value = "api/nastri")
public class NastriController {
	private static final Logger logger = LoggerFactory.getLogger(NastriController.class);

	@Autowired
	NastriService nastriService;

	// metodo get per mostrare tutti i dati
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<NastriDto>> fetchAll() {

		logger.info("****** FETCH *******");

		BaseResponseDto<List<NastriDto>> response = new BaseResponseDto<>();
		response.setTimestamp(new Date());

		List<NastriDto> nastri = nastriService.fetchAll();

		// controllo che ci siano dati da mostrare
		if (nastri.isEmpty()) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
			response.setMessage("Null");
		} else {
			response.setResponse(nastri);
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Servizio elaborato correttamente");
		}

		return response;
	}
	
	// GET BY ID
		@GetMapping(produces = "application/json", path = "/{idNastro}")
		public BaseResponseDto<NastriDto> readById(@PathVariable int idNastro) {
			BaseResponseDto<NastriDto> response = new BaseResponseDto<>();

			NastriDto nastro = nastriService.getById(idNastro);

			response.setTimestamp(new Date());
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
			response.setResponse(nastro);

			return response;
		}

	// insert dei dati ricavati dal body
	@PostMapping(produces = "application/json")
	public BaseResponseDto<NastriDto> createMezzo(@RequestBody NastriDto nastro) {

		logger.info("****** CREATE *******");
		BaseResponseDto<NastriDto> response = new BaseResponseDto<>();
		response.setTimestamp(new Date());

		// controllo che la sezione ci sia
		if (nastro.getSezione() != null && nastriService.create(nastro)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Nastro aggiunto correttamente");
		} else {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Nastro non aggiunto");
		}

		return response;
	}

	// update dei dati ricavati dal body
	@PatchMapping(produces = "application/json")
	public BaseResponseDto<NastriDto> updateMezzo(@RequestBody NastriDto nastro) {

		logger.info("****** UPDATE *******");

		BaseResponseDto<NastriDto> response = new BaseResponseDto<>();
		response.setTimestamp(new Date());

		if (nastriService.update(nastro)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Ho fatto l'update del nastro");
		} else {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Errore, il nastro è rimasto invariato");
		}

		return response;
	}

}
