package com.api.common;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
public class BasicResource extends EntityModel<Object> {


	public BasicResource(Object object) {
        super(object);
        add(new Link("/").withRel("index"));
        add(new Link("/docs/index").withRel("profile"));
    }

    public BasicResource() {
        add(new Link("/").withRel("index"));
        add(new Link("/docs/index").withRel("profile"));
    }
}