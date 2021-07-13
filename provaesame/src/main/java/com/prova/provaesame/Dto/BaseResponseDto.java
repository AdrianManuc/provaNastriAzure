package com.prova.provaesame.Dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//classe di configurazione della risposta dto, settando stringhe di messaggi, errori, status http, etc.
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseResponseDto<T> {

	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private Object response;

}
