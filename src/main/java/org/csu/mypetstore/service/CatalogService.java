package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.CategoryMapper;
import org.csu.mypetstore.persistence.ItemMapper;
import org.csu.mypetstore.persistence.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ItemMapper itemMapper;

    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryMapper.getCategory(categoryId);
    }

    public void addCategory(Category category){ categoryMapper.addCategory(category);}

    public void deleteCategory(Category category){ categoryMapper.deleteCategory(category);}

    public void updateCategory(Category category){ categoryMapper.updateCategory(category);}

    public Product getProduct(String productId) {
        return productMapper.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productMapper.getProductListByCategory(categoryId);
    }

    public List<Product> getProductList(){return productMapper.getProductList();}

    public void insertProduct(Product product){productMapper.insertProduct(product);}

    public void deleteProduct(Product product){productMapper.deleteProduct(product);}

    public void updateProduct(Product product){productMapper.updateProduct(product);}

    public List<Item> getItemList(){return itemMapper.getItemList();}

    public void insertItem(Item item){itemMapper.insertItem(item);}

    public void deleteItem(Item item){itemMapper.deleteItem(item);}

    public void updateItem(Item item){itemMapper.updateItem(item);}

    public List<Product> searchProductList(String keyword) {
        return productMapper.searchProductList("%" + keyword.toLowerCase() + "%");
    }

    public List<Item> getItemListByProduct(String productId)
    {
        List<Item> list = itemMapper.getItemListByProduct(productId);
        for (Item item:list
             ) {
            item.setInventory(itemMapper.getInventoryQuantity(item.getItemId()));
        }
        //将数量添加到项目中
        return list;
    }

    public Item getItem(String itemId){
        Item item = itemMapper.getItem(itemId);
        item.setInventory(itemMapper.getInventoryQuantity(item.getItemId()));
        return item;
    }

    public boolean isItemInStock(String itemId){
        return itemMapper.getInventoryQuantity(itemId) > 0;
    }

    public int getInventoryById(String itemId)
    {
        return itemMapper.getInventoryQuantity(itemId);
    }
}
