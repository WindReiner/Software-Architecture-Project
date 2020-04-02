package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.persistance.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatelogService {

    @Autowired
    private CategoryMapper categoryMapper;

    public Category getCategory(String categoryId)
    {
        return categoryMapper.getCategory(categoryId);
    }
}