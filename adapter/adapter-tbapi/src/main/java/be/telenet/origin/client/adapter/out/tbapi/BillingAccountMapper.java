package be.telenet.origin.client.adapter.out.tbapi;

import be.telenet.origin.client.adapter.out.tbapi.model.BillingAccountDTO;
import be.telenet.origin.client.model.BillingAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillingAccountMapper {

    BillingAccountMapper INSTANCE = Mappers.getMapper( BillingAccountMapper.class );

    @Mapping(source = "billingAccountNumber.number", target = "id")
    BillingAccountDTO billingAccountToDTO(BillingAccount billingAccount);

    @Mapping(target = "billingAccountNumber.number", source = "id")
    BillingAccount dtoToBillingAccount(BillingAccountDTO billingAccountDTO);

}
