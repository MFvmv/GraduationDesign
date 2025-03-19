package com.hospital.search.repository;

import com.hospital.search.domain.EsPatients;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsPatientsRepository extends ElasticsearchRepository<EsPatients, Long> {

}
