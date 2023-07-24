package model.services;

public interface OnlinePaymentService {

    double paymentRate(double parcelValue);
    double paymentInterest(double parcelValue, int numberOfContractInstallments);

}
