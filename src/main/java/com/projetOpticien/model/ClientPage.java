package com.projetOpticien.model;

import org.springframework.data.domain.Sort;

import lombok.Data;
@Data
public class ClientPage {
	 private int pageNumber = 0;
	    private int pageSize = 10;
	    private Sort.Direction sortDirection = Sort.Direction.ASC;
	    private String sortBy = "nomPrenom";

}
