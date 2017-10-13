package br.net.softwave.server.repository;

import br.net.softwave.server.entity.BlogEntity;

public class BlogRepository extends Repository<BlogEntity> {
	
	public BlogRepository() {
		super(BlogEntity.class);
	}
	
}
