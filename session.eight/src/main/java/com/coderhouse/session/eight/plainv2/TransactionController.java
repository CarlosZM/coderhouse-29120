package com.coderhouse.session.eight.plainv2;

import com.coderhouse.session.eight.plainv2.entities.GenericController;
import com.coderhouse.session.eight.plainv2.entities.Transaction;
import com.coderhouse.session.eight.plainv2.entities.TransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/generics/transaction")
public class TransactionController extends GenericController<Transaction, Integer> {

    public TransactionController(TransactionService transactionIntegerGenericService) {
        super(transactionIntegerGenericService);
    }
}
