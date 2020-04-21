package com.spark.formation.exception;

public class EntityNotFoundException extends DataNotFoundException {

    private static final long serialVersionUID = -585393677381609541L;

    private static final String code = "ERROR_NF_001";

    private static final String message = "Entity not found";

    public EntityNotFoundException() {
        super(code, message);
    }}
