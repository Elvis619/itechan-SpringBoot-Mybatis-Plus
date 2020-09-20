package com.peixin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.peixin.entity.Address;
import com.peixin.mapper.AddressMapper;
import com.peixin.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> updateAddressState(Integer id) {

        Address oneAddress = addressMapper.selectById(id);
        int i = addressMapper.deleteById(id);
        Integer uid = oneAddress.getUid();
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("uid",uid);
        List<Address> addresses = addressMapper.selectList(wrapper);
        return addresses;
    }
}
