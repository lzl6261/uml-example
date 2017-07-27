package com.databps.admin.service.mapper;

import com.databps.admin.domain.Author;
import com.databps.admin.vo.AuthorVO;
import org.mapstruct.Mapper;
/**
 * @author merlin
 * @create 2017-07-26 上午1:14
 */
@Mapper(componentModel = "spring")
public interface AuthorMapper extends EntityMapper <AuthorVO, Author> {
}
