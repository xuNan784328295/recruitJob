package com.hanvon.zhaopin.asm.impl;

import com.hanvon.zhaopin.asm.RecruitAsm;
import com.hanvon.zhaopin.bsm.RecruitBsm;
import com.hanvon.zhaopin.tpm.recruit.Positioninfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Scope("singleton")
@Repository("recruitAsm")
@Transactional(rollbackFor = Throwable.class)
public class RecruitAsmImpl implements RecruitAsm {
    @Autowired
    protected RecruitBsm recruitBsm;

    @Override
    public  List<Positioninfo> searchByTerm(String search, String area, String category) {
      return  recruitBsm.searchByTerm(search,area,category);
    }


}
