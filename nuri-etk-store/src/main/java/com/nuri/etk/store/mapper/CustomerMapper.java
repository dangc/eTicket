package com.nuri.etk.store.mapper;

import com.nuri.etk.store.jpo.CustomerJpo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerJpo getCustomerByNo(String customerNo)throws Exception;
}