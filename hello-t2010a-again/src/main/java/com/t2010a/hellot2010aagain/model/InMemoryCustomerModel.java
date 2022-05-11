package com.t2010a.hellot2010aagain.model;

import com.t2010a.hellot2010aagain.entity.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InMemoryCustomerModel implements CustomerModel{
    
    private static List<Customer> customers;
    
    public InMemoryCustomerModel(){
        customers = new ArrayList<>();
        customers.add(
                new Customer(
                        "T001",
                        "Thanh",
                        "0912345678",
                        "Thanh.jpg",
                        LocalDateTime.of(2002, 11, 23, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        customers.add(
                new Customer(
                        "T002",
                        "Dat",
                        "0912365895",
                        "Dat.jpg",
                        LocalDateTime.of(2002, 6, 15, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
        customers.add(
                new Customer(
                        "T003",
                        "Phuc",
                        "0912375846",
                        "Phuc.jpg",
                        LocalDateTime.of(2002, 7, 20, 0, 0),
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        1)
        );
    }
    
    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(String ID) {
        Customer foundCustomer = null;
        for (Customer customer :
                customers) {
            if (customer.getID().equals(ID)) {
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;
    }

    @Override
    public Customer update(String ID, Customer updateCustomer) {
        Customer existingStudent = findById(ID);
        if(existingStudent == null){
            return null;
        }
        existingStudent.setName(updateCustomer.getName());
        existingStudent.setPhone(updateCustomer.getPhone());
        existingStudent.setImage(updateCustomer.getImage());
        existingStudent.setDob(updateCustomer.getDob());
        existingStudent.setUpdatedAt(LocalDateTime.now());
        existingStudent.setStatus(updateCustomer.getStatus());
        return existingStudent;
    }

    @Override
    public boolean delete(String ID) {
        int foundIndex = -1;
        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getID().equals(ID)){
                foundIndex = i;
            }
        }
        if(foundIndex != -1){
            customers.remove(foundIndex);
            return true;
        }
        return false;
    }
}
