/*
package com.lulski.blog.sage.user;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
public class UserRepresentationModelAssembler extends RepresentationModelAssemblerSupport<User,UserModel> {

    public UserRepresentationModelAssembler(){
        super(UserController.class, UserModel.class);
    }

    @Override
    public UserModel toModel(User entity) {
        UserModel userModel = instantiateModel(entity);

        userModel.add(linkTo(methodOn(UserController.class).getUserById(entity.getId())).withSelfRel());

        return userModel;
    }

    @Override
    public CollectionModel<UserModel> toCollectionModel(Iterable<? extends User> entities) {
        CollectionModel<UserModel> userModels = super.toCollectionModel(entities);
        userModels.add(linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());

        return userModels;
    }
}
*/
