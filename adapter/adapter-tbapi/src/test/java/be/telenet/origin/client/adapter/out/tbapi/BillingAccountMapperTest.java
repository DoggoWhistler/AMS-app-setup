package be.telenet.origin.client.adapter.out.tbapi;

import be.telenet.origin.client.adapter.out.tbapi.model.BillingAccountDTO;
import be.telenet.origin.client.model.BillingAccount;
import be.telenet.origin.client.model.BillingAccountNumber;
import be.telenet.origin.client.model.MSISDN;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BillingAccountMapperTest {

    @Test
    public void shouldMapBillingAccountToDto() {
        //given
        BillingAccount billingAccount = new BillingAccount(new BillingAccountNumber("012345678912"), new MSISDN( "0496362600"));

        //when
        BillingAccountDTO billingAccountDTO = BillingAccountMapper.INSTANCE.billingAccountToDTO(billingAccount);

        //then
        assertThat(billingAccountDTO).isNotNull();
        assertThat(billingAccountDTO.id()).isEqualTo("012345678912");
    }

}
