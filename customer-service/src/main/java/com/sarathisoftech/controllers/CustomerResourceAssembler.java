/*
package com.sarathisoftech.controllers;

import com.sarathisoftech.entity.Customer;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

//import static org.springframework.hateoas.jaxrs.JaxRsLinkBuilder.linkTo;

@Component
public class CustomerResourceAssembler implements ResourceAssembler<Customer, Resource<Customer>> {


    @Override
    public Resource<Customer> toResource(Customer customer) {
        Resource<Customer> resource = new Resource<>(customer);
        addLinks(resource);

        return resource;
    }

    private void addLinks(Resource<Customer> resource) {
        resource.add(linkTo(CustomerServiceResource.class).slash(resource.getContent()).withSelfRel());
    }
}
*/
