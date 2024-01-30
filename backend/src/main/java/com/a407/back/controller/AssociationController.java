package com.a407.back.controller;

import com.a407.back.config.constants.SuccessCode;
import com.a407.back.dto.User.UserAssociationResponse;
import com.a407.back.dto.association.AssociationAdditionCodeResponse;
import com.a407.back.dto.util.ApiResponse;
import com.a407.back.model.service.AssociationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/associations")
public class AssociationController {

    private final AssociationService associationService;

    @PostMapping
    public ApiResponse<String> makeAssociation() {
        // 스프링 시큐리티 도입 전 임시 값
        associationService.makeAssociation(7L);
        return new ApiResponse<>(SuccessCode.INSERT_SUCCESS, "연동 계정 생성 성공");
    }


    @GetMapping
    public ApiResponse<List<UserAssociationResponse>> searchAssociationUserList() {
        // 스프링 시큐리티 도입 전 임시 값
        return new ApiResponse<>(SuccessCode.SELECT_SUCCESS,
            associationService.searchAssociationUserList(4L));
    }

    @DeleteMapping
    public ApiResponse<String> deleteAssociation() {
        // 스프링 시큐리티 도입 전 임시 값
        associationService.deleteAssociation(7L);
        return new ApiResponse<>(SuccessCode.DELETE_SUCCESS, "연동 계정 삭제 성공");
    }


    @PostMapping("/addition")
    public ApiResponse<AssociationAdditionCodeResponse> makeAdditionCode()
        throws NoSuchAlgorithmException, JsonProcessingException {
        // 스프링 시큐리티 도입 전 임시 값
        return new ApiResponse<>(SuccessCode.INSERT_SUCCESS,
            associationService.makeAdditionCode(7L, "test@test.com", 6L));
    }

    @PostMapping("/participate")
    public ApiResponse<String> changeAddition() {
        // 스프링 시큐리티 도입 전 임시 값
        associationService.changeAssociation(8L, "66513330");
        return new ApiResponse<>(SuccessCode.INSERT_SUCCESS, "연동 계정 참가 성공");
    }

    @PatchMapping("/representative")
    public ApiResponse<String> changeAssociationRepresentative() {
        // 스프링 시큐리티 도입 전 임시 값
        associationService.changeAssociationRepresentative(8L, 8L);
        return new ApiResponse<>(SuccessCode.UPDATE_SUCCESS, "연동 계정 대표 변경 성공");
    }


}
