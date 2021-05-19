package io.swagger.api.impl;

import dev.andrylat.banking.common.mortgagecalculator.calculator.Calculator;
import dev.andrylat.banking.common.mortgagecalculator.calculator.LoanAmortizationCalculator;
import dev.andrylat.banking.common.mortgagecalculator.calculator.MonthlyPaymentCalculator;
import dev.andrylat.banking.common.mortgagecalculator.calculator.ResultData;
import dev.andrylat.banking.common.mortgagecalculator.validation.CompositeInputValidator;
import dev.andrylat.banking.common.mortgagecalculator.validation.InputData;
import dev.andrylat.banking.common.mortgagecalculator.validation.InputValidator;
import io.swagger.api.MortgageApiService;
import io.swagger.api.NotFoundException;
import io.swagger.model.CalculatorInput;
import io.swagger.model.LoanAmortizationData;
import io.swagger.model.MortgageCalculatedData;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-05-11T12:53:02.872Z[GMT]")
public class MortgageApiServiceImpl extends MortgageApiService {
    @Override
    public Response calculatePayments(CalculatorInput body, SecurityContext securityContext) throws NotFoundException {
        InputValidator validator = new CompositeInputValidator();
        MortgageCalculatedData mortgageData = new MortgageCalculatedData();

        InputData inputData = getInputData(body);
        List<String> failureMessages = validator.validate(inputData);
        mortgageData.setValidationMessages(failureMessages);

        if (failureMessages.isEmpty()) {
            mortgageData.setValidationResult(true);

            Calculator<Double> monthlyPaymentCalculator = new MonthlyPaymentCalculator();
            double monthlyPayment = monthlyPaymentCalculator.calculate(inputData);
            mortgageData.setMonthlyPayment(monthlyPayment);

            List<LoanAmortizationData> loanAmortizationData = getLoanAmortizationData(inputData);
            mortgageData.setLoanAmortizationData(loanAmortizationData);

            return Response.status(Response.Status.OK).entity(mortgageData).build();
        } else {
            mortgageData.setValidationResult(false);
            return Response.status(Response.Status.BAD_REQUEST).entity(mortgageData).build();
        }

    }

    private InputData getInputData(CalculatorInput body) {
        InputData inputData = new InputData();

        inputData.setLoanAmount(body.getLoanAmount());
        inputData.setInterestRate(body.getInterestRate());
        inputData.setTermYears(body.getTermYears());

        return inputData;
    }

    private List<LoanAmortizationData> getLoanAmortizationData(InputData inputData) {
        List<LoanAmortizationData> loanAmortizationList = new ArrayList<>();

        Calculator<List<ResultData>> loanAmortizationCalculator = new LoanAmortizationCalculator();
        List<ResultData> resultDataList = loanAmortizationCalculator.calculate(inputData);

        for (ResultData data : resultDataList) {
            LoanAmortizationData loanAmortizationData = new LoanAmortizationData();
            loanAmortizationData.setMonth(data.getMonth());
            loanAmortizationData.setInterest(data.getInterest());
            loanAmortizationData.setPrincipal(data.getPrincipal());
            loanAmortizationData.setBalance(data.getBalance());

            loanAmortizationList.add(loanAmortizationData);
        }

        return loanAmortizationList;
    }

}
