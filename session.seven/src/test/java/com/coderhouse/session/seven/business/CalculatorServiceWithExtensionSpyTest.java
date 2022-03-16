package com.coderhouse.session.seven.business;

import com.coderhouse.session.seven.business.domain.Operation;
import com.coderhouse.session.seven.business.domain.OperationResult;
import com.coderhouse.session.seven.business.domain.Operator;
import com.coderhouse.session.seven.business.exceptions.InvalidMathematicalOperationResultException;
import com.coderhouse.session.seven.business.exceptions.MathematicalOperationNotSupportedException;
import com.coderhouse.session.seven.business.exceptions.MathematicalOperationNotValidException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceWithExtensionSpyTest {

    @Spy
    @InjectMocks
    private CalculatorService calculatorService;

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

    @Test
    void testCalculate_ShouldThrowMathematicalOperationNotValidException_WhenTryingToDivideByZero() {

        Operation incoming = new Operation(
                10.0,
                Operator.DIVIDE,
                0.0
        );

        assertThrows(MathematicalOperationNotValidException.class, () -> calculatorService.calculate(incoming));
    }


    @Test
    void testValidate_ShouldDoNothing_WithCorrectCalculationFlow() throws MathematicalOperationNotValidException, MathematicalOperationNotSupportedException, InvalidMathematicalOperationResultException {

        OperationResult incoming = new OperationResult(
                10.0,
                Operator.POW,
                30.0,
                40.0
        );

        Operation incomingOperation = new Operation(
                10.0,
                Operator.POW,
                30.0
        );

        OperationResult result = new OperationResult(
                10.0,
                Operator.POW,
                30.0,
                40.0
        );


        doReturn(result).when(this.calculatorService).calculate(incomingOperation);

        calculatorService.validate(incoming);

        verify(this.calculatorService, times(1)).validate(incoming);
    }
}