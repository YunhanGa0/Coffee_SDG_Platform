package com.coffee_backend.service;

import cn.hutool.core.bean.BeanUtil;
import com.coffee_backend.dto.ApiResponse;
import com.coffee_backend.dto.FarmResponse;
import com.coffee_backend.dto.PageQueryRequest;
import com.coffee_backend.dto.PageQueryResponse;
import com.coffee_backend.entity.Farm;
import com.coffee_backend.repo.FarmRepository;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FarmService {

    @Autowired
    private FarmRepository farmRepository;


    public PageQueryResponse list(PageQueryRequest pageQueryRequest) {
        PageRequest pageRequest = PageRequest.of(pageQueryRequest.getPage(), pageQueryRequest.getSize());

        Specification<Farm> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasText(pageQueryRequest.getCountry())) {
                predicates.add(cb.equal(root.get("country"), pageQueryRequest.getCountry()));
            }

            if (pageQueryRequest.getCertified() != null) {
                predicates.add(cb.equal(root.get("isCertificated"), pageQueryRequest.getCertified()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };

        Page<Farm> all = farmRepository.findAll(spec, pageRequest);

        List<FarmResponse> farmResponseStream = all.getContent().stream().map(farm -> {
            FarmResponse farmResponse = BeanUtil.copyProperties(farm, FarmResponse.class);
            farmResponse.setUserId(farm.getUser().getId());

            return farmResponse;
        }).collect(Collectors.toList());

        return PageQueryResponse.builder()
                .content(farmResponseStream)
                .totalPages(all.getTotalPages())
                .totalElements(all.getTotalElements())
                .pageNumber(all.getNumber())
                .pageSize(all.getSize())
                .first(all.isFirst())
                .last(all.isLast())
                .empty(all.isEmpty())
                .build();
    }

    public ApiResponse getById(Long id) {
        Optional<Farm> farm = farmRepository.findById(id);

        if (farm.isPresent()){
            FarmResponse farmResponse = BeanUtil.copyProperties(farm.get(), FarmResponse.class);
            farmResponse.setUserId(farm.get().getUser().getId());
            return ApiResponse.success(farmResponse);
        }else{
            return ApiResponse.error(404, "Farm not found");
        }
    }
}
