package pdp.uz.mongodbg10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.mongodbg10.AddressDto;
import pdp.uz.mongodbg10.model.Address;
import pdp.uz.mongodbg10.model.District;
import pdp.uz.mongodbg10.repository.AddressRepository;
import pdp.uz.mongodbg10.repository.DistrictRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    DistrictRepository districtRepository;


    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    public Address addAddress(AddressDto addressDto) {
        Address addAddress=new Address();
        Optional<District> optionalDistrict = districtRepository.findById(addressDto.getDistrictId());
        if (!optionalDistrict.isPresent())
            return null;
        addAddress.setDistrict(optionalDistrict.get());
        addAddress.setStreet(addressDto.getStreet());
        addAddress.setHomeNumber(addressDto.getHomeNumber());
        return addressRepository.save(addAddress);
    }

}
