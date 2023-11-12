package com.go2climb.agency.domain.service;

import com.go2climb.agency.domain.entity.Agency;

import java.util.List;
import java.util.Optional;

public interface AgencyService {
    List<Agency> getAll();
    Optional<Agency> getById(Integer id);
    Agency save(Agency entity);
    Agency update(Agency entity);
    boolean deleteById(Integer id);
}
