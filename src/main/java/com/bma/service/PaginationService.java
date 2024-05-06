package com.bma.service;

public class PaginationService {


    private static final PaginationService INSTANCE = new PaginationService();
    private PaginationService(){}
    public static PaginationService getInstance(){
        return INSTANCE;
    }
}
