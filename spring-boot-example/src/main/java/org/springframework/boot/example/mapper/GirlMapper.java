package org.springframework.boot.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.example.entity.Girl;

/**
 * <b>Girl Mapper</b>
 *
 * @author 11114396 lvyongwen
 * @date 2021-01-14 16:47
 * @since 1.0
 */
@Mapper
public interface GirlMapper extends CommonMapper<Girl> {

}
