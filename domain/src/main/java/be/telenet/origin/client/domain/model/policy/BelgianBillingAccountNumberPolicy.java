package be.telenet.origin.client.domain.model.policy;

public class BelgianBillingAccountNumberPolicy implements BillingAccountNumberPolicy {

        @Override
        public boolean isValid(String accountNumber) {
            return accountNumber != null && accountNumber.matches("^[0-9]{12}$");
        }
}
