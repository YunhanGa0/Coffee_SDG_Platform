package com.coffee_backend.service;

import cn.hutool.core.bean.BeanUtil;
import com.coffee_backend.dto.*;
import com.coffee_backend.entity.Farm;
import com.coffee_backend.entity.FarmBlog;
import com.coffee_backend.repo.FarmBlogRepository;
import com.coffee_backend.repo.FarmRepository;
import com.coffee_backend.util.UserContext;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FarmBlogService {

    @Autowired
    private FarmBlogRepository farmBlogRepository;


    @Autowired
    private FarmRepository farmRepository;


    public ApiResponse createBlog(Long farmid, FarmBlogRequest request) {
        Optional<Farm> farmOptional = farmRepository.findById(farmid);
        if (farmOptional.isEmpty()){
            return ApiResponse.error(400, "Farm not found");
        }

        // TODO 打开
//        if (!Objects.equals(farmOptional.get().getUser().getId(), UserContext.getUser())){
//            return ApiResponse.error(400, "You are not current owner for the farm");
//        }

        FarmBlog farmBlog = BeanUtil.copyProperties(request, FarmBlog.class);

        farmBlog.setFarm(farmOptional.get());

        FarmBlog saved = farmBlogRepository.save(farmBlog);

        BlogBasicResponse response = BeanUtil.copyProperties(saved, BlogBasicResponse.class);

        return ApiResponse.success(response);
    }

    public ApiResponse updateBlog(Long farmid, FarmBlogRequest request, Long blogid) {
        Optional<Farm> farmOptional = farmRepository.findById(farmid);
        if (farmOptional.isEmpty()){
            return ApiResponse.error(400, "Farm not found");
        }

        // TODO 打开
//        if (!Objects.equals(farmOptional.get().getUser().getId(), UserContext.getUser())){
//            return ApiResponse.error(400, "You are not current owner for the farm");
//        }

        Optional<FarmBlog> blogOptional = farmBlogRepository.findById(blogid);
        if (blogOptional.isEmpty()){
            return ApiResponse.error(400, "Blog not found");
        }

        FarmBlog farmBlog = blogOptional.get();

        Boolean temp = farmBlog.getPublished();

        BeanUtils.copyProperties(request, farmBlog);

        farmBlog.setPublished(temp);

        FarmBlog saved = farmBlogRepository.save(farmBlog);

        BlogBasicResponse response = BeanUtil.copyProperties(saved, BlogBasicResponse.class);

        return ApiResponse.success(response);
    }

    public ApiResponse deleteBlog(Long farmid, Long blogid) {
        Optional<Farm> farmOptional = farmRepository.findById(farmid);
        if (farmOptional.isEmpty()){
            return ApiResponse.error(400, "Farm not found");
        }

        // TODO 打开
//        if (!Objects.equals(farmOptional.get().getUser().getId(), UserContext.getUser())){
//            return ApiResponse.error(400, "You are not current owner for the farm");
//        }

        Optional<FarmBlog> blogOptional = farmBlogRepository.findById(blogid);
        if (blogOptional.isEmpty()){
            return ApiResponse.error(400, "Blog not found");
        }

        farmBlogRepository.deleteById(blogid);

        return ApiResponse.success();
    }

    public ApiResponse listBlog(Long farmid, PageQueryRequest request) {
        Optional<Farm> farmOptional = farmRepository.findById(farmid);
        if (farmOptional.isEmpty()){
            return ApiResponse.error(400, "Farm not found");
        }

        int page = Optional.ofNullable(request.getPage()).orElse(0);
        int size = Optional.ofNullable(request.getSize()).orElse(10);

        PageRequest pageRequest = PageRequest.of(page, size);

        Specification<FarmBlog> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (request.getPublished() != null) {
                predicates.add(cb.equal(root.get("published"), request.getPublished()));
            }

            predicates.add(cb.equal(root.get("farm").get("id"), farmid));

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        Page<FarmBlog> all = farmBlogRepository.findAll(spec, pageRequest);

        Farm farm = farmOptional.get();
        FarmSmallDTO farmSmallDTO = new FarmSmallDTO();
        farmSmallDTO.setFarmName(farm.getFarmName());
        farmSmallDTO.setId(farm.getId());

        List<BlogSmallResponse> collect = all.getContent().stream().map(farmBlog -> {
            BlogSmallResponse blogSmallResponse = BeanUtil.copyProperties(farmBlog, BlogSmallResponse.class);
            blogSmallResponse.setFarm(farmSmallDTO);

            return blogSmallResponse;
        }).toList();

        return ApiResponse.success(
                PageQueryResponse.builder()
                        .content(collect)
                        .totalPages(all.getTotalPages())
                        .totalElements(all.getTotalElements())
                        .pageNumber(all.getNumber())
                        .pageSize(all.getSize())
                        .first(all.isFirst())
                        .last(all.isLast())
                        .empty(all.isEmpty())
                        .build()
        );
    }

    public ApiResponse patchBlog(Long farmid, BlogPatchRequest request, Long blogid) {
        Optional<Farm> farmOptional = farmRepository.findById(farmid);
        if (farmOptional.isEmpty()){
            return ApiResponse.error(400, "Farm not found");
        }

        // TODO 打开
//        if (!Objects.equals(farmOptional.get().getUser().getId(), UserContext.getUser())){
//            return ApiResponse.error(400, "You are not current owner for the farm");
//        }

        Optional<FarmBlog> blogOptional = farmBlogRepository.findById(blogid);
        if (blogOptional.isEmpty()){
            return ApiResponse.error(400, "Blog not found");
        }

        FarmBlog farmBlog = blogOptional.get();

        farmBlog.setPublished(request.getPublished());

        FarmBlog saved = farmBlogRepository.save(farmBlog);

        BlogPatchResponse response = BeanUtil.copyProperties(saved, BlogPatchResponse.class);

        return ApiResponse.success(response);
    }

    public ApiResponse getBlog(Long farmid, Long blogid) {
        Optional<Farm> farmOptional = farmRepository.findById(farmid);
        if (farmOptional.isEmpty()){
            return ApiResponse.error(400, "Farm not found");
        }

        Optional<FarmBlog> blogOptional = farmBlogRepository.findById(blogid);
        if (blogOptional.isEmpty()){
            return ApiResponse.error(400, "Blog not found");
        }

        FarmBlog farmBlog = blogOptional.get();
        Farm farm = farmOptional.get();

        FarmBasicDTO farmBasicDTO = BeanUtil.copyProperties(farm, FarmBasicDTO.class);

        BlogFullResponse blogFullResponse = BeanUtil.copyProperties(farmBlog, BlogFullResponse.class);
        blogFullResponse.setFarm(farmBasicDTO);

        return ApiResponse.success(blogFullResponse);
    }
}
