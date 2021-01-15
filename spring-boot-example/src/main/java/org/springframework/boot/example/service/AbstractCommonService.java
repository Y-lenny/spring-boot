package org.springframework.boot.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.boot.example.mapper.CommonMapper;

/**
 * <b>通用Service接口</b>
 *
 * @author 11114396 lvyongwen
 * @date 2021-01-14 17:01
 * @since 1.0
 */
public abstract class AbstractCommonService<M extends CommonMapper<T>, T> extends ServiceImpl<M, T> implements CommonService<T> {
}
