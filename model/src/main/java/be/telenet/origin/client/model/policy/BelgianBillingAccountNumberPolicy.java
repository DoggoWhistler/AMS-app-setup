package be.telenet.origin.client.model.policy;

public class BelgianBillingAccountNumberPolicy implements BillingAccountNumberPolicy {

        @Override
        public boolean isValid(String accountNumber) {
            return accountNumber != null && accountNumber.matches("^[0-9]{1,30}$");
        }
}
