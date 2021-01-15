package org.springframework.boot.example.service.impl;

import org.springframework.boot.example.entity.Girl;
import org.springframework.boot.example.mapper.GirlMapper;
import org.springframework.boot.example.service.AbstractCommonService;
import org.springframework.boot.example.service.GirlService;
import org.springframework.stereotype.Service;

/**
 * <b>Girl Service Implements</b>
 *
 * @author 11114396 lvyongwen
 * @date 2021-01-14 16:46
 * @since 1.0
 */
@Service
public class GirlServiceImpl extends AbstractCommonService<GirlMapper, Girl> implements GirlService {
}
