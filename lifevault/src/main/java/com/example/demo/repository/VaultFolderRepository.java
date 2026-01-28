package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.VaultFolder;

import java.util.List;

public interface VaultFolderRepository extends JpaRepository<VaultFolder, Long> {

    List<VaultFolder> findByOwnerId(Long ownerId);
    List<VaultFolder> findByOwnerIdAndIsReleasedTrue(Long ownerId);
    @Query("""
    		SELECT f
    		FROM VaultFolder f, OwnerNominee om
    		WHERE f.owner.id = om.owner.id
    		AND om.nominee.id = :nomineeId
    		AND f.isReleased = true
    		""")
    		List<VaultFolder> findReleasedFoldersByNomineeId(Long nomineeId);


}