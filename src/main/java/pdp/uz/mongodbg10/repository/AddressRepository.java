package pdp.uz.mongodbg10.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pdp.uz.mongodbg10.model.Address;
import pdp.uz.mongodbg10.model.District;

public interface AddressRepository extends MongoRepository<Address,String> {
}
