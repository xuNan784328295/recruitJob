package com.hanvon.zhaopin.asm;

import com.hanvon.zhaopin.tpm.recruit.Positioninfo;

import java.util.List;

/**
 * RecruitAsm:
 * User: gaoguoling
 * Date: 12-6-25
 * Time: 下午2:23
 */
public interface RecruitAsm {
    List<Positioninfo> searchByTerm(String search, String area, String category);
}
