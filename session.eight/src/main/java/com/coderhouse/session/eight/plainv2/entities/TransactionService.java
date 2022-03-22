package com.coderhouse.session.eight.plainv2.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class TransactionService extends GenericService<Transaction, Integer> {

    @Autowired
    public TransactionService(TransactionRepository transactionRepository){
        super(transactionRepository);
    }
}
