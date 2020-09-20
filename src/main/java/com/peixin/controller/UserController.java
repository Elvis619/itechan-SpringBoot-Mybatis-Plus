package com.peixin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.peixin.entity.Address;
import com.peixin.entity.Orders;
import com.peixin.entity.User;
import com.peixin.mapper.AddressMapper;
import com.peixin.service.AddressService;
import com.peixin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private AddressService addressService;

    @GetMapping("/findAll/{pageNO}/{size}")
    public Object findAll(@PathVariable("pageNO") Integer pageNO, @PathVariable("size") Integer size){
        return userService.findAll(pageNO,size);
    }
    @GetMapping("/findByUserName/{username}")
    public User fingByUsername(@PathVariable("username") String username){
        return userService.fingByUsername(username);
    }
    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        Integer user1 = userService.updateUser(user);
        return user1 == 1 ? "success":"error";
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        userService.deleteById(id);
    }
    @PostMapping("/save")
    public String save(@RequestBody User user){
        String result = userService.save(user);
        return result;
    }
    //小程序登录接口
    @GetMapping("/login")
    public String login(String username,String password){
        String s = userService.login(username, password);
        return s;
    }
    @GetMapping("/userAddress/{id}")
    public List<Address> addressList(@PathVariable("id") Integer id){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("uid",id);
        List<Address>  userAddressList= addressMapper.selectList(wrapper);
        return userAddressList;
    }
    @GetMapping("/addressUpdateState/{id}")
    public List<Address> addressUpdateState(@PathVariable("id") Integer id){
        List<Address> addresses = addressService.updateAddressState(id);
        return addresses;
    }
    @GetMapping("/addressFindById/{id}")
    public Address findById(@PathVariable("id") Integer id){
        Address address = addressMapper.selectById(id);
        return address;
    }
    @PutMapping("/editAddress")
    public int editAddress(@RequestBody Address address){
        int i = addressMapper.updateById(address);
        return i;
    }
    @PostMapping("/addressAdd")
    public int addressAdd(@RequestBody Address address){
        int i = addressMapper.insert(address);
        return i;
    }
    @GetMapping("/addressById/{id}")
    public Address addressById(@PathVariable("id") Integer id){
        Address address = addressMapper.selectById(id);
        return address;

    }
}
