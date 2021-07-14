package pdp.uz.mongodbg10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.mongodbg10.model.District;
import pdp.uz.mongodbg10.service.DistrictService;

import java.util.List;

@RestController
@RequestMapping("/api/district")
public class DistrictController{

    @Autowired
    DistrictService districtService;

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    GridFsOperations gridFsOperations;


    @GetMapping
    public HttpEntity<?> getDistricts(){
        List<District> districts = districtService.getDistricts();
        return ResponseEntity.ok(districts);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getDistrict(@PathVariable String id){
        District district = districtService.getDistrict(id);
        return ResponseEntity.status(district!=null?200:404).body(district);
    }

    @PostMapping
    public HttpEntity<?> addDistrict(@RequestBody District district){
        District addDistrict = districtService.addDistrict(district);
        return ResponseEntity.ok(addDistrict);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editDistrict(@PathVariable String id, @RequestBody District district){
        District editingDistrict = districtService.editDistrict(id, district);
        return ResponseEntity.ok(editingDistrict);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteDistrict(@PathVariable String id){
        String district = districtService.deleteDistrict(id);
        return ResponseEntity.ok(district);
    }
}
