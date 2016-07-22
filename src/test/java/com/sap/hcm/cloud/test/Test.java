package com.sap.hcm.cloud.test;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.sap.hcm.cloud.entity.Address;
import com.sap.hcm.cloud.entity.Customer;

public class Test {

  public static void main(String[] args) throws Exception {
    EntityManagerFactory factory = Persistence
        .createEntityManagerFactory("web-persistence");
    EntityManager em = factory.createEntityManager();
    em.getTransaction().begin();
    
    for (int i = 0; i < 3; i++) {
      Customer customer = new Customer();
      customer.setName("customer" + i);
      customer.setEmail("customer" + i + "@my.com");
      customer.setBirthday(Calendar.getInstance().getTime());

      Address addressHome = new Address();
      addressHome.setName("Home" + i);
      addressHome.setDescription("Home" + i);
      addressHome.setZipcode("123456" + i);
      em.persist(addressHome);

      Address addressOffice = new Address();
      addressOffice.setName("Office" + i);
      addressOffice.setDescription("Office" + i);
      addressOffice.setZipcode("654321" + i);
      em.persist(addressOffice);

      customer.addAddress(addressHome);
      customer.addAddress(addressOffice);
      em.persist(customer);
    }
    em.getTransaction().commit();
    em.close();

    em = factory.createEntityManager();
    TypedQuery<Customer> q = em.createQuery("select c from Customer c",
        Customer.class);
    List<Customer> customers = q.getResultList();
    for (Customer c : customers) {
      System.out.println(c);
    }
    em.close();
  }

}
