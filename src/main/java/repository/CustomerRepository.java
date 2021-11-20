package repository;

import domain.Customer;
import exceptions.CustomerIdNotFoundException;
import staticDataProviders.CustomerData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private static final List<Customer> customers= Arrays.asList(CustomerData.CUSTOMER_1,CustomerData.CUSTOMER_2);

    public static List<Customer> getAllCustomers()
    {
        return customers;
    }
    public static Customer getCustomerById(String  customerId)
    {
        Optional<Customer> matchingCustomer = customers.stream().filter(customer -> customer.getCustomerId().equalsIgnoreCase(customerId)).findFirst();
    if(matchingCustomer.isPresent())
        return matchingCustomer.get();
    else
        throw  new CustomerIdNotFoundException("Customer With Id "+customerId+" was not found");
    }

}
