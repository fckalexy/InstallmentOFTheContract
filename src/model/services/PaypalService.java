package model.services;

public class PaypalService implements OnlinePaymentService{

    @Override
    public double paymentRate(double parcelValue) {
        return parcelValue * 0.02;
    }

    @Override
    public double paymentInterest(double parcelValue, int numberOfContractInstallments) {
        double percentage = (double) numberOfContractInstallments / 100;
        return parcelValue * percentage + parcelValue;
    }

}
