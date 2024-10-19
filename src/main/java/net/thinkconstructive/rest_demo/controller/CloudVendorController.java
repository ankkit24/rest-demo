package net.thinkconstructive.rest_demo.controller;

import net.thinkconstructive.rest_demo.model.CloudVendor;
import net.thinkconstructive.rest_demo.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController
{

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService){
        this.cloudVendorService = cloudVendorService;
    }

    //getting a cloud vendor
    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return cloudVendorService.getCloudVendor(vendorId);
    }

    //getting all cloud vendors
    @GetMapping
    public List<CloudVendor> getAllCloudVendors(){
        return cloudVendorService.getAllCloudVendors();
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudvendor) {
        cloudVendorService.createCloudVendor(cloudvendor);
        return "New cloud vendor created successfully";
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudvendor) {
        if(cloudvendor.getVendorId()!=null){
            cloudVendorService.updateCloudVendor(cloudvendor);
            return "Cloud vendor details updated successfully!";
        }else{
            return "Cloud vendorId does not exist for update operation!";
        }
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable("vendorId") String vendorId) {
        if(cloudVendorService.getCloudVendor(vendorId) != null){
            cloudVendorService.deleteCloudVendor(vendorId);
            return "Cloud vendor deleted successfully";
        }else{
            return "Cloud vendorId does not exist for delete operation!";
        }
    }

}
