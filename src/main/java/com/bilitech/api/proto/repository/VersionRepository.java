package com.bilitech.api.proto.repository;

import com.bilitech.api.proto.entity.Version;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VersionRepository extends JpaRepository<Version, String> {
    Optional<Version> findFirstByProtoIdOrderByCreatedTimeDesc(String protoId);
}