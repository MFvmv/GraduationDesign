package com.hospital.search.service;

import com.hospital.search.domain.EsPatients;
import org.springframework.data.domain.Page;

public interface EsPatientsService {

    long importAll();

    long deleteAll();

    Page<EsPatients> search(String keyword, String field, Integer pageNum, Integer pageSize);
}
