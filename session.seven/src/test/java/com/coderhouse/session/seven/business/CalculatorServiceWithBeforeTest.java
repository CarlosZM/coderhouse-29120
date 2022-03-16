package com.coderhouse.session.seven.business;

import com.coderhouse.session.seven.business.domain.Operation;
import com.coderhouse.session.seven.business.domain.OperationResult;
import com.coderhouse.session.seven.business.domain.Operator;
import com.coderhouse.session.seven.business.exceptions.MathematicalOperationNotSupportedException;
import com.coderhouse.session.seven.business.exceptions.MathematicalOperationNotValidException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceWithBeforeTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void initialize() {
        this.calculatorService = new CalculatorService();
    }

    @Test
    void testCalculate_ShouldReturnOperationResult_WithAddOperator() throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException {

        Operation incoming = new Operation(
                10.0,
                Operator.ADD,
                30.0
        );

        OperationResult expected = new OperationResult(
                10.0,
                Operator.ADD,
                30.0,
                40.0
        );

        OperationResult result = calculatorService.calculate(incoming);

        assertThat(result).isEqualTo(expected);

        assertEquals(result.getResult(), expected.getResult());
    }
}