package be.telenet.origin.client.adaptor.tbapi.mapper;

import be.telenet.origin.client.adaptor.tbapi.model.BillingAccountDTO;
import be.telenet.origin.client.adaptor.tbapi.BillingAccountMapper;
import be.telenet.origin.client.domain.model.BillingAccount;
import be.telenet.origin.client.domain.model.BillingAccountNumber;
import be.telenet.origin.client.domain.model.MSISDN;
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
