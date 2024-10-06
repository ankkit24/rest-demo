package net.thinkconstructive.rest_demo.controller;

import net.thinkconstructive.rest_demo.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class CloudAPIService
{
    CloudVendor cloudvendor;

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(String vendorId){
        return cloudvendor;
//                new CloudVendor("id1","Ankit","new hill","9199999999");
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudvendor) {
        this.cloudvendor = cloudvendor;
        return "New cloud vendor created successfully";
    }

    @PutMapping
    public String updateCloudVendor(@RequestBody CloudVendor cloudvendor) {
        if(this.cloudvendor.getVendorId()!=null && this.cloudvendor.getVendorId().equalsIgnoreCase(cloudvendor.getVendorId())){
            this.cloudvendor = cloudvendor;
            return "Cloud vendor details updated successfully";
        }else{
            return "Cloud vendorId does not exist";
        }
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(String vendorId) {
        if(this.cloudvendor.getVendorId()!=null &&
                this.cloudvendor.getVendorId().equalsIgnoreCase(vendorId)){
            this.cloudvendor = null;
            return "Cloud vendor details updated successfully";
        }else{
            return "Cloud vendorId does not exist";
        }
    }

}
