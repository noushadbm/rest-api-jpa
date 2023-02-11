package com.rayshan.repository;

import com.rayshan.common.entities.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SequenceRepository extends JpaRepository<Sequence, Long> {

    //@Query("Select nextValue from Sequence where sequenceName = 'HID'")
    @Query(value = "Select next_val from my_sequence where seq_name = 'HID'", nativeQuery = true)
    Long getNextHid();

    @Modifying
    @Query(value = "Update my_sequence set next_val = :newVal where seq_name = 'HID'", nativeQuery = true)
    Integer updateHid(@Param("newVal") Long newVal);
}
