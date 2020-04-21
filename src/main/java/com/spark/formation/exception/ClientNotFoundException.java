package com.spark.formation.exception;

import com.spark.formation.exception.DataNotFoundException;

public class ClientNotFoundException extends DataNotFoundException {

    private static final long serialVersionUID = -585393677381609541L;

    private static final String code = "ERROR_NF_001";

    private static final String message = "Client not found";

    public ClientNotFoundException() {
        super(code, message);
    }}
