package com.hanvon.zhaopin.bsm.impl;

import com.hanvon.zhaopin.bsm.RecruitBsm;
import com.hanvon.zhaopin.dsm.PositioninfoDsm;
import com.hanvon.zhaopin.tpm.recruit.Positioninfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * WSTokenBsmImpl:
 * User: gaoguoling
 * Date: 12-9-17
 * Time: 下午2:42
 */
@Scope("singleton")
@Repository("recruitBsm")
public class RecruitBsmImpl implements RecruitBsm {
    @Autowired
    PositioninfoDsm positioninfoDsm;
    @Override
    public List<Positioninfo> searchByTerm(String search, String area, String category) {

        return positioninfoDsm.searchByTerm(search,area,category);
    }
}
