package net.thinkconstructive.rest_demo.repository;

import net.thinkconstructive.rest_demo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

}
