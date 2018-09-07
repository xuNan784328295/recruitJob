package com.hanvon.zhaopin.dsm;

import com.hanvon.zhaopin.tpm.recruit.Positioninfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositioninfoDsm {

    List<Positioninfo> searchByTerm(@Param("search") String search,
                                    @Param("area")String area,
                                    @Param("category")String category);
}