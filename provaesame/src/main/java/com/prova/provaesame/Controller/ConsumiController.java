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
import com.prova.provaesame.Dto.ConsumiDto;
import com.prova.provaesame.Service.ConsumiService;

// classe controller in cui vengono implementate e configurate le API
@RestController
@RequestMapping(value = "api/consumi")
public class ConsumiController {
	private static final Logger logger = LoggerFactory.getLogger(ConsumiController.class);

	@Autowired
	ConsumiService consumiService;

	// metodo get per mostrare tutti i dati
	@GetMapping(produces = "application/json")
	public BaseResponseDto<List<ConsumiDto>> fetchAll() {

		logger.info("****** FETCH *******");

		BaseResponseDto<List<ConsumiDto>> response = new BaseResponseDto<>();
		response.setTimestamp(new Date());

		List<ConsumiDto> consumi = consumiService.fetchAll();

		// controllo che ci siano dati da mostrare
		if (consumi.isEmpty()) {
			response.setStatus(HttpStatus.NO_CONTENT.value());
			response.setMessage("Null");
		} else {
			response.setResponse(consumi);
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Servizio elaborato correttamente");
		}

		return response;
	}
	
	// GET BY ID
		@GetMapping(produces = "application/json", path = "/{idConsumo}")
		public BaseResponseDto<ConsumiDto> readById(@PathVariable int idConsumo) {
			BaseResponseDto<ConsumiDto> response = new BaseResponseDto<>();

			ConsumiDto consumo = consumiService.getById(idConsumo);

			response.setTimestamp(new Date());
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("SERVIZIO_ELABORATO_CORRETTAMENTE");
			response.setResponse(consumo);

			return response;
		}

	// insert dei dati ricavati dal body
	@PostMapping(produces = "application/json")
	public BaseResponseDto<ConsumiDto> createPosizione(@RequestBody ConsumiDto consumo) {

		logger.info("****** CREATE *******");
		BaseResponseDto<ConsumiDto> response = new BaseResponseDto<>();
		response.setTimestamp(new Date());

		// controllo che la relazione con il nastro ci sia e che il consumo sia almeno maggiore di 0
		if (consumo.getNastroId() != null && consumo.getConsumo() > 40 && consumiService.create(consumo)) {
			response.setStatus(HttpStatus.OK.value());
			response.setMessage("Posizione aggiunta correttamente");
		}
		else if (consumo.getNastroId() == null) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("La relazione non può essere nulla");
		}
		else if (consumo.getConsumo() <= 40) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Il consumo deve essere maggiore di 40");
		}
		else {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Posizione non aggiunta");
		}

		return response;
	}

}
