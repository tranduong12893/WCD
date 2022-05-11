package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Customer;

import java.util.List;

public interface CustomerModel {
    Customer save(Customer customer); // lưu thông tin.

    List<Customer> findAll();

    Customer findById(String ID);

    Customer update(String ID, Customer updateCustomer);

    boolean delete(String ID);
}
