package com.premsh.jpaexperiment.data.channelbase.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.premsh.jpaexperiment.data.channelbase.models.Package;

@Repository
public interface PackageRepository extends JpaRepository<Package, Integer> {

}
