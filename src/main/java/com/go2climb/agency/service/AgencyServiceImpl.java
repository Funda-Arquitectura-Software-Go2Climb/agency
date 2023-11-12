package com.go2climb.agency.service;

import com.go2climb.agency.domain.entity.Agency;
import com.go2climb.agency.domain.repository.AgencyRepository;
import com.go2climb.agency.domain.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpConnectTimeoutException;
import java.util.List;
import java.util.Optional;

@Service
public class AgencyServiceImpl implements AgencyService {
    @Autowired
    private AgencyRepository agencyRepository;
    @Transactional(readOnly = true)
    @Override
    public List<Agency> getAll() {
        return agencyRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Agency> getById(Integer id) {
        if (agencyRepository.existsById(id)){
            return agencyRepository.findById(id);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Transactional
    @Override
    public Agency save(Agency entity) {
        return agencyRepository.save(entity);
    }

    @Transactional
    @Override
    public Agency update(Agency entity) {
        return agencyRepository.save(entity);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (agencyRepository.existsById(id)){
            agencyRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }
}
