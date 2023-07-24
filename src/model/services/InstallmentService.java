package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class InstallmentService {

    private OnlinePaymentService onlinePaymentService;

    public InstallmentService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void installmentOfTheContract(Contract contract, int numberOfContractInstallments) {
        double parcelValue = contract.getTotalValue() / numberOfContractInstallments;
        for (int i=1;i<=numberOfContractInstallments;i++) {
            LocalDate date = contract.getDate().plusMonths(i);
            double paymentInterest = onlinePaymentService.paymentInterest(parcelValue, i);
            double paymentRate = onlinePaymentService.paymentRate(paymentInterest);
            double totalValueOfThePlot = paymentInterest + paymentRate;
            contract.getInstallments().add(new Installment(date, totalValueOfThePlot));
        }
    }

}
