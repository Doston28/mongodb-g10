package pdp.uz.mongodbg10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.mongodbg10.model.District;
import pdp.uz.mongodbg10.repository.DistrictRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    public List<District> getDistricts() {
        return districtRepository.findAll();
    }

    public District getDistrict(String id) {
        Optional<District> optionalDistrict = districtRepository.findById(id);
        return optionalDistrict.orElse(null);
    }

    public District addDistrict(District district) {
        District addDistrict = new District();
        addDistrict.setName(district.getName());
        return districtRepository.save(addDistrict);
    }

    public District editDistrict(String id, District district){
        Optional<District> optionalDistrict = districtRepository.findById(id);
        if (!optionalDistrict.isPresent())
            return null;
        District editingDistrict = optionalDistrict.get();
        editingDistrict.setName(district.getName());
       return districtRepository.save(editingDistrict);
    }

    public String deleteDistrict(String id){
        try {
            districtRepository.deleteById(id);
            return "District deleted";
        }
        catch (Exception e){
            return "District not deleted";
        }
    }
}
