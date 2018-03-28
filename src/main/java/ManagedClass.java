import dao.AbstractDAO;
import entities.Category;
import entities.Goods;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "managedClass")
@SessionScoped
public class ManagedClass implements Serializable {
    AbstractDAO<Integer,Goods> gdao = new AbstractDAO<Integer, Goods>();
    List<Goods> goods = gdao.selectAll(Goods.class);
    List<Category> categories;
    Goods good;
    Category category;

    public ManagedClass(){
//        AbstractDAO<Integer,Goods> gdao = new AbstractDAO<Integer, Goods>();
//        goods=gdao.selectAll(Goods.class);
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String editGoods(Goods good){
        //AbstractDAO<Integer,Category> cdao = new AbstractDAO<Integer, Category>();
        //Category cat = cdao.getByKey(Category.class,category.getIdcategory());
        //good.setCategoryByIdcategory(cat);
        gdao.update(good,good.getIdgoods());
        return null;
    }

    public Category updateGoodWithCateg(int id){
        AbstractDAO<Integer,Category> cdao = new AbstractDAO<Integer, Category>();
        Category category = cdao.getByKey(Category.class,id);
        return category;
    }
//
//    public String saveAction(){
//        for (Goods good:goods) {
//            good.setEditable(false);
//        }
//        return null;
//    }

}
