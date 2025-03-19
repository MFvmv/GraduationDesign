package com.hospital.search.service.impl;


import cn.hutool.core.collection.ListUtil;
import com.hospital.search.dao.EsPatientsDao;
import com.hospital.search.domain.EsPatients;
import com.hospital.search.repository.EsPatientsRepository;
import com.hospital.search.service.EsPatientsService;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 搜索商品管理Service实现类
 * Created by macro on 2018/6/19.
 */
@Service
public class EsPatientsServiceImpl implements EsPatientsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsPatientsServiceImpl.class);
    @Autowired
    private EsPatientsDao esPatientsDao;

    @Autowired
    private EsPatientsRepository esPatientsRepository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public long importAll() {
        List<EsPatients> esProductList = esPatientsDao.getAllEsPatientsList();
        Iterable<EsPatients> esProductIterable = esPatientsRepository.saveAll(esProductList);
        Iterator<EsPatients> iterator = esProductIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public long deleteAll() {
        long countBeforeDeletion = esPatientsRepository.count();
        esPatientsRepository.deleteAll();
        long countAfterDeletion = esPatientsRepository.count();
        long deletedCount = countBeforeDeletion - countAfterDeletion;
        deleteIndex();
        return deletedCount;
    }

    public boolean deleteIndex() {
        return elasticsearchRestTemplate.indexOps(EsPatients.class).delete();
    }

    @Override
    public Page<EsPatients> search(String keyword, String field, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        //分页
        nativeSearchQueryBuilder.withPageable(pageable);
        nativeSearchQueryBuilder.withQuery(QueryBuilders.matchQuery(field,keyword));
        NativeSearchQuery searchQuery = nativeSearchQueryBuilder.build();
        LOGGER.info("DSL:{}", searchQuery.getQuery().toString());
        SearchHits<EsPatients> searchHits = elasticsearchRestTemplate.search(searchQuery, EsPatients.class);
        System.out.println("searchHits.getTotalHits():"+searchHits.getTotalHits());
        if(searchHits.getTotalHits()<=0){
            return new PageImpl<>(ListUtil.empty(),pageable,0);
        }
        List<EsPatients> searchProductList = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        return new PageImpl<>(searchProductList,pageable,searchHits.getTotalHits());
    }

}
