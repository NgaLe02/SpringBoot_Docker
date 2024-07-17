package com.docker.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HelloDAO {
	String getName();
}
