package com.hanvon.zhaopin.bsm;


import com.hanvon.zhaopin.tpm.recruit.Positioninfo;

import java.util.List;

/**
 * RecruitBsm:
 * User: gaoguoling
 * Date: 12-9-17
 * Time: 下午2:40
 */
public interface RecruitBsm {

    List<Positioninfo> searchByTerm(String search, String area, String category);
}
